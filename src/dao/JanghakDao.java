package dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import model.Janghak;

public interface JanghakDao {
	void insertJanghak(Janghak janghak)throws DataAccessException;
	public List getJanghakList(String studentNumber)throws DataAccessException;
	//상세보기
	public Janghak getJanghak(int num)throws DataAccessException;
	//삭제
	public void deleteJanghak(String value)throws DataAccessException;
	//수정
	public void changeJanghak(Janghak params)throws DataAccessException;
}
