package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import model.Huhak;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Controller;

import dao.HuhakDao;

public class HuhakDaoImple extends JdbcDaoSupport implements HuhakDao{
	private InsertHuhak insertHuhak;
	public Huhak huhak;

	protected void initDao()throws Exception{
		this.insertHuhak=new InsertHuhak(getDataSource());
	}
	
	@Override
	public void insertHuhak(Huhak huhak) throws DataAccessException {
		// TODO Auto-generated method stub
		this.insertHuhak.update(new Object[]{huhak.getHugubun(),huhak.getHusegubun(),huhak.getHubokyear(),huhak.getHubokhak(),
			huhak.getHugrade(),huhak.getHunumber(),huhak.getHusayu(),huhak.getHuhak_reg_date(),huhak.getName()});
	}

	@Override
	public List getHuhakList(String studentNumber) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from huhak where name='"+studentNumber+"'";
		RowMapper rowMapper=new HuhakRowMapper();
		return getJdbcTemplate().query(sql,rowMapper);
	}
	protected class HuhakRowMapper implements RowMapper{
		private List huhakList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return huhakList;
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
	public void deleteHuhak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		//System.out.println("되?");
		//System.out.println(rnum);
		String sql="DELETE FROM huhak where num="+value;
		//System.out.println("되?2");
		getJdbcTemplate().update(sql);
	}

	@Override
	public Huhak getHuhak(int num) throws DataAccessException {
		// TODO Auto-generated method stub
		return (Huhak)getJdbcTemplate().query(new HuhakPreparedStatementCreator(num), new HuhakResultSetExtractor());
	}
	protected class HuhakPreparedStatementCreator implements PreparedStatementCreator{
		private Integer num;
		public HuhakPreparedStatementCreator(Integer num){
			this.num=num;
		}
		@Override
		public PreparedStatement createPreparedStatement(Connection con)
				throws SQLException {
			// TODO Auto-generated method stub
			final String sql="SELECT * FROM HUHAK where num=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, this.num);
			return ps;
		}
	}
	protected class HuhakResultSetExtractor implements ResultSetExtractor{

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			// TODO Auto-generated method stub
			if(rs.next()){
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
			}else{
				return null;	
			}
		}
	}
}
