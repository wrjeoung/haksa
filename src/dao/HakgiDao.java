package dao;

import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;

public interface HakgiDao {
	List getSuperlist(Map<String, String> params) throws DataAccessException;
	 List getSungjuklist() throws DataAccessException;
	 List getAddyearlist() throws DataAccessException;
	 List getAddhakgilist() throws DataAccessException;
	 List getTotalList() throws DataAccessException;

}
