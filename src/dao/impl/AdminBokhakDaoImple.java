package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Bokhak;

import org.springframework.dao.DataAccessException;
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
}
