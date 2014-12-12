package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jujungong;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.JujungongDao;
import dao.impl.RegisterclassDaoImpl.RegisterclassRowMapper;

public class JujungongDaoImple extends JdbcDaoSupport implements JujungongDao{

	@Override
	public List getList(String major) throws DataAccessException {
		// TODO Auto-generated method stub
		RowMapper rowMapper=new JujungongRowMapper();
		
		String sql = "SELECT * FROM hakkwa where hakkwa ='"
				+ major + "'";
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class JujungongRowMapper implements RowMapper{
		private List getList=new ArrayList();
		
		public List getResults(){
			return getList;
		}
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Jujungong jujungong=new Jujungong();
			jujungong.setNum(rs.getInt("num"));
			jujungong.setHakkwa(rs.getString("hakkwa"));
			jujungong.setJungong(rs.getString("jungong"));
			jujungong.setJungong2(rs.getString("jungong2"));
			jujungong.setJungong3(rs.getString("jungong3"));
			jujungong.setJungong4(rs.getString("jungong4"));
			
			return jujungong;
		}
		
	}
}