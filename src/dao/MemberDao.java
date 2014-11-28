package dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface MemberDao {
	public int loginCheck(Map params) throws DataAccessException;
}
