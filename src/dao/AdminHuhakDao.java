package dao;

import java.util.List;

import model.Huhak;

import org.springframework.dao.DataAccessException;

public interface AdminHuhakDao {
	public List getAdminHuhakList()throws DataAccessException;
	public void updatecomAdminHuhak(String value)throws DataAccessException;
	public void updatecanAdminHuhak(String value)throws DataAccessException;
	public void deleteAdminHuhak(String value)throws DataAccessException;
	//상세보기
	public Huhak getAdminHuhak(int num)throws DataAccessException;
	//수정
	public void changeAdminHuhak(Huhak params)throws DataAccessException;
	//회원상태(휴학중으로 수정)
	public void updateHuhakMember(String name)throws DataAccessException;
	//회원상태(재학중으로 수정)
	public void updateHuhakMember2(String name)throws DataAccessException;
}

