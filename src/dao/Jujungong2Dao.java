package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Jujungong2;

public interface Jujungong2Dao {
	void insertJujungong(Jujungong2 jujungong2)throws DataAccessException;
	public List getJujungongList(String studentNumber)throws DataAccessException;
}
