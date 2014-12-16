package dao;

import java.util.List;
import java.util.Map;

import model.Huhak;

import org.springframework.dao.DataAccessException;

public interface HuhakDao {
	void insertHuhak(Huhak huhak)throws DataAccessException;
	public List getHuhakList(String studentNumber)throws DataAccessException;
	public void deleteHuhak(String value)throws DataAccessException;
	//상세보기
	public Huhak getHuhak(int num)throws DataAccessException;
}
