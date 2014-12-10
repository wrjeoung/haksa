package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertLeave extends SqlUpdate{
	public InsertLeave(DataSource ds){
	super(ds,"INSERT INTO LEAVE(NUM,LEAVEGUBUN,LEAVEHAK,LEAVEHAK2,LEAVEHAK3,LEAVEGYUL,LEAVESAYU,LEAVESAYU2,LEAVEDAY,LEAVE_REG_DATE,LEAVECHURI,NAME)"
			+ "VALUES(LEAVE_NUM_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,'신청',?)");
	super.declareParameter(new SqlParameter("leavegubun", Types.VARCHAR));
	super.declareParameter(new SqlParameter("leavehak", Types.VARCHAR));
	super.declareParameter(new SqlParameter("leavehak2", Types.VARCHAR));
	super.declareParameter(new SqlParameter("leavehak3", Types.VARCHAR));
	super.declareParameter(new SqlParameter("leavegyul", Types.VARCHAR));
	super.declareParameter(new SqlParameter("leavesayu", Types.VARCHAR));
	super.declareParameter(new SqlParameter("leavesayu2", Types.VARCHAR));
	super.declareParameter(new SqlParameter("leaveday", Types.VARCHAR));
	super.declareParameter(new SqlParameter("leave_reg_date", Types.DATE));
	//super.declareParameter(new SqlParameter("leavechuri", Types.VARCHAR));
	super.declareParameter(new SqlParameter("name", Types.VARCHAR));
	compile();
	}
}
