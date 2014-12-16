package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Bokhak;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.BokhakDao;

public class BokhakDaoImple extends JdbcDaoSupport implements BokhakDao{
	private InsertBokhak insertBokhak;
	public Bokhak bokhak;
	
	protected void initDao()throws Exception{
		this.insertBokhak=new InsertBokhak(getDataSource());
	}
	@Override
	public void insertBokhak(Bokhak bokhak) throws DataAccessException {
		// TODO Auto-generated method stub
		this.insertBokhak.update(new Object[]{bokhak.getBokhakgi(),bokhak.getBokgubun(),bokhak.getBokyear(),
				bokhak.getBokyehakgi(),bokhak.getBoksayu(),bokhak.getBokhak_reg_date(),bokhak.getName()});
	}
	@Override
	public List getBokhakList(String studentNumber) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from bokhak where name='"+studentNumber+"'";
		RowMapper rowMapper=new BokhakRowMapper();
		
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class BokhakRowMapper implements RowMapper{
		private List bokhakList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return bokhakList;
		}
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Bokhak bokhak=new Bokhak();
			bokhak.setNum(rs.getInt("num"));
			bokhak.setBokhakgi(rs.getString("bokhakgi"));
			bokhak.setBokgubun(rs.getString("bokgubun"));
			bokhak.setBokyear(rs.getString("bokyear"));
			bokhak.setBokyehakgi(rs.getString("bokyehakgi"));
			bokhak.setBoksayu(rs.getString("boksayu"));
			bokhak.setBokhak_reg_date(rs.getTimestamp("bokhak_reg_date"));
			bokhak.setBokchuri(rs.getString("bokchuri"));
			bokhak.setName(rs.getString("name"));
			return bokhak;
		}
	}
	@Override
	public void deleteBokhak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM bokhak where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public Bokhak getBokhak(int num) throws DataAccessException {
		// TODO Auto-generated method stub
		return (Bokhak)getJdbcTemplate().query(new BokhakPreparedStatementCreator(num), new BokhakResultSetExtractor());
	}
	protected class BokhakPreparedStatementCreator implements PreparedStatementCreator{
		private Integer num;
		public BokhakPreparedStatementCreator(Integer num){
			this.num=num;
		}
		@Override
		public PreparedStatement createPreparedStatement(Connection con)
				throws SQLException {
			// TODO Auto-generated method stub
			final String sql="SELECT * FROM BOKHAK where num=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, this.num);
			return ps;
		}
	}
	protected class BokhakResultSetExtractor implements ResultSetExtractor{

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			// TODO Auto-generated method stub
			if(rs.next()){
				Bokhak bokhak=new Bokhak();
				bokhak.setNum(rs.getInt("num"));
				bokhak.setBokhakgi(rs.getString("bokhakgi"));
				bokhak.setBokgubun(rs.getString("bokgubun"));
				bokhak.setBokyear(rs.getString("bokyear"));
				bokhak.setBokyehakgi(rs.getString("bokyehakgi"));
				bokhak.setBoksayu(rs.getString("boksayu"));
				bokhak.setBokhak_reg_date(rs.getTimestamp("bokhak_reg_date"));
				bokhak.setBokchuri(rs.getString("bokchuri"));
				bokhak.setName(rs.getString("name"));
				return bokhak;
			}else{
				return null;
			}
		}
	}
	@Override
	public void changeBokhak(Bokhak params) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE bokhak SET bokhakgi=?,bokgubun=?,bokyear=?,bokyehakgi=?,boksayu=? WHERE num=?";
		String bokhakgi=params.getBokhakgi();
		String bokgubun=params.getBokgubun();
		String bokyear=params.getBokyear();
		String bokyehakgi=params.getBokyehakgi();
		String boksayu=params.getBoksayu();
		int num=params.getNum();
		Object[] objs={bokhakgi,bokgubun,bokyear,bokyehakgi,boksayu,num};
		getJdbcTemplate().update(sql,objs);
		
	}
}
