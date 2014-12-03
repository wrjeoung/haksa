package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Bokhak;

public interface BokhakDao {
	void insertBokhak(Bokhak bokhak)throws DataAccessException;
	public List getBokhakList()throws DataAccessException;
}
