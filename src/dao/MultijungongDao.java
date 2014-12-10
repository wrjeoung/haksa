package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Multijungong;

public interface MultijungongDao {
	void insertMultijungong(Multijungong multijungong)throws DataAccessException;
	public List getMultijungongList()throws DataAccessException;
}
