package dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface RegisterclassDao {

	public List getRegisterclassList(HashMap params) throws DataAccessException;
	public List getCulturalClassList(String major) throws DataAccessException;
}
