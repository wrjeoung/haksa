package dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface RegisterclassDao {

	List getRegisterclassList(HashMap params) throws DataAccessException;
}
