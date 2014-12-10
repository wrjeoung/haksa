package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertJujungong extends SqlUpdate{
	public InsertJujungong(DataSource ds){		
		super(ds,"INSERT INTO JUJUNGONG(NUM,JUJUNGONGGUBUN,JUJUNGONGGYUL,JUJUNGONGYEAR1,JUJUNGONGYEAR2,JUJUNGONGDAY,JUJUNGONG1,JUJUNGONG2,JUJUNGONG3,JUJUNGONG4,JUJUNGONG_REG_DATE,JUJUNGONGCHURI,NAME)"
				+ "VALUES(JUJUNGONG_NUM_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,'신청',?)");
		super.declareParameter(new SqlParameter("jujungonggubun", Types.VARCHAR));
		super.declareParameter(new SqlParameter("jujungonggyul", Types.VARCHAR));
		super.declareParameter(new SqlParameter("jujungongyear1", Types.VARCHAR));
		super.declareParameter(new SqlParameter("jujungongyear2", Types.VARCHAR));
		super.declareParameter(new SqlParameter("jujungongday", Types.VARCHAR));
		super.declareParameter(new SqlParameter("jujungong1", Types.VARCHAR));
		super.declareParameter(new SqlParameter("jujungong2", Types.VARCHAR));
		super.declareParameter(new SqlParameter("jujungong3", Types.VARCHAR));
		super.declareParameter(new SqlParameter("jujungong4", Types.VARCHAR));
		super.declareParameter(new SqlParameter("jujungong_reg_date", Types.DATE));
		//super.declareParameter(new SqlParameter("jujungongchuri",Types.VARCHAR));
		super.declareParameter(new SqlParameter("name", Types.VARCHAR));
		compile();
	}
}
