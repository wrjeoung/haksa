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

import dao.LeaveDao;

public class LeaveDaoImple extends JdbcDaoSupport implements LeaveDao{
	private InsertLeave insertLeave;
	public Leave leave;
	
	protected void initDao()throws Exception{
		this.insertLeave=new InsertLeave(getDataSource());
	}
	@Override
	public void insertLeave(Leave leave) throws DataAccessException {
		// TODO Auto-generated method stub
		this.insertLeave.update(new Object[]{leave.getLeavegubun(),leave.getLeavehak(),leave.getLeavehak2(),leave.getLeavehak3(),
				leave.getLeavegyul(),leave.getLeavesayu(),leave.getLeavesayu2(),leave.getLeaveday(),leave.getLeave_reg_date(),leave.getName()});
	}
	@Override
	public List getLeaveList(String studentNumber) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from leave where name='"+studentNumber+"'";
		RowMapper rowMapper=new LeaveRowMapper();
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class LeaveRowMapper implements RowMapper{
		private List leaveList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return leaveList;
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
	public void deleteLeave(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM leave where num="+value;
		getJdbcTemplate().update(sql);
	}
}
