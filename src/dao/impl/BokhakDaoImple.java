package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Bokhak;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.BokhakDao;

public class BokhakDaoImple extends JdbcDaoSupport implements BokhakDao{
	private InsertBokhak insertBokhak;
	public Bokhak bokhak;
	
	protected void initDao()throws Exception{
		this.insertBokhak=new InsertBokhak(getDataSource());
	}
	@Override
	public void insertBokhak(Bokhak bokhak) throws DataAccessException {
		// TODO Auto-generated method stub
		this.insertBokhak.update(new Object[]{bokhak.getBokhakgi(),bokhak.getBokgubun(),bokhak.getBokyear(),
				bokhak.getBokyehakgi(),bokhak.getBoksayu(),bokhak.getBokhak_reg_date()});
	}
	@Override
	public List getBokhakList() throws DataAccessException {
		// TODO Auto-generated method stub
		String sql="select * from bokhak order by bokhak_reg_date desc";
		RowMapper rowMapper=new BokhakRowMapper();
		
		return getJdbcTemplate().query(sql, rowMapper);
	}
	protected class BokhakRowMapper implements RowMapper{
		private List bokhakList=new ArrayList();
		private Calendar cal=Calendar.getInstance();
		
		public List getResults(){
			return bokhakList;
		}
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Bokhak bokhak=new Bokhak();
			bokhak.setNum(rs.getInt("num"));
			bokhak.setBokhakgi(rs.getString("bokhakgi"));
			bokhak.setBokgubun(rs.getString("bokgubun"));
			bokhak.setBokyear(rs.getString("bokyear"));
			bokhak.setBokyehakgi(rs.getString("bokyehakgi"));
			bokhak.setBoksayu(rs.getString("boksayu"));
			bokhak.setBokhak_reg_date(rs.getTimestamp("bokhak_reg_date"));
			bokhak.setBokchuri(rs.getString("bokchuri"));
			return bokhak;
		}
	}
	
}
