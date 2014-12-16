package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Multijungong;

public interface MultijungongDao {
	void insertMultijungong(Multijungong multijungong)throws DataAccessException;
	public List getMultijungongList(String studentNumber)throws DataAccessException;
	public void deleteMultijungong(String value)throws DataAccessException;
	//상세보기
	public Multijungong getMultijungong(int num)throws DataAccessException;
}
