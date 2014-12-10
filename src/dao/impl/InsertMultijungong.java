package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertMultijungong extends SqlUpdate{
	public InsertMultijungong(DataSource ds){
		super(ds,"INSERT INTO MULTIJUNGONG(NUM,MULTIGUBUN,MULTIGUBUN2,MULTIYEAR1,MULTIYEAR2,MULTIYEAR3,MULTIJUNGONG,MULTIGYUL,MULTISAYU,MULTIDAY,MULTI_REG_DATE,MULTICHURI,NAME)VALUES(MULTIJUNGONG_NUM_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,'신청',?)");
		super.declareParameter(new SqlParameter("multigubun", Types.VARCHAR));
		super.declareParameter(new SqlParameter("multigubun2", Types.VARCHAR));
		super.declareParameter(new SqlParameter("multiyear1", Types.VARCHAR));
		super.declareParameter(new SqlParameter("multiyear2", Types.VARCHAR));
		super.declareParameter(new SqlParameter("multiyear3", Types.VARCHAR));
		super.declareParameter(new SqlParameter("multijungong", Types.VARCHAR));
		super.declareParameter(new SqlParameter("multigyul", Types.VARCHAR));
		super.declareParameter(new SqlParameter("multisayu", Types.VARCHAR));
		super.declareParameter(new SqlParameter("multiday", Types.VARCHAR));
		super.declareParameter(new SqlParameter("multi_reg_date date", Types.DATE));
		super.declareParameter(new SqlParameter("name", Types.VARCHAR));
		compile();
	}
}
