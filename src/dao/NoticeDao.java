package dao;

import java.util.List;

import model.Notice;

import org.springframework.dao.DataAccessException;

public interface NoticeDao {
	public List getNoticeList(int searchType, String searchWord) throws DataAccessException;
	public Notice getNotice(int num) throws DataAccessException;
	public void insertNotice(Notice notice) throws DataAccessException;
	public void updateNotice(Notice notice) throws DataAccessException;
	public void updateReadCount(int num) throws DataAccessException;
	public void deleteNotice(int num) throws DataAccessException;
	public int getPrevNum(int num) throws DataAccessException;
	public int getNextNum(int num) throws DataAccessException;
}
