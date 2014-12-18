package dao;

import java.util.List;
import java.util.Map;

import model.Member;

import org.springframework.dao.DataAccessException;

public interface MemberDao {
	public int loginCheck(Map params) throws DataAccessException;
	public List selectMembers(Map params) throws DataAccessException;
	public Member selectMember(String memId) throws DataAccessException;
	public int changePw(Member params) throws DataAccessException;
	public void changeInfo(Member params) throws DataAccessException;
	public Member selectIdPw(Map params) throws DataAccessException;
	public void insertMember(Member params) throws DataAccessException;
	public void updateMember(Member params) throws DataAccessException;
}
