package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Leave;

public interface LeaveDao {
	void insertLeave(Leave leave)throws DataAccessException;
	public List getLeaveList()throws DataAccessException;
}