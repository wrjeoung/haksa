package dao;

import java.util.List;

import model.Junkwa;

import org.springframework.dao.DataAccessException;

public interface AdminJunkwaDao {
	public List getAdminJunkwaList()throws DataAccessException;
	public void updatecomAdminJunkwa(String value)throws DataAccessException;
	public void updatecanAdminJunkwa(String value)throws DataAccessException;
	public void deleteAdminJunkwa(String value)throws DataAccessException;
	//상세보기
	public Junkwa getAdminJunkwa(int num)throws DataAccessException;
	//수정
	public void changeAdminJunkwa(Junkwa params)throws DataAccessException;
}
