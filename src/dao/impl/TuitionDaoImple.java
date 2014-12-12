package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Notice;
import model.Tuition;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.TuitionDao;

public class TuitionDaoImple extends JdbcDaoSupport implements TuitionDao{
	public List getTuitionList() throws DataAccessException {
		RowMapper rowMapper = new HakgiRowMapper();

		return getJdbcTemplate().query("SELECT * FROM student_tuition",rowMapper);
	}
	
	protected class HakgiRowMapper implements RowMapper{

		private List tuition = new ArrayList();
		
		public List getResults(){
			return tuition;
		}

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Tuition tuition = new Tuition();
			tuition.setYear(rs.getString("year"));
			tuition.setSemester(rs.getString("semester"));
			tuition.setTition_admission(rs.getInt("tition_admission"));
			tuition.setTition_lesson(rs.getInt("tition_lesson"));
			tuition.setTition_dues(rs.getInt("tition_dues"));
			tuition.setReduction_admission(rs.getInt("reduction_admission"));
			tuition.setReduction_lesson(rs.getInt("reduction_lesson"));
			tuition.setReduction_dues(rs.getInt("reduction_dues"));
			tuition.setPay_admission(rs.getInt("pay_admission"));
			tuition.setPay_lesson(rs.getInt("pay_lesson"));
			tuition.setPay_dues(rs.getInt("pay_dues"));
			tuition.setTuition_tot(rs.getInt("tuition_tot"));
			tuition.setTuition_yn(rs.getString("tuition_yn"));
			tuition.setTuition_il(rs.getString("tuition_il"));
			tuition.setStnumber(rs.getString("stnumber"));
			return tuition;
		}
		
	}
	

	@Override
	public void insertTuition(Tuition tuition) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO student_tuition(year,semester,tition_admission,tition_lesson,tition_dues,pay_admission,pay_lession,pay_dues,tuition_tot,tuition_yn,tuition_il,stnumber,) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		getJdbcTemplate().update(sql, new Object[]{tuition.getYear(),tuition.getSemester(),tuition.getTition_admission(),tuition.getTition_lesson(),tuition.getTition_dues(),
				tuition.getReduction_admission(),tuition.getReduction_lesson(),tuition.getReduction_dues(),
				tuition.getPay_admission(),tuition.getPay_lesson(),tuition.getPay_dues(),tuition.getTuition_tot(),
				tuition.getTuition_yn(),tuition.getTuition_il(),tuition.getStnumber()
		});
	}
	
}
