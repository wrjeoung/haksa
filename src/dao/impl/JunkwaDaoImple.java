package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Junkwa;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.JunkwaDao;

public class JunkwaDaoImple extends JdbcDaoSupport implements JunkwaDao{
	private InsertJunkwa insertJunkwa;
	public Junkwa junkwa;
	
	protected void initDao()throws Exception{
		this.insertJunkwa=new InsertJunkwa(getDataSource());
	}
	@Override
	public void insertJunkwa(Junkwa junkwa) throws DataAccessException {
		// TODO Auto-generated method stub
		   this.insertJunkwa.update(new Object[]{junkwa.getJunkwayear(),junkwa.getJunkwahakgi(),junkwa.getJunkwahakkwa(),junkwa.getJunkwa_reg_date(),junkwa.getJunkwabygo(),junkwa.getJunkwachuday()});
	}
	@Override
	public List getJunkwaList() throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from junkwa order by junkwa_reg_date desc";
		RowMapper rowMapper=new JunkwaRowMapper();
		
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class JunkwaRowMapper implements RowMapper{
		private List junkwaList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		public List getResults(){
			return junkwaList;
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
			return junkwa;
		}
		
	}
}