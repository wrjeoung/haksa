package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Huhak;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.AdminHuhakDao;

public class AdminHuhakDaoImple extends JdbcDaoSupport implements AdminHuhakDao{
	public Huhak huhak;
	@Override
	public List getAdminHuhakList() throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from huhak order by name desc";
		RowMapper rowMapper=new AdminHuhakRowMapper();
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class AdminHuhakRowMapper implements RowMapper{
		private List adminhuhakList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return adminhuhakList;
		}
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Huhak huhak=new Huhak();
			
			huhak.setNum(rs.getInt("num"));
			huhak.setHugubun(rs.getString("hugubun"));
			huhak.setHusegubun(rs.getString("husegubun"));
			huhak.setHubokyear(rs.getString("hubokyear"));
			huhak.setHubokhak(rs.getString("hubokhak"));
			huhak.setHugrade(rs.getString("hugrade"));
			huhak.setHunumber(rs.getString("hunumber"));
			huhak.setHusayu(rs.getString("husayu"));
			huhak.setHuchuri(rs.getString("huchuri"));
			huhak.setHuhak_reg_date(rs.getTimestamp("huhak_reg_date"));
			huhak.setName(rs.getString("name"));
			return huhak;
		}
		
	}
	@Override
	public void updatecomAdminHuhak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE huhak set huchuri='신청완료' where num="+value;
		getJdbcTemplate().update(sql);
		
	}
	@Override
	public void updatecanAdminHuhak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE huhak set huchuri='신청' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void deleteAdminHuhak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM huhak where num="+value;
		getJdbcTemplate().update(sql);
	}
}
