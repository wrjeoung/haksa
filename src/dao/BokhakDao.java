package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Bokhak;

public interface BokhakDao {
	void insertBokhak(Bokhak bokhak)throws DataAccessException;
	public List getBokhakList(String studentNumber)throws DataAccessException;
	public void deleteBokhak(String value)throws DataAccessException;
	//상세보기
	public Bokhak getBokhak(int num)throws DataAccessException;
}
