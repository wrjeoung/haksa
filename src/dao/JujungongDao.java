package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface JujungongDao {
	public List getList(String major)throws DataAccessException;
}
