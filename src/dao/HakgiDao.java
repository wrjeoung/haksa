package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Hakgi;

import org.springframework.dao.DataAccessException;

public interface HakgiDao {
	List getSuperlist(Map<String, String> params) throws DataAccessException;
	 List getSungjuklist() throws DataAccessException;
	 List getAddyearlist() throws DataAccessException;
	 List getAddhakgilist() throws DataAccessException;
	 List getTotalList() throws DataAccessException;
	 List getHakgilist(HashMap params) throws DataAccessException;
	 public void insertHakgi(Hakgi hakgi) throws DataAccessException;
	 
	  
	 
	 
}
