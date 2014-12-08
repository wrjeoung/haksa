package dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

public interface GraduationDao {
	
	public List getGraduationList()throws DataAccessException;
	
}
