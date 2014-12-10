package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertJunkwa extends SqlUpdate{
	public InsertJunkwa(DataSource ds){
		super(ds,"INSERT INTO JUNKWA(NUM,JUNKWAYEAR,JUNKWAHAKGI,JUNKWAHAKKWA,JUNKWA_REG_DATE,JUNKWABYGO,JUNKWACHURI,JUNKWACHUDAY,NAME)"
				+ "VALUES(JUNKWA_NUM_SEQ.NEXTVAL,?,?,?,?,?,'신청',?,?)");
	    
		super.declareParameter(new SqlParameter("junkwayear", Types.VARCHAR));
	    super.declareParameter(new SqlParameter("junkwahakgi", Types.VARCHAR));
	    super.declareParameter(new SqlParameter("junkwahakkwa", Types.VARCHAR));
	    super.declareParameter(new SqlParameter("junkwa_reg_date", Types.DATE));
	    super.declareParameter(new SqlParameter("junkwabygo", Types.VARCHAR));
	    //super.declareParameter(new SqlParameter("junkwachuri", Types.VARCHAR));
	    super.declareParameter(new SqlParameter("junkwachuday", Types.VARCHAR));
	    super.declareParameter(new SqlParameter("name", Types.VARCHAR));
	    compile();
	}
}
