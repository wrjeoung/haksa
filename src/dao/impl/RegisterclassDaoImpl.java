package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Registerclass;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.RegisterclassDao;
import dao.impl.NoticeDaoImpl.NoticeRowMapper;

public class RegisterclassDaoImpl extends JdbcDaoSupport implements RegisterclassDao {

	@Override
	public List getRegisterclassList(HashMap params) throws DataAccessException {
		// TODO Auto-generated method stub
		RowMapper rowMapper = new RegisterclassRowMapper();
		
		String sql = "SELECT * FROM (select * from registerclass where major='"
				+ params.get("major") +"') where grade='" + params.get("grade") + "' OR grade='" + params.get("gradeJ") + "'";
		
		/*
		String sql = "SELECT * FROME registerclass where major='"
				+ "�����а�" +"' AND grade='" + "1" + "'";
		*/
		//return getJdbcTemplate().queryForList(sql);
		return getJdbcTemplate().query(sql,rowMapper);
	}
	
	@Override
	public List getCulturalClassList(String major) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM registerclass where major ='"
				+ major + "'";
		
		return getJdbcTemplate().queryForList(sql);
	}	

	
	protected class RegisterclassRowMapper implements RowMapper{

		private List registerclassList = new ArrayList();
		
		public List getResults(){
			return registerclassList;
		}
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Registerclass registerclass = new Registerclass();
			registerclass.setSubjectnum(rs.getString("subjectnum"));
			registerclass.setSubjectname(rs.getString("subjectname"));
			registerclass.setCurriculum(rs.getString("curriculum"));
			registerclass.setCourse(rs.getString("course"));
			registerclass.setCredit(rs.getInt("credit"));
			registerclass.setFixednum(rs.getInt("fixednum"));
			registerclass.setLecturetime(rs.getString("lecturetime"));
			registerclass.setProfessor(rs.getString("professor"));
			registerclass.setClassroom(rs.getString("classroom"));
			registerclass.setEtc(rs.getString("etc"));
			registerclass.setMajor(rs.getString("major"));
			registerclass.setGrade(rs.getString("grade"));
			registerclass.setExtranum(rs.getInt("extranum"));
			
			return registerclass;
		}
	}
	
	protected class RegisterclassRowMapper2 implements RowMapper{

		private List registerclassList = new ArrayList();
		
		public List getResults(){
			return registerclassList;
		}
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Registerclass registerclass = new Registerclass();
			registerclass.setCredit(rs.getInt("sum(credit)"));
		
			return registerclass;
		}
	}
	
	@Override
	public void updateExtraNum(String subjectnum) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql = "UPDATE registerclass set extranum=extranum+1 where subjectnum = '"+subjectnum +"'";
		getJdbcTemplate().update(sql);
	}

	@Override
	public List getList(String stnumber) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql = "select * from registerforcourses a , registerclass b where a.subjectnum = b.subjectnum and stnumber = '" + stnumber + "'";
		return getJdbcTemplate().queryForList(sql);
	}
	
	@Override
	public List getSumList(String stnumber) throws DataAccessException {
		// TODO Auto-generated method stub
		RowMapper rowMapper = new RegisterclassRowMapper2();
		String sql = "select sum(credit) from registerforcourses a , registerclass b where a.subjectnum = b.subjectnum and stnumber = '" + stnumber + "'";
		return getJdbcTemplate().query(sql,rowMapper);
	}

	@Override
	public List getTotalList() throws DataAccessException {
		// TODO Auto-generated method stub
		String sql = "select * from registerclass";
		return getJdbcTemplate().queryForList(sql);
	}

	@Override
	public void insertRegisterclass(Registerclass registerclass)
			throws DataAccessException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO registerclass(subjectnum,subjectname,curriculum,course,credit,fixednum,lecturetime,professor,classroom,etc,major,grade,extranum)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		getJdbcTemplate().update(sql, new Object[]{registerclass.getSubjectnum(),registerclass.getSubjectname(),
				registerclass.getCurriculum(),registerclass.getCourse(),registerclass.getCredit(),registerclass.getFixednum(),
				registerclass.getLecturetime(),registerclass.getProfessor(),registerclass.getClassroom(),registerclass.getEtc(),
				registerclass.getMajor(),registerclass.getGrade(),registerclass.getExtranum()});
	}
	
	@Override
	public void deleteList(String[] checkedNumList) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM registerclass where";
		
		for(int i = 0; i<checkedNumList.length; i++)
		{
			sql+=  " subjectnum = '"+checkedNumList[i]+"'";
			
			if(checkedNumList.length > 1 && i<checkedNumList.length-1)
			{
				sql+= " OR";
			}
		}
		getJdbcTemplate().update(sql);
	}

	@Override
	public List<String> getSubjectNum(String stnumber) throws DataAccessException {
		String sql = "select b.subjectnum from registerforcourses a , registerclass b where a.subjectnum = b.subjectnum and stnumber = '" + stnumber + "'";
		RowMapper rowMapper = new SubjectNameRowMapper();
		List<String> query = getJdbcTemplate().query(sql,rowMapper);
		return query;
	}
	
	protected class SubjectNameRowMapper implements RowMapper {
		private List sbNameList = new ArrayList();

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			String str;
			str = rs.getString("subjectnum");
			return str;
		}
	}
}
