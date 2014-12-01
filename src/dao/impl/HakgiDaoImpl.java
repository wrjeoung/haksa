package dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.HakgiDao;

public class HakgiDaoImpl extends JdbcDaoSupport implements HakgiDao{
	
	@Override
	public List sungjuklist(Map params) throws DataAccessException {
		String sql = "SELECT * FROM student_sunglist "
				+ "WHERE year='"+params.get("year")+"' AND hakgi='"+params.get("hakgi")+"'";
		return getJdbcTemplate().queryForList(sql);
	}
}
