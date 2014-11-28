package dao.impl;

import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.MemberDao;

public class MemberDaoImpl extends JdbcDaoSupport implements MemberDao{
	
	@Override
	public int loginCheck(Map params) throws DataAccessException {
		String sql = "SELECT COUNT(*) FROM student_members "
				+ "WHERE stnumber='"+params.get("id")+"' AND pw='"+params.get("pw")+"'";
		return getJdbcTemplate().queryForInt(sql);
	}
}
