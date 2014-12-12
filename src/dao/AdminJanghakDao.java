package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface AdminJanghakDao {
	public List getAdminJanghakList()throws DataAccessException;
	public void updatecomAdminJanghak(String value)throws DataAccessException;
	public void updatecanAdminJanghak(String value)throws DataAccessException;
	public void deleteAdminJanghak(String value)throws DataAccessException;
}
