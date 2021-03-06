package dao;

import java.util.List;

import model.Multijungong;

import org.springframework.dao.DataAccessException;

public interface AdminMultijungongDao {
	public List getAdminMultijungongList()throws DataAccessException;
	public void updatecomAdminMultijungong(String value)throws DataAccessException;
	public void updatecanAdminMultijungong(String value)throws DataAccessException;
	public void deleteAdminMultijungong(String value)throws DataAccessException;
	//상세보기
	public Multijungong getAdminMultijungong(int num)throws DataAccessException;
	//수정
	public void changeAdminMultijungong(Multijungong params)throws DataAccessException;
}
