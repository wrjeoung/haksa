package dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface HakgiDao {
	public List sungjuklist(Map params) throws DataAccessException;
}
