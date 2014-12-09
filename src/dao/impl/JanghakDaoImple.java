package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Janghak;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.JanghakDao;

public class JanghakDaoImple extends JdbcDaoSupport implements JanghakDao{
	private InsertJanghak insertJanghak;
	public Janghak janghak;
	
	protected void initDao()throws Exception{
		this.insertJanghak=new InsertJanghak(getDataSource());
	}
	@Override
	public void insertJanghak(Janghak janghak) throws DataAccessException {
		// TODO Auto-generated method stub
		this.insertJanghak.update(new Object[]{janghak.getJanghakbank(),janghak.getJanghakbanknum(),janghak.getJanghakname(),janghak.getJanghakmenu(),janghak.getJanghakmy(),janghak.getJanghak_reg_date()});
	}
	@Override
	public List getJanghakList() throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from janghak order by janghak_reg_date desc";
		RowMapper rowMapper=new JanghakRowMapper();
		return getJdbcTemplate().query(sql, rowMapper);
		
	}
	protected class JanghakRowMapper implements RowMapper{
		private List janghakList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return janghakList;
		}
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Janghak janghak=new Janghak();
			
			janghak.setNum(rs.getInt("num"));
			janghak.setJanghakbank(rs.getString("janghakbank"));
			janghak.setJanghakbanknum(rs.getString("janghakbanknum"));
			janghak.setJanghakname(rs.getString("janghakname"));
			janghak.setJanghakmenu(rs.getString("janghakmenu"));
			janghak.setJanghakmy(rs.getString("janghakmy"));
			janghak.setJanghakchuri(rs.getString("janghakchuri"));
			janghak.setJanghak_reg_date(rs.getTimestamp("janghak_reg_date"));
			return janghak;
		}
		
	}
	@Override
	public Janghak getJanghak(int num) throws DataAccessException {
		// TODO Auto-generated method stub
		return (Janghak)getJdbcTemplate().query(new JanghakPreparedStatementCreator(num),
				new JanghakResultSetExtractor());
	}
	protected class JanghakPreparedStatementCreator implements PreparedStatementCreator{
		private Integer num;
		
		public JanghakPreparedStatementCreator(Integer num){
			this.num=num;
		}
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			// TODO Auto-generated method stub
			final String sql="SELECT * FROM JANGHAK where num=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, this.num);
			return ps;
		}
	}
	protected class JanghakResultSetExtractor implements ResultSetExtractor{

		@Override
		public Object extractData(ResultSet rs) throws SQLException,DataAccessException {
			// TODO Auto-generated method stub
			if(rs.next()){
				Janghak janghak=new Janghak();
				janghak.setNum(rs.getInt("num"));
				janghak.setJanghakbank(rs.getString("janghakbank"));
				janghak.setJanghakbanknum(rs.getString("janghakbanknum"));
				janghak.setJanghakname(rs.getString("janghakname"));
				janghak.setJanghakmenu(rs.getString("janghakmenu"));
				janghak.setJanghakmy(rs.getString("janghakmy"));
				janghak.setJanghakchuri(rs.getString("janghakchuri"));
				janghak.setJanghak_reg_date(rs.getTimestamp("janghak_reg_date"));
				return janghak;
			}else{
				return null;
			}
		}
	}
}