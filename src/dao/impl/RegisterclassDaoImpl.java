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

public class RegisterclassDaoImpl extends JdbcDaoSupport implements RegisterclassDao {

	@Override
	public List getRegisterclassList(HashMap params) throws DataAccessException {
		// TODO Auto-generated method stub
		RowMapper rowMapper = new RegisterclassRowMapper();
		
		HashMap hash = new HashMap();
		
		hash.put("major", "영어학과");
		hash.put("grade", "1");
		
		/*
		String sql = "SELECT FROME registerclass where major='"
				+ hash.get("major") +"' AND grade='" + hash.get("grade") + "'";
		*/
		String sql = "SELECT * FROME registerclass where major='"
				+ "영어학과" +"' AND grade='" + "1" + "'";
		return getJdbcTemplate().query(sql, rowMapper);
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
			
			return registerclass;
		}
		
	}
	
	

}
