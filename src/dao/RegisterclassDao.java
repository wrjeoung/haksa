package dao;

import java.util.HashMap;
import java.util.List;
import model.Notice;

import org.springframework.dao.DataAccessException;

public interface RegisterclassDao {

	public List getRegisterclassList(HashMap params) throws DataAccessException;
	public List getCulturalClassList(String major) throws DataAccessException;
	public void updateExtraNum(String subjectnum) throws DataAccessException;
	public List getList(String stnumber) throws DataAccessException;
}
