package model;

public class Tuition {
	private String year;
	private String semester;
	private int tition_admission;
	private int tition_lesson;
	private int tition_dues;
	private int reduction_admission;
	private int reduction_lesson;
	private int reduction_dues;
	private int pay_admission;
	private int pay_lesson;
	private int pay_dues;
	private int tuition_tot;
	private String tuition_yn;
	private String tuition_il;
	private String stnumber;
	
	
	public String getStnumber() {
		return stnumber;
	}

	public void setStnumber(String stnumber) {
		this.stnumber = stnumber;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getTition_admission() {
		return tition_admission;
	}

	public void setTition_admission(int tition_admission) {
		this.tition_admission = tition_admission;
	}

	public int getTition_lesson() {
		return tition_lesson;
	}

	public void setTition_lesson(int tition_lesson) {
		this.tition_lesson = tition_lesson;
	}

	public int getTition_dues() {
		return tition_dues;
	}

	public void setTition_dues(int tition_dues) {
		this.tition_dues = tition_dues;
	}

	public int getReduction_admission() {
		return reduction_admission;
	}

	public void setReduction_admission(int reduction_admission) {
		this.reduction_admission = reduction_admission;
	}

	public int getReduction_lesson() {
		return reduction_lesson;
	}

	public void setReduction_lesson(int reduction_lesson) {
		this.reduction_lesson = reduction_lesson;
	}

	public int getReduction_dues() {
		return reduction_dues;
	}

	public void setReduction_dues(int reduction_dues) {
		this.reduction_dues = reduction_dues;
	}

	public int getPay_admission() {
		return pay_admission;
	}

	public void setPay_admission(int pay_admission) {
		this.pay_admission = pay_admission;
	}

	public int getPay_lesson() {
		return pay_lesson;
	}

	public void setPay_lesson(int pay_lesson) {
		this.pay_lesson = pay_lesson;
	}

	public int getPay_dues() {
		return pay_dues;
	}

	public void setPay_dues(int pay_dues) {
		this.pay_dues = pay_dues;
	}

	public int getTuition_tot() {
		return tuition_tot;
	}

	public void setTuition_tot(int tuition_tot) {
		this.tuition_tot = tuition_tot;
	}

	public String getTuition_yn() {
		return tuition_yn;
	}

	public void setTuition_yn(String tuition_yn) {
		this.tuition_yn = tuition_yn;
	}

	public String getTuition_il() {
		return tuition_il;
	}

	public void setTuition_il(String tuition_il) {
		this.tuition_il = tuition_il;
	}

}
