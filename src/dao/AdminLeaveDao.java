package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface AdminLeaveDao {
	public List getAdminLeaveList()throws DataAccessException;
	public void updatecomAdminLeave(String value)throws DataAccessException;
	public void updatecanAdminLeave(String value)throws DataAccessException;
	public void deleteAdminLeave(String value)throws DataAccessException;
}
