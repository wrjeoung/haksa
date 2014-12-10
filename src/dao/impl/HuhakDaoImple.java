package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import model.Huhak;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.HuhakDao;

public class HuhakDaoImple extends JdbcDaoSupport implements HuhakDao{
	private InsertHuhak insertHuhak;
	public Huhak huhak;

	protected void initDao()throws Exception{
		this.insertHuhak=new InsertHuhak(getDataSource());
	}
	
	@Override
	public void insertHuhak(Huhak huhak) throws DataAccessException {
		// TODO Auto-generated method stub
		this.insertHuhak.update(new Object[]{huhak.getHugubun(),huhak.getHusegubun(),huhak.getHubokyear(),huhak.getHubokhak(),
			huhak.getHugrade(),huhak.getHunumber(),huhak.getHusayu(),huhak.getHuhak_reg_date(),huhak.getName()});
	}

	@Override
	public List getHuhakList(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from huhak where name='"+name+"'";
		RowMapper rowMapper=new HuhakRowMapper();
		return getJdbcTemplate().query(sql,rowMapper);
	}
	protected class HuhakRowMapper implements RowMapper{
		private List huhakList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return huhakList;
		}
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Huhak huhak=new Huhak();
			
			huhak.setNum(rs.getInt("num"));
			huhak.setHugubun(rs.getString("hugubun"));
			huhak.setHusegubun(rs.getString("husegubun"));
			huhak.setHubokyear(rs.getString("hubokyear"));
			huhak.setHubokhak(rs.getString("hubokhak"));
			huhak.setHugrade(rs.getString("hugrade"));
			huhak.setHunumber(rs.getString("hunumber"));
			huhak.setHusayu(rs.getString("husayu"));
			huhak.setHuchuri(rs.getString("huchuri"));
			huhak.setHuhak_reg_date(rs.getTimestamp("huhak_reg_date"));
			return huhak;
		}
	}
}
