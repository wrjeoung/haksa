package dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

public interface FeelsuDao {
	
	public List getFeelsuList()throws DataAccessException;
	
}
