package dao.impl;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import model.Member;

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

	@Override
	public List pwCheck(Map params) throws DataAccessException {
		String sql = "SELECT * FROM student_members "
				+ "WHERE stnumber='"+params.get("id")+"' AND pw='"+params.get("pw")+"'";
			return getJdbcTemplate().queryForList(sql);
	}
		
	@Override
	public int changePw(Member params) throws DataAccessException {
		String sql ="UPDATE student_members SET pw=? WHERE stnumber=?";
		String pw=params.getPassword();
		String stnum=params.getStudentNumber();
		Object[] objs = {pw,stnum};		
		int[] types = {Types.VARCHAR,Types.VARCHAR};
		return getJdbcTemplate().update(sql, objs, types);
	}
}
