package model;

import java.util.Date;

public class Leave {
	private int num;
	private String leavegubun;
	private String leavehak;
	private String leavehak2;
	private String leavehak3;
	private String leavegyul;
	private String leavesayu;
	private String leavesayu2;
	private String leaveday;
	private Date leave_reg_date;
	private String leavechuri;
	
	public String getLeavechuri() {
		return leavechuri;
	}
	public void setLeavechuri(String leavechuri) {
		this.leavechuri = leavechuri;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getLeavegubun() {
		return leavegubun;
	}
	public void setLeavegubun(String leavegubun) {
		this.leavegubun = leavegubun;
	}
	public String getLeavehak() {
		return leavehak;
	}
	public void setLeavehak(String leavehak) {
		this.leavehak = leavehak;
	}
	public String getLeavehak2() {
		return leavehak2;
	}
	public void setLeavehak2(String leavehak2) {
		this.leavehak2 = leavehak2;
	}
	public String getLeavehak3() {
		return leavehak3;
	}
	public void setLeavehak3(String leavehak3) {
		this.leavehak3 = leavehak3;
	}
	public String getLeavegyul() {
		return leavegyul;
	}
	public void setLeavegyul(String leavegyul) {
		this.leavegyul = leavegyul;
	}
	public String getLeavesayu() {
		return leavesayu;
	}
	public void setLeavesayu(String leavesayu) {
		this.leavesayu = leavesayu;
	}
	public String getLeavesayu2() {
		return leavesayu2;
	}
	public void setLeavesayu2(String leavesayu2) {
		this.leavesayu2 = leavesayu2;
	}
	public String getLeaveday() {
		return leaveday;
	}
	public void setLeaveday(String leaveday) {
		this.leaveday = leaveday;
	}
	public Date getLeave_reg_date() {
		return leave_reg_date;
	}
	public void setLeave_reg_date(Date leave_reg_date) {
		this.leave_reg_date = leave_reg_date;
	}
}
