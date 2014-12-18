package dao;

import java.util.List;

import model.Janghak;

import org.springframework.dao.DataAccessException;

public interface AdminJanghakDao {
	public List getAdminJanghakList()throws DataAccessException;
	public void updatecomAdminJanghak(String value)throws DataAccessException;
	public void updatecanAdminJanghak(String value)throws DataAccessException;
	public void deleteAdminJanghak(String value)throws DataAccessException;
	//상세보기
	public Janghak getAdminJanghak(int num)throws DataAccessException;
	//수정
	public void changeAdminJanghak(Janghak params)throws DataAccessException;
}
