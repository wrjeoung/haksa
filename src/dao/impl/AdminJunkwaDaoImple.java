package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Junkwa;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.AdminJunkwaDao;

public class AdminJunkwaDaoImple extends JdbcDaoSupport implements AdminJunkwaDao{

	@Override
	public List getAdminJunkwaList() throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from junkwa order by name desc";
		RowMapper rowMapper=new AdminJunkwaRowMapper();
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class AdminJunkwaRowMapper implements RowMapper{
		private List adminjunkwaList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		public List getResults(){
			return adminjunkwaList;
		}
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Junkwa junkwa=new Junkwa();
			
			junkwa.setNum(rs.getInt("num"));
			junkwa.setJunkwayear(rs.getString("junkwayear"));
			junkwa.setJunkwahakgi(rs.getString("junkwahakgi"));
			junkwa.setJunkwahakkwa(rs.getString("junkwahakkwa"));
			junkwa.setJunkwa_reg_date(rs.getTimestamp("junkwa_reg_date"));
			junkwa.setJunkwabygo(rs.getString("junkwabygo"));
			junkwa.setJunkwachuri(rs.getString("junkwachuri"));
			junkwa.setJunkwachuday(rs.getString("junkwachuday"));
			junkwa.setName(rs.getString("name"));
			return junkwa;
		}
	}
	@Override
	public void updatecomAdminJunkwa(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE junkwa set junkwachuri='신청완료' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void updatecanAdminJunkwa(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE junkwa set junkwachuri='신청' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void deleteAdminJunkwa(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM junkwa where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public Junkwa getAdminJunkwa(int num) throws DataAccessException {
		// TODO Auto-generated method stub
		return (Junkwa)getJdbcTemplate().query(new JunkwaPreparedStatementCreator(num), new JunkwaResultSetExtractor());
	}
	protected class JunkwaPreparedStatementCreator implements PreparedStatementCreator{
		private Integer num;
		public JunkwaPreparedStatementCreator(Integer num){
			this.num=num;
		}
		@Override
		public PreparedStatement createPreparedStatement(Connection con)
				throws SQLException {
			// TODO Auto-generated method stub
			final String sql="SELECT * FROM junkwa where num=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, this.num);
			return ps;
		}
	}
	protected class JunkwaResultSetExtractor implements ResultSetExtractor{

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			// TODO Auto-generated method stub
			if(rs.next()){
				Junkwa junkwa=new Junkwa();
				
				junkwa.setNum(rs.getInt("num"));
				junkwa.setJunkwayear(rs.getString("junkwayear"));
				junkwa.setJunkwahakgi(rs.getString("junkwahakgi"));
				junkwa.setJunkwahakkwa(rs.getString("junkwahakkwa"));
				junkwa.setJunkwa_reg_date(rs.getTimestamp("junkwa_reg_date"));
				junkwa.setJunkwabygo(rs.getString("junkwabygo"));
				junkwa.setJunkwachuri(rs.getString("junkwachuri"));
				junkwa.setJunkwachuday(rs.getString("junkwachuday"));
				junkwa.setName(rs.getString("name"));
				return junkwa;
			}else{
			return null;
			}
		}
		
	}
}
