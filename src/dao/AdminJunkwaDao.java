package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface AdminJunkwaDao {
	public List getAdminJunkwaList()throws DataAccessException;
	public void updatecomAdminJunkwa(String value)throws DataAccessException;
	public void updatecanAdminJunkwa(String value)throws DataAccessException;
	public void deleteAdminJunkwa(String value)throws DataAccessException;
}
