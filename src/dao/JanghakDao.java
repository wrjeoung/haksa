package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Janghak;

public interface JanghakDao {
	void insertJanghak(Janghak janghak)throws DataAccessException;
	public List getJanghakList()throws DataAccessException;
	//상세보기
	public Janghak getJanghak(int num)throws DataAccessException;
}
