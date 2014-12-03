package dao;

import java.util.List;
import java.util.HashMap;
import org.springframework.dao.DataAccessException;

public interface HakgiDao {
	public List getSungjuklist(HashMap params) throws DataAccessException;

}
