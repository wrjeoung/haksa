package model;

import java.sql.Date;

public class Member {
	private String studentNumber;	// �й�
	private String password;		// ��й�ȣ
	private String name;			// ����
	private String birthday;		// ����
	private String major;			// �к�(�а�)
	private String grade;			// �г�
	private Date entrace_date;		// ���г⵵
	private String tel;				// ��ȭ��ȣ
	private String cellphone;		// �޴�����ȣ
	private String email;			// �̸���
	private String address;			// �ּ�
	private String state;			// ��������(������,������)
	
	/* �������� ������ ���� �ޱ����� �ɹ�����  
	 * ��ȭ��ȣ�� 3���� ������ ����� �Է¹޴´�.
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

