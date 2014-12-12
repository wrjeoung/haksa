package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface AdminHuhakDao {
	public List getAdminHuhakList()throws DataAccessException;
	public void updatecomAdminHuhak(String value)throws DataAccessException;
	public void updatecanAdminHuhak(String value)throws DataAccessException;
	public void deleteAdminHuhak(String value)throws DataAccessException;
}
