package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Notice;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.NoticeDao;

public class NoticeDaoImpl extends JdbcDaoSupport implements NoticeDao {
	
	@Override	
	public List getNoticeList() throws DataAccessException{
		String sql = "select * from notice order by reg_date desc";
		RowMapper rowMapper = new NoticeRowMapper();
		return getJdbcTemplate().query(sql,rowMapper);
	}
	
    protected class NoticeRowMapper implements RowMapper {
        private List noticeList = new ArrayList();
        private Calendar cal  = Calendar.getInstance();

        public List getResults() {
            return noticeList;
        }

		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
           //ResultSet���� ������Ʈ�� �ٽ� ä������
        	Notice notice = new Notice();
        	cal.setTime(new java.util.Date());
        	int year  = cal.get(Calendar.YEAR);
        	int month = cal.get(Calendar.MONTH) + 1;
        	int date = cal.get(Calendar.DATE); 

        	notice.setNum(rs.getInt("num"));
        	notice.setSubject(rs.getString("subject"));   
        	notice.setContent(rs.getString("content"));
        	notice.setReg_date(rs.getTimestamp("reg_date"));
        	cal.setTime(notice.getReg_date());
        	
        	if(year == cal.get(Calendar.YEAR)
        		&& month == cal.get(Calendar.MONTH) + 1
        		&& date == cal.get(Calendar.DATE)
        	) 
        	{
        		notice.setIsToday(true);
        	}
        	else
        		notice.setIsToday(false);
        	
            return notice;
        }
    }	

}
