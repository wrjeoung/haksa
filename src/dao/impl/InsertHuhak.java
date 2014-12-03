package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertHuhak extends SqlUpdate{
	public InsertHuhak(DataSource ds){
		super(ds,"INSERT INTO HUHAK(NUM,HUGUBUN,HUSEGUBUN,HUBOKYEAR,HUBOKHAK,HUGRADE,HUNUMBER,HUSAYU,HUCHURI,HUHAK_REG_DATE)VALUES(HUHAK_NUM_SEQ.NEXTVAL,?,?,?,?,?,?,?,'신청',?)");
		super.declareParameter(new SqlParameter("hugubun", Types.VARCHAR));
		super.declareParameter(new SqlParameter("husegubun", Types.VARCHAR));
		super.declareParameter(new SqlParameter("hubokyear", Types.VARCHAR));
		super.declareParameter(new SqlParameter("hubokhak", Types.VARCHAR));
		super.declareParameter(new SqlParameter("hugrade", Types.VARCHAR));
		super.declareParameter(new SqlParameter("hunumber", Types.VARCHAR));
		super.declareParameter(new SqlParameter("husayu", Types.VARCHAR));
		//super.declareParameter(new SqlParameter("huchuri", Types.VARCHAR));
		super.declareParameter(new SqlParameter("huhak_reg_date", Types.DATE));
		compile();
	}
}
