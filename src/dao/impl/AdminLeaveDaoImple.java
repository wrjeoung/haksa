package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Leave;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.AdminLeaveDao;

public class AdminLeaveDaoImple extends JdbcDaoSupport implements AdminLeaveDao{

	@Override
	public List getAdminLeaveList() throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from leave order by name desc";
		RowMapper rowMapper=new AdminLeaveRowMapper();
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class AdminLeaveRowMapper implements RowMapper{
		private List adminleaveList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return adminleaveList;
		}
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Leave leave=new Leave();
			leave.setNum(rs.getInt("num"));
			leave.setLeavegubun(rs.getString("leavegubun"));
			leave.setLeavehak(rs.getString("leavehak"));
			leave.setLeavehak2(rs.getString("leavehak2"));
			leave.setLeavehak3(rs.getString("leavehak3"));
			leave.setLeavegyul(rs.getString("leavegyul"));
			leave.setLeavesayu(rs.getString("leavesayu"));
			leave.setLeavesayu2(rs.getString("leavesayu2"));
			leave.setLeaveday(rs.getString("leaveday"));
			leave.setLeave_reg_date(rs.getTimestamp("leave_reg_date"));
			leave.setLeavechuri(rs.getString("leavechuri"));
			leave.setName(rs.getString("name"));
			return leave;
		}
		
	}
	@Override
	public void updatecomAdminLeave(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE leave set leavechuri='신청완료' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void updatecanAdminLeave(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE leave set leavechuri='신청' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void deleteAdminLeave(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM leave where num="+value;
		getJdbcTemplate().update(sql);
	}
}
