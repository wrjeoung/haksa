package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Sungjuk;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.HakgiDao;

public class HakgiDaoImpl extends JdbcDaoSupport implements HakgiDao{
	
	@Override
	public List getSuperlist(Map<String, String> params) throws DataAccessException {
		RowMapper rowMapper = new HakgiRowMapper();
		String sql = "SELECT * FROM student_sunglist "
				+ "WHERE year='"+params.get("year")+"' AND hakgi='"+params.get("hakgi")+"'";
		return getJdbcTemplate().queryForList(sql); 
	}
	
	@Override
	public List getSungjuklist() throws DataAccessException {
		RowMapper rowMapper = new HakgiRowMapper();
		return getJdbcTemplate().query("SELECT * FROM student_sunglist",rowMapper);
														
	}
	
	@Override
	public List getAddyearlist() throws DataAccessException {
		RowMapper rowMapper = new HakgiRowMapper2();
		return getJdbcTemplate().query("SELECT distinct year FROM student_sunglist order by year",rowMapper);
														//jsp파일에서 셀렉트 메뉴 선택시 년도 중복값제거해서 가져오기.
	}											
	
	@Override
	public List getAddhakgilist() throws DataAccessException {
		RowMapper rowMapper = new HakgiRowMapper3();
		return getJdbcTemplate().query("SELECT distinct hakgi FROM student_sunglist",rowMapper);
														//jsp파일에서 셀렉트 메뉴 선택시 학기 중복값제거해서 가져오기. 
	}
	
	protected class HakgiRowMapper implements RowMapper{

		private List hakgiList = new ArrayList();
		
		public List getResults(){
			return hakgiList;
		}
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Sungjuk sungjuk = new Sungjuk();
			sungjuk.setHakbun(rs.getInt("hakbun"));
			sungjuk.setYear(rs.getString("year"));
			sungjuk.setHakgi(rs.getString("hakgi"));
			sungjuk.setGwamokcode(rs.getString("gwamokcode"));
			sungjuk.setBan(rs.getString("ban"));
			sungjuk.setGwamok_nm(rs.getString("gwamok_nm"));
			sungjuk.setIsugubun(rs.getString("isugubun"));
			sungjuk.setHakjum(rs.getString("hakjum"));
			sungjuk.setLevels(rs.getString("levels"));
			sungjuk.setBigo(rs.getString("bigo"));

			return sungjuk;
		}
		
	}
	
	protected class HakgiRowMapper2 implements RowMapper{

		private List hakgiList = new ArrayList();
		
		public List getResults(){
			return hakgiList;
		}
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Sungjuk sungjuk = new Sungjuk();
			sungjuk.setYear(rs.getString("year"));
			
			return sungjuk;
		}
		
	}
	
	protected class HakgiRowMapper3 implements RowMapper{

		private List hakgiList = new ArrayList();
		
		public List getResults(){
			return hakgiList;
		}
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Sungjuk sungjuk = new Sungjuk();
			sungjuk.setHakgi(rs.getString("hakgi"));
			return sungjuk;
		}
		
	}
	
}
