package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Leave;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
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
	@Override
	public Leave getAdminLeave(int num) throws DataAccessException {
		// TODO Auto-generated method stub
		return (Leave)getJdbcTemplate().query(new AdminLeavePreparedStatementCreator(num), new AdminLeaveResultSetExtractor());
	}
	
	protected class AdminLeavePreparedStatementCreator implements PreparedStatementCreator{
		private Integer num;
		public AdminLeavePreparedStatementCreator(Integer num){
			this.num=num;
		}
		@Override
		public PreparedStatement createPreparedStatement(Connection con)
				throws SQLException {
			// TODO Auto-generated method stub
			final String sql="SELECT * FROM LEAVE where num=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, this.num);
			return ps;
		}
	}
	protected class AdminLeaveResultSetExtractor implements ResultSetExtractor{

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			// TODO Auto-generated method stub
			if(rs.next()){
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
			}else{
				return null;	
			}
		}
	}
	@Override
	public void changeAdminLeave(Leave params) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE leave SET leavegubun=?,leavehak=?,leavehak2=?,leavehak3=?,leavegyul=?,leavesayu=?,leavesayu2=?,leaveday=? WHERE num=?";
		String leavegubun=params.getLeavegubun();
		String leavehak=params.getLeavehak();
		String leavehak2=params.getLeavehak2();
		String leavehak3=params.getLeavehak3();
		String leavegyul=params.getLeavegyul();
		String leavesayu=params.getLeavesayu();
		String leavesayu2=params.getLeavesayu2();
		String leaveday=params.getLeaveday();
		int num=params.getNum();
		Object[] objs={leavegubun,leavehak,leavehak2,leavehak3,leavegyul,leavesayu,leavesayu2,leaveday,num};
		getJdbcTemplate().update(sql,objs);
	}
	@Override
	public void updateLeaveMember(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE student_members SET state='자퇴' WHERE stnumber='"+name+"'";
		getJdbcTemplate().update(sql);
	}
	@Override
	public void updateLeaveMember2(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE student_members SET state='재학중' WHERE stnumber='"+name+"'";
		getJdbcTemplate().update(sql);
	}
}
