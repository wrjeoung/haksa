package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Junkwa;

public interface JunkwaDao {
	void insertJunkwa(Junkwa junkwa)throws DataAccessException;
	public List getJunkwaList()throws DataAccessException;
}
