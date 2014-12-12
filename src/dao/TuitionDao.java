package dao;

import java.util.List;
import model.Tuition;

import org.springframework.dao.DataAccessException;

public interface TuitionDao {

	public List getTuitionList()throws DataAccessException;
	public void insertTuition(Tuition tuition) throws DataAccessException;
	
	
	
}
