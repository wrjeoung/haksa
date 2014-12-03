package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Sungjuk;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import dao.HakgiDao;

public class HakgiDaoImpl extends JdbcDaoSupport implements HakgiDao{
	
	@Override
	public List getSungjuklist(HashMap params) throws DataAccessException {
		RowMapper rowMapper = new HakgiRowMapper();
		String sql = "SELECT * FROM student_sunglist "
				+ "WHERE year='"+params.get("year")+"' AND hakgi='"+params.get("hakgi")+"'";
		return getJdbcTemplate().query(sql,rowMapper);
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
			sungjuk.setYear(rs.getInt("year"));
			sungjuk.setHakgi(rs.getInt("hakgi"));
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
}







