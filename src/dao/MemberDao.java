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
}
