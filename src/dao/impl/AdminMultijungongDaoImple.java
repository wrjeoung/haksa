package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Multijungong;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.AdminMultijungongDao;

public class AdminMultijungongDaoImple extends JdbcDaoSupport implements AdminMultijungongDao{

	@Override
	public List getAdminMultijungongList() throws DataAccessException {
		// TODO Auto-generated method stub
		//MULTICHURI
		String sql="select * from multijungong order by name desc";
		RowMapper rowMapper=new AdminMultijungongRowMapper();
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class AdminMultijungongRowMapper implements RowMapper{
		private List adminmultijungongList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return adminmultijungongList;
		}
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Multijungong multijungong=new Multijungong();
			multijungong.setNum(rs.getInt("num"));
			multijungong.setMultigubun(rs.getString("multigubun"));
			multijungong.setMultigubun2(rs.getString("multigubun2"));
			multijungong.setMultiyear1(rs.getString("multiyear1"));
			multijungong.setMultiyear2(rs.getString("multiyear2"));
			multijungong.setMultiyear3(rs.getString("multiyear3"));
			multijungong.setMultijungong(rs.getString("multijungong"));
			multijungong.setMultigyul(rs.getString("multigyul"));
			multijungong.setMultisayu(rs.getString("multisayu"));
			multijungong.setMultiday(rs.getString("multiday"));
			multijungong.setMulti_reg_date(rs.getTimestamp("multi_reg_date"));
			multijungong.setMultichuri(rs.getString("multichuri"));
			multijungong.setName(rs.getString("name"));
			return multijungong;
		}
		
	}
	@Override
	public void updatecomAdminMultijungong(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE multijungong set multichuri='신청완료' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void updatecanAdminMultijungong(String value)
			throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE multijungong set multichuri='신청' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void deleteAdminMultijungong(String value)
			throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM multijungong where num="+value;
		getJdbcTemplate().update(sql);
	}
}
