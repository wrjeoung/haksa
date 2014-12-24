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

import dao.Jujungong2Dao;

public class Jujungong2DaoImple extends JdbcDaoSupport implements Jujungong2Dao{
	private InsertJujungong insertJujungong;
	public Jujungong2 jujungong2;
	
	protected void initDao()throws Exception{
		this.insertJujungong=new InsertJujungong(getDataSource());
	}
	@Override
	public void insertJujungong(Jujungong2 jujungong2)throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("12121 : "+jujungong2.getJujungonggubun()+" , "+jujungong2.getJujungonggyul()+" , "+jujungong2.getJujungongyear1()+" , "+jujungong2.getJujungongyear2()+" , "+jujungong2.getJujungongday()+" , "+jujungong2.getJujungong1()+" , "+jujungong2.getJujungong2()+" , "+jujungong2.getJujungong3()+" , "+jujungong2.getJujungong4()+" , "+jujungong2.getJujungong_reg_date());
		
		System.out.println("2322323 : "+this.insertJujungong);
		this.insertJujungong.update(new Object[]{jujungong2.getJujungonggubun(),jujungong2.getJujungonggyul(),jujungong2.getJujungongyear1(),jujungong2.getJujungongyear2(),jujungong2.getJujungongday(),jujungong2.getJujungong1(),jujungong2.getJujungong2(),jujungong2.getJujungong3(),jujungong2.getJujungong4(),jujungong2.getJujungong_reg_date(),jujungong2.getName()});	
		
	}
	@Override
	public List getJujungongList(String studentNumber) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from jujungong where name='"+studentNumber+"'"+"order by num desc";
		RowMapper rowMapper=new JujungongRowMapper();
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class JujungongRowMapper implements RowMapper{
		private List jujungongList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return jujungongList;
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
	public void deleteJujungong(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM jujungong where num="+value;
		getJdbcTemplate().update(sql);
	}
}
