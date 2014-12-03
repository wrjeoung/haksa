package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import model.Member;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.MemberDao;

public class MemberDaoImpl extends JdbcDaoSupport implements MemberDao{
	
	@Override
	public int loginCheck(Map params) throws DataAccessException {
		
		String sql = "SELECT COUNT(*) FROM student_members "
				+ "WHERE stnumber='"+params.get("id")+"' AND pw='"+params.get("pw")+"'";
		return getJdbcTemplate().queryForInt(sql);
	}

	@Override
	public List pwCheck(Map params) throws DataAccessException {
		String sql = "SELECT * FROM student_members "
				+ "WHERE stnumber='"+params.get("id")+"' AND pw='"+params.get("pw")+"'";
			return getJdbcTemplate().queryForList(sql);
	}
	
	/*
	@Override
	public int changePw(Member params) throws DataAccessException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = getDataSource().getConnection();
			String sql = "UPDATE student_members SET pw=? WHERE stnumber=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, params.getPassword());
			pstmt.setString(2, params.getStudentNumber());
			pstmt.executeUpdate();
		} catch(Exception ex){
			ex.printStackTrace();
		} finally {
			if(pstmt != null) try{pstmt.close();}catch(SQLException ex){}
			if(conn != null) try{conn.close();}catch(SQLException ex){}
		}
		return 0;
	}
	*/
		
	@Override
	public int changePw(Member params) throws DataAccessException {
		String sql ="UPDATE student_members SET pw=? WHERE stnumber=?";
		String pw=params.getPassword();
		String stnum=params.getStudentNumber();
		Object[] objs = {pw,stnum};
		return getJdbcTemplate().update(sql, objs);
	}
}
