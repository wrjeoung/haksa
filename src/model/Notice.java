package model;

import java.sql.Timestamp ;

public class Notice {
	private int num;
	private String subject;
	private String content;
	private int readcount;
	private Timestamp reg_date;
	private boolean isToday;
	private int rnum;

	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public boolean getIsToday() {
		return isToday;
	}
	public void setIsToday(boolean isToday) {
		this.isToday = isToday;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
}
