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

import dao.AdminBokhakDao;

public class AdminBokhakDaoImple extends JdbcDaoSupport implements AdminBokhakDao{

	@Override
	public List getAdminBokhakList() throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from bokhak order by name desc";
		RowMapper rowMapper=new AdminBokhakRowMapper();
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class AdminBokhakRowMapper implements RowMapper{
		private List adminbokhakList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return adminbokhakList;
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
	public void updatecomAdminBokhak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE bokhak set bokchuri='신청완료' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void updatecanAdminBokhak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE bokhak set bokchuri='신청' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void deleteAdminBokhak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM bokhak where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public Bokhak getAdminBokhak(int num) throws DataAccessException {
		// TODO Auto-generated method stub
		return (Bokhak)getJdbcTemplate().query(new AdminBokhakPreparedStatementCreator(num), new AdminBokhakResultSetExtractor());
	}
	protected class AdminBokhakPreparedStatementCreator implements PreparedStatementCreator{
		private Integer num;
		public AdminBokhakPreparedStatementCreator(Integer num){
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
	protected class AdminBokhakResultSetExtractor implements ResultSetExtractor{

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
}
