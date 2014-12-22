package dao;

import java.util.List;

import model.Bokhak;

import org.springframework.dao.DataAccessException;

public interface AdminBokhakDao {
	public List getAdminBokhakList()throws DataAccessException;
	public void updatecomAdminBokhak(String value)throws DataAccessException;
	public void updatecanAdminBokhak(String value)throws DataAccessException;
	public void deleteAdminBokhak(String value)throws DataAccessException;
	//상세보기
	public Bokhak getAdminBokhak(int num)throws DataAccessException;
	//수정
	public void changeAdminBokhak(Bokhak params)throws DataAccessException;
	//회원상태(재학중으로 변경)
	public void updateBokhakMember(String name)throws DataAccessException;
	//회원상태(휴학중으로 되돌리기)
	public void updateBokhakMember2(String name)throws DataAccessException;
}
