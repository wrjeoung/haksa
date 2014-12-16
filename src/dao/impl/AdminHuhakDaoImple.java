package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Huhak;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.AdminHuhakDao;
import dao.impl.HuhakDaoImple.HuhakPreparedStatementCreator;
import dao.impl.HuhakDaoImple.HuhakResultSetExtractor;

public class AdminHuhakDaoImple extends JdbcDaoSupport implements AdminHuhakDao{
	public Huhak huhak;
	@Override
	public List getAdminHuhakList() throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from huhak order by name desc";
		RowMapper rowMapper=new AdminHuhakRowMapper();
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class AdminHuhakRowMapper implements RowMapper{
		private List adminhuhakList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return adminhuhakList;
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
	public void updatecomAdminHuhak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE huhak set huchuri='신청완료' where num="+value;
		getJdbcTemplate().update(sql);
		
	}
	@Override
	public void updatecanAdminHuhak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE huhak set huchuri='신청' where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public void deleteAdminHuhak(String value) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM huhak where num="+value;
		getJdbcTemplate().update(sql);
	}
	@Override
	public Huhak getAdminHuhak(int num) throws DataAccessException {
		// TODO Auto-generated method stub
		return (Huhak)getJdbcTemplate().query(new AdminHuhakPreparedStatementCreator(num), new AdminHuhakResultSetExtractor());
	}
	protected class AdminHuhakPreparedStatementCreator implements PreparedStatementCreator{
		private Integer num;
		public AdminHuhakPreparedStatementCreator(Integer num){
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
	protected class AdminHuhakResultSetExtractor implements ResultSetExtractor{

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
	@Override
	public void changeAdminHuhak(Huhak params) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="UPDATE huhak SET hugubun=?,husegubun=?,hubokyear=?,hubokhak=?,hugrade=?,hunumber=?,husayu=? WHERE num=?";
		String hugubun=params.getHugubun();
		String husegubun=params.getHusegubun();
		String hubokyear=params.getHubokyear();
		String hubokhak=params.getHubokhak();
		String hugrade=params.getHugrade();
		String hunumber=params.getHunumber();
		String husayu=params.getHusayu();
		int num=params.getNum();
		Object[] objs={hugubun,husegubun,hubokyear,hubokhak,hugrade,hunumber,husayu,num};
		getJdbcTemplate().update(sql, objs);
	}
}
