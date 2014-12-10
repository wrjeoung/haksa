package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.Member;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
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
	public List selectMembers(Map params) throws DataAccessException {
		String sql = "SELECT * FROM student_members "
				+ "WHERE stnumber='"+params.get("id")+"' AND pw='"+params.get("pw")+"'";
			return getJdbcTemplate().queryForList(sql);
	}
	
	@Override
	public Member selectMember(String memId) throws DataAccessException {
				
			return (Member)getJdbcTemplate().query(
					new MemberPreparedStatementCreator(memId),
					new MemberResultSetExtractor());
	}
	
	protected class MemberPreparedStatementCreator implements PreparedStatementCreator {

		private String memId;
		
		public MemberPreparedStatementCreator(String memId) {
			this.memId=memId;
		}
		
		@Override
		public PreparedStatement createPreparedStatement(Connection con)
				throws SQLException {
			final String sql = "SELECT * FROM student_members "
					+ "WHERE stnumber=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, this.memId);
			return ps;
		}
	}
	
	protected class MemberResultSetExtractor implements ResultSetExtractor {
		@Override
		public Object extractData(ResultSet rs) throws SQLException,	DataAccessException {
			//SQL ï¿½ï¿½ï¿½ ï¿½ï¿½îµµ 1ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
			if(rs.next()) {
				Member member = new Member();
				member.setStudentNumber(rs.getString("stnumber"));
				member.setPassword(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setBirthday(rs.getString("birthday"));
				member.setMajor(rs.getString("major"));
				member.setGrade(rs.getString("grade"));
				member.setEntrace_date((rs.getDate("entrance_date")));
				member.setTel(rs.getString("tel"));
				member.setCellphone(rs.getString("cellphone"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setState(rs.getString("state"));
				return member;
			}
			else
				return null;
		}
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

	@Override
	public void changeInfo(Member params) throws DataAccessException {
		String sql="UPDATE student_members SET tel=?, cellphone=?, email=?, address=?"
				+ " WHERE stnumber=?";
		String tel = params.getTel1()+"-"+params.getTel2()+"-"+params.getTel3();
		String cellphone = params.getHp1()+"-"+params.getHp2()+"-"+params.getHp3();
		String email=params.getEmail();
		String address=params.getAddress();
		String stnumber=params.getStudentNumber();
		Object[] objs ={tel,cellphone,email,address,stnumber};
		getJdbcTemplate().update(sql, objs);
//		System.out.println("\ntel : "+tel
//				+"\ncellphone : "+cellphone
//				+"\nemail : "+email
//				+"\naddress : "+address
//				+"\nstnumber : "+stnumber);
		
	}

	@Override
	public Member selectIdPw(Map params) throws DataAccessException {

		return (Member)getJdbcTemplate().query(
				new IdPwPreparedStatementCreator(params),
				new IdPwResultSetExtractor());
	}
	
	protected class IdPwPreparedStatementCreator implements PreparedStatementCreator {

		private String mName;
		private String mHp;
		private String mEmail;
		
		
		public IdPwPreparedStatementCreator(Map params) {
			mName = (String)params.get("name");
			mHp = (String)params.get("cellphone");
			mEmail = (String)params.get("email");
		}
		
		@Override
		public PreparedStatement createPreparedStatement(Connection con)
				throws SQLException {
			final String sql = "SELECT * FROM student_members "
					+ "WHERE cellphone=? AND name=? AND email=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mHp);
			ps.setString(2, mName);
			ps.setString(3, mEmail);
			return ps;
		}
	}
	
	protected class IdPwResultSetExtractor implements ResultSetExtractor {
		@Override
		public Object extractData(ResultSet rs) throws SQLException,	DataAccessException {
			//SQL °á°ú°¡ Àû¾îµµ 1°Ç ÀÖÀ»±î
			if(rs.next()) {
				Member member = new Member();
				member.setStudentNumber(rs.getString("stnumber"));
				member.setPassword(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				return member;
			}
			else
				return null;
		}
	}
}
