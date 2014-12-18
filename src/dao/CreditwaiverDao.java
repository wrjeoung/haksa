package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Hakgi;

import org.springframework.dao.DataAccessException;

public interface CreditwaiverDao {
	 List getSuperlist(Map<String, String> params) throws DataAccessException;
	 List getSungjuklist() throws DataAccessException;
	 List getAddyearlist() throws DataAccessException;
	 List getAddhakgilist() throws DataAccessException;
	 List getTotalList(HashMap params) throws DataAccessException;
	 List getHakgilist(HashMap params) throws DataAccessException;
	 //학점포기
	 public void deleteCredits(String subjectnum)throws DataAccessException;
	 public Hakgi selectCredits(String subjectnum)throws DataAccessException;
}
