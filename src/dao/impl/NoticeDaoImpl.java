package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Notice;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.NoticeDao;

public class NoticeDaoImpl extends JdbcDaoSupport implements NoticeDao {

	@Override
	public void updateReadCount(int num) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql = "UPDATE notice set readcount=readcount+1 where num = "+num;
		getJdbcTemplate().update(sql);
	}	
	
	@Override
	public Notice getNotice(int num) throws DataAccessException {
        return (Notice)getJdbcTemplate().query(
        		new NoticePreparedStatementCreator(num), 
        		new NoticeResultSetExtractor());
	}

    protected class NoticePreparedStatementCreator implements PreparedStatementCreator {

        private Integer num;

        public NoticePreparedStatementCreator(Integer id) {
            this.num = id;
        }

        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            final String sql = 
            	"SELECT * FROM notice where num = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, this.num);
            return ps;
        }
    }
	
    protected class	NoticeResultSetExtractor implements ResultSetExtractor {
        public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
            if (rs.next()) {
            	Notice notice = new Notice();
            	notice.setNum(rs.getInt("num"));
            	notice.setSubject(rs.getString("subject"));   
            	notice.setContent(rs.getString("content"));
            	notice.setReg_date(rs.getTimestamp("reg_date"));
                return notice;
            } else {
                return null;
            }
        }
    } 
	
	@Override	
	public List getNoticeList(int searchType, String searchWord) throws DataAccessException{
		String sql = "select num,subject,content,readcount,reg_date,rownum rnum from (select * from notice order by num)";
		
		switch(searchType)
		{
			case 0 :
				sql += " WHERE subject like "+"'%"+searchWord+"%'";
				break;
			case 1:
				sql += " WHERE content like "+"'%"+searchWord+"%'";
				break;
			default:
				break;
		}
		sql +=  " order by rnum desc";
		
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
        	Notice notice = new Notice();
        	cal.setTime(new java.util.Date());
        	int year  = cal.get(Calendar.YEAR);
        	int month = cal.get(Calendar.MONTH) + 1;
        	int date = cal.get(Calendar.DATE); 

        	notice.setNum(rs.getInt("num"));
        	notice.setSubject(rs.getString("subject"));   
        	notice.setContent(rs.getString("content"));
        	notice.setReg_date(rs.getTimestamp("reg_date"));
        	notice.setReadcount(rs.getInt("readcount"));
        	notice.setRnum(rs.getInt("rnum"));
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
    public Integer getMaxNum()  throws DataAccessException {
    	Integer maxId =  (Integer)getJdbcTemplate().query("SELECT max(num) as num FROM notice",new NoticeMaxNumExtractor());
       	return maxId;
    }
    
    protected class NoticeMaxNumExtractor implements ResultSetExtractor {
        public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        }
    }    

	@Override
	public void insertNotice(Notice notice) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO notice(num,subject,content,readcount) VALUES(?, ?, ? ,?)";
		getJdbcTemplate().update(sql, new Object[]{getMaxNum()+1,notice.getSubject(),notice.getContent(),0});
	}

	@Override
	public void deleteNotice(int num) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM notice where num = "+num;
		getJdbcTemplate().update(sql);
	}
}
