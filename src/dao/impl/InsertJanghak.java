package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertJanghak extends SqlUpdate{
	public InsertJanghak(DataSource ds){
		super(ds,"INSERT INTO JANGHAK(NUM,JANGHAKBANK,JANGHAKBANKNUM,JANGHAKNAME,JANGHAKMENU,JANGHAKMY,JANGHAKCHURI,JANGHAK_REG_DATE)"
				+ "VALUES(JANGHAK_NUM_SEQ.NEXTVAL,?,?,?,?,?,'신청',?)");
		
		super.declareParameter(new SqlParameter("janghakbank", Types.VARCHAR));
		super.declareParameter(new SqlParameter("janghakbanknum", Types.VARCHAR));
		super.declareParameter(new SqlParameter("janghakname", Types.VARCHAR));
		super.declareParameter(new SqlParameter("janghakmenu", Types.VARCHAR));
		super.declareParameter(new SqlParameter("janghakmy", Types.VARCHAR));
		//super.declareParameter(new SqlParameter("janghakchuri", Types.VARCHAR));
		super.declareParameter(new SqlParameter("janghak_reg_date", Types.DATE));
		compile();
	}
}
