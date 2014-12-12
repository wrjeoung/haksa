package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface AdminJujungongDao {
	public List getAdminJujungongList()throws DataAccessException;
	public void updatecomAdminJujungong(String value)throws DataAccessException;
	public void updatecanAdminJujungong(String value)throws DataAccessException;
	public void deleteAdminJujungong(String value)throws DataAccessException;
}
