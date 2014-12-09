package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Feelsu;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import dao.FeelsuDao;

public class FeelsuDaoImple  extends JdbcDaoSupport implements FeelsuDao{	
	
	public List getFeelsuList() throws DataAccessException {
		RowMapper rowMapper = new HakgiRowMapper();

		return getJdbcTemplate().query("SELECT * FROM student_feelsu",rowMapper);
	}
	
	protected class HakgiRowMapper implements RowMapper{

		private List feelsu = new ArrayList();
		
		public List getResults(){
			return feelsu;
		}
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Feelsu feelsu = new Feelsu();
			feelsu.setJungong_gubun(rs.getString("jungong_gubun"));
			feelsu.setJujungong(rs.getString("jujungong"));
			feelsu.setHaknyun(rs.getString("haknyun"));
			feelsu.setHakgi(rs.getString("hakgi"));
			feelsu.setSubjectname(rs.getString("subjectname"));
			feelsu.setIsugubun(rs.getString("isugubun"));
			feelsu.setTackpilgubun(rs.getString("tackpilgubun"));
			feelsu.setTotalisugubun(rs.getString("totalisugubun"));

			return feelsu;
		}
		
	}


}

