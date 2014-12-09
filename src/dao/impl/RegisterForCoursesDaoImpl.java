package dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.RegisterForCoursesDao;

public class RegisterForCoursesDaoImpl  extends JdbcDaoSupport implements RegisterForCoursesDao{

	@Override
	public void insertRegisterclass(String subjectnum, String stnumber)
			throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("num " + subjectnum + " number : " + stnumber);
		String sql = "INSERT INTO registerforcourses(subjectnum,stnumber) VALUES(?, ?)";
		getJdbcTemplate().update(sql, new Object[]{subjectnum,stnumber});
	}

	@Override
	public void deleteRegisterclass(String subjectnum, String stnumber)
			throws DataAccessException {
		// TODO Auto-generated method stub
		String sql = "delete from registerforcourses where subjectnum = ? and stnumber = ?";
		getJdbcTemplate().update(sql, new Object[]{subjectnum, stnumber});
	}
}
