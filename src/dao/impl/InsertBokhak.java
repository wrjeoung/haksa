package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertBokhak extends SqlUpdate{
	public InsertBokhak(DataSource ds){
		super(ds,"INSERT INTO BOKHAK(NUM,BOKHAKGI,BOKGUBUN,BOKYEAR,BOKYEHAKGI,BOKSAYU,BOKHAK_REG_DATE,BOKCHURI,NAME)"
				+ "VALUES(BOKHAK_NUM_SEQ.NEXTVAL,?,?,?,?,?,?,'신청',?)");
		super.declareParameter(new SqlParameter("bokhakgi", Types.VARCHAR));
		super.declareParameter(new SqlParameter("bokgubun", Types.VARCHAR));
		super.declareParameter(new SqlParameter("bokyear", Types.VARCHAR));
		super.declareParameter(new SqlParameter("bokyehakgi", Types.VARCHAR));
		super.declareParameter(new SqlParameter("boksayu", Types.VARCHAR));
		super.declareParameter(new SqlParameter("bokhak_reg_date", Types.DATE));
		//super.declareParameter(new SqlParameter("bokchuri", Types.VARCHAR));
		super.declareParameter(new SqlParameter("name", Types.VARCHAR));
		compile();
	}
}
