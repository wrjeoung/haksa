package dao;

import java.util.HashMap;
import java.util.List;

import model.Notice;
import model.Registerclass;

import org.springframework.dao.DataAccessException;

public interface RegisterclassDao {

	public List getRegisterclassList(HashMap params) throws DataAccessException;
	public List getCulturalClassList(String major) throws DataAccessException;
	public void updateExtraNum(String subjectnum) throws DataAccessException;
	public List getList(String stnumber) throws DataAccessException;
	public List<String> getSubjectNum(String stnumber) throws DataAccessException;
	public List getSumList(String stnumber) throws DataAccessException;
	public List getTotalList() throws DataAccessException;
	public void insertRegisterclass(Registerclass registerclass) throws DataAccessException;
	public void deleteList(String[] checkedNumList) throws DataAccessException;
}
