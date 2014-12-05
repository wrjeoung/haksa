package dao;

import org.springframework.dao.DataAccessException;

public interface RegisterForCoursesDao {
	public void insertRegisterclass(String subjectnum, String stnumber) throws DataAccessException;
}
