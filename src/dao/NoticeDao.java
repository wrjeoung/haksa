package dao;

import java.util.List;

import model.Notice;

import org.springframework.dao.DataAccessException;

public interface NoticeDao {
	public List getNoticeList() throws DataAccessException;
}
