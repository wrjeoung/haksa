package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Jujungong2;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.AdminJujungongDao;
public class AdminJujungongDaoImple extends JdbcDaoSupport implements AdminJujungongDao{
	
	@Override
	public List getAdminJujungongList() throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from jujungong order by name desc";
		RowMapper rowMapper=new AdminJujungongRowMapper();
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class AdminJujungongRowMapper implements RowMapper{
		private List adminjujungongList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return adminjujungongList;
		}
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Jujungong2 jujungong2=new Jujungong2();
			jujungong2.setNum(rs.getInt("num"));
			jujungong2.setJujungonggubun(rs.getString("jujungonggubun"));
			jujungong2.setJujungonggyul(rs.getString("jujungonggyul"));
			jujungong2.setJujungongyear1(rs.getString("jujungongyear1"));
			jujungong2.setJujungongyear2(rs.getString("jujungongyear2"));
			jujungong2.setJujungongday(rs.getString("jujungongday"));
			jujungong2.setJujungong1(rs.getString("jujungong1"));
			jujungong2.setJujungong2(rs.getString("jujungong2"));
			jujungong2.setJujungong3(rs.getString("jujungong3"));
			jujungong2.setJujungong4(rs.getString("jujungong4"));
			jujungong2.setJujungong_reg_date(rs.getTimestamp("jujungong_reg_date"));
			jujungong2.setJujungongchuri(rs.getString("jujungongchuri"));
			jujungong2.setName(rs.getString("name"));
			return jujungong2;
		}
	}
	@Override
	public void updatecomAdminJujungong(String value)
			throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE jujungong set jujungongchuri='신청완료' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void updatecanAdminJujungong(String value)
			throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE jujungong set jujungongchuri='신청' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void deleteAdminJujungong(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM jujungong where num="+value;
		getJdbcTemplate().update(sql);
	}
}
