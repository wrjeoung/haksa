package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Graduation;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import dao.GraduationDao;
import dao.impl.HakgiDaoImpl.HakgiRowMapper;


public class GraduationDaoImple  extends JdbcDaoSupport implements GraduationDao{	
	
	public List getGraduationList() throws DataAccessException {
		RowMapper rowMapper = new HakgiRowMapper();

		return getJdbcTemplate().query("SELECT * FROM student_graduation",rowMapper);
	}
	
	protected class HakgiRowMapper implements RowMapper{

		private List graduation = new ArrayList();
		
		public List getResults(){
			return graduation;
		}
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Graduation graduation = new Graduation();
			graduation.setIsu_nm(rs.getString("isu_nm"));
			graduation.setBatting(rs.getString("batting"));
			graduation.setGetbatting(rs.getString("getbatting"));
			graduation.setSugang(rs.getString("sugang"));
			graduation.setIsu(rs.getString("isu"));
			graduation.setRemain(rs.getString("remain"));
			graduation.setOuting(rs.getString("outing"));
			graduation.setOuting_cause(rs.getString("outing_cause"));
					
			
			return graduation;
		}
		
	}


	
}

