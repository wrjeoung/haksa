package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Multijungong;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.MultijungongDao;

public class MultijungongDaoImple extends JdbcDaoSupport implements MultijungongDao{
	private InsertMultijungong insertMultijungong;
	public Multijungong multijungong;
	
	protected void initDao()throws Exception{
		this.insertMultijungong=new InsertMultijungong(getDataSource());
	}
	@Override
	public void insertMultijungong(Multijungong multijungong)
			throws DataAccessException {
		// TODO Auto-generated method stub
		this.insertMultijungong.update(new Object[]{multijungong.getMultigubun(),multijungong.getMultigubun2(),multijungong.getMultiyear1(),multijungong.getMultiyear2(),multijungong.getMultiyear3(),multijungong.getMultijungong(),multijungong.getMultigyul(),multijungong.getMultisayu(),multijungong.getMultiday(),multijungong.getMulti_reg_date(),multijungong.getName()});
	}
	@Override
	public List getMultijungongList(String studentNumber) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from multijungong where name='"+studentNumber+"'"+"order by num desc";
		RowMapper rowMapper=new MultijungongRowMapper();
		return getJdbcTemplate().query(sql, rowMapper);
	}
	public class MultijungongRowMapper implements RowMapper{
		private List multijungongList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return multijungongList;
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
	public void deleteMultijungong(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM multijungong where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public Multijungong getMultijungong(int num) throws DataAccessException {
		// TODO Auto-generated method stub
		return (Multijungong)getJdbcTemplate().query(new MultijungongPreparedStatementCreator(num), new MultijungongResultSetExtractor());
	}
	protected class MultijungongPreparedStatementCreator implements PreparedStatementCreator{
		private Integer num;
		public MultijungongPreparedStatementCreator(Integer num){
			this.num=num;
		}
		@Override
		public PreparedStatement createPreparedStatement(Connection con)
				throws SQLException {
			// TODO Auto-generated method stub
			final String sql="SELECT * FROM MULTIJUNGONG where num=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, this.num);
			return ps;
		}
	}
	protected class MultijungongResultSetExtractor implements ResultSetExtractor{

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			// TODO Auto-generated method stub
			if(rs.next()){
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
			}else{
				return null;	
			}
		}
		
	}
	@Override
	public void changeMultijungong(Multijungong params)
			throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE multijungong SET multigubun=?,multigubun2=?,"
				+ "multiyear1=?,multiyear2=?,multiyear3=?,multijungong=?,"
				+ "multigyul=?,multisayu=?,multiday=? WHERE num=?";
		String multigubun=params.getMultigubun();
		String multigubun2=params.getMultigubun2();
		String multiyear1=params.getMultiyear1();
		String multiyear2=params.getMultiyear2();
		String multiyear3=params.getMultiyear3();
		String multijungong=params.getMultijungong();
		String multigyul=params.getMultigyul();
		String multisayu=params.getMultisayu();
		String multiday=params.getMultiday();
		int num=params.getNum();
		Object[] objs={multigubun,multigubun2,multiyear1,multiyear2,multiyear3,multijungong,multigyul,multisayu,multiday,num};
		getJdbcTemplate().update(sql, objs);
	}
}
