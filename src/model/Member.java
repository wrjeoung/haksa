package model;

import java.sql.Date;

public class Member {
	private String studentNumber;	// 학번
	private String password;		// 비밀번호
	private String name;			// 성명
	private String birthday;		// 생일
	private String major;			// 학부(학과)
	private String grade;			// 학년
	private Date entrace_date;		// 입학년도
	private String tel;				// 전화번호
	private String cellphone;		// 휴대폰번호
	private String email;			// 이메일
	private String address;			// 주소
	private String state;			// 학정정보(재학중,휴학중)
	
	/* 개인정보 수정된 정보 받기위한 맴버변수  
	 * 전화번호는 3개의 폼으로 나누어서 입력받는다.
	 * */
	private String tel1;
	private String tel2;
	private String tel3;
	private String hp1;
	private String hp2;
	private String hp3;
	
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public String getHp1() {
		return hp1;
	}
	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}
	public String getHp2() {
		return hp2;
	}
	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}
	public String getHp3() {
		return hp3;
	}
	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getEntrace_date() {
		return entrace_date;
	}
	public void setEntrace_date(Date entrace_date) {
		this.entrace_date = entrace_date;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

