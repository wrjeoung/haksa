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

import dao.AdminJanghakDao;

public class AdminJanghakDaoImple extends JdbcDaoSupport implements AdminJanghakDao{

	@Override
	public List getAdminJanghakList() throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from janghak order by name desc";
		RowMapper rowMapper=new AdminJanghakRowMapper();
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class AdminJanghakRowMapper implements RowMapper{
		private List adminjanghakList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return adminjanghakList;
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
			janghak.setName(rs.getString("name"));
			return janghak;
			
		}
	}
	@Override
	public void updatecomAdminJanghak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE janghak set janghakchuri='신청완료' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void updatecanAdminJanghak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE janghak set janghakchuri='신청' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void deleteAdminJanghak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM janghak where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public Janghak getAdminJanghak(int num) throws DataAccessException {
		// TODO Auto-generated method stub
		return (Janghak)getJdbcTemplate().query(new AdminJanghakPreparedStatementCreator(num), new AdminJanghakResultSetExtractor());
		
	}
	protected class AdminJanghakPreparedStatementCreator implements PreparedStatementCreator{
		private Integer num;
		public AdminJanghakPreparedStatementCreator(Integer num){
			this.num=num;
		}
		@Override
		public PreparedStatement createPreparedStatement(Connection con)
				throws SQLException {
			// TODO Auto-generated method stub
			final String sql="SELECT * FROM JANGHAK where num=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, this.num);
			return ps;
		}
	}
	protected class AdminJanghakResultSetExtractor implements ResultSetExtractor{

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
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
				janghak.setName(rs.getString("name"));
				return janghak;
			}else{
				return null;
			}
		}
		
	}
	@Override
	public void changeAdminJanghak(Janghak params) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE janghak SET janghakbank=?,janghakbanknum=?,janghakname=?,janghakmenu=?,janghakmy=? WHERE num=?";
		String janghakbank=params.getJanghakbank();
		String janghakbanknum=params.getJanghakbanknum();
		String janghakname=params.getJanghakname();
		String janghakmenu=params.getJanghakmenu();
		String janghakmy=params.getJanghakmy();
		int num=params.getNum();
		Object[] objs={janghakbank,janghakbanknum,janghakname,janghakmenu,janghakmy,num};
		getJdbcTemplate().update(sql, objs);
	}
}
