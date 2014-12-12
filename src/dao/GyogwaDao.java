package dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

public interface GyogwaDao {
	 List getGyogwalist()throws DataAccessException;

}
