package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface AdminMultijungongDao {
	public List getAdminMultijungongList()throws DataAccessException;
	public void updatecomAdminMultijungong(String value)throws DataAccessException;
	public void updatecanAdminMultijungong(String value)throws DataAccessException;
	public void deleteAdminMultijungong(String value)throws DataAccessException;
}
