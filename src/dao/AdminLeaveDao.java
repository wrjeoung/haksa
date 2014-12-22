package dao;

import java.util.List;

import model.Leave;

import org.springframework.dao.DataAccessException;

public interface AdminLeaveDao {
	public List getAdminLeaveList()throws DataAccessException;
	public void updatecomAdminLeave(String value)throws DataAccessException;
	public void updatecanAdminLeave(String value)throws DataAccessException;
	public void deleteAdminLeave(String value)throws DataAccessException;
	//상세보기
	public Leave getAdminLeave(int num)throws DataAccessException;
	//수정
	public void changeAdminLeave(Leave params)throws DataAccessException;
	//자퇴
	public void updateLeaveMember(String name)throws DataAccessException;
	//되돌리기
	public void updateLeaveMember2(String name)throws DataAccessException;
}
