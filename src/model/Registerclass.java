package model;

public class Registerclass {

	private String subjectnum;          // 학수번호 
	private String subjectname;         // 과목명
	private String curriculum;          // 교과과정  -> 전공/교양
	private String course;              // 이수       -> 전필/전선/교필/교선
	private int credit;                 // 학점
	private int fixednum;               // 정원
	private String lecturetime;         // 강의시간
	private String professor;           // 담당교수
	private String classroom;           // 강의실
	private String etc;                 // 비고
	private String major;               // 학과
	private String grade;               // 학년
	private int extranum;               // 여분
	
	public String getSubjectnum() {
		return subjectnum;
	}
	public void setSubjectnum(String subjectnum) {
		this.subjectnum = subjectnum;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getFixednum() {
		return fixednum;
	}
	public void setFixednum(int fixednum) {
		this.fixednum = fixednum;
	}
	public String getLecturetime() {
		return lecturetime;
	}
	public void setLecturetime(String lecturetime) {
		this.lecturetime = lecturetime;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
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
	public int getExtranum() {
		return extranum;
	}
	public void setExtranum(int extranum) {
		this.extranum = extranum;
	}
}
