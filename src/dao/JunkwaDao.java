package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Junkwa;

public interface JunkwaDao {
	void insertJunkwa(Junkwa junkwa)throws DataAccessException;
	public List getJunkwaList(String studentNumber)throws DataAccessException;
	public void deleteJunkwa(String value)throws DataAccessException;
	//상세보기
	public Junkwa getJunkwa(int num)throws DataAccessException;
}
