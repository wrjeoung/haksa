package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface AdminBokhakDao {
	public List getAdminBokhakList()throws DataAccessException;
	public void updatecomAdminBokhak(String value)throws DataAccessException;
	public void updatecanAdminBokhak(String value)throws DataAccessException;
	public void deleteAdminBokhak(String value)throws DataAccessException;
}
