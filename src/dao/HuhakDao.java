package dao;

import java.util.List;
import java.util.Map;

import model.Huhak;

import org.springframework.dao.DataAccessException;

public interface HuhakDao {
	void insertHuhak(Huhak huhak)throws DataAccessException;
	public List getHuhakList()throws DataAccessException;
	
}
