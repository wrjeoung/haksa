package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Leave;

public interface LeaveDao {
	void insertLeave(Leave leave)throws DataAccessException;
	public List getLeaveList(String studentNumber)throws DataAccessException;
	public void deleteLeave(String value)throws DataAccessException;
	//상세보기
	public Leave getLeave(int num)throws DataAccessException;
	//수정
	public void changeLeave(Leave params)throws DataAccessException;
}
