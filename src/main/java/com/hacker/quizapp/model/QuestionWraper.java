package com.hacker.quizapp.model;

public class QuestionWraper {

	private int qId;
	private String qTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	public QuestionWraper(int qId, String qTitle, String option1, String option2, String option3, String option4) {
		super();
		this.qId = qId;
		this.qTitle = qTitle;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}
	public int getQuizId() {
		return qId;
	}
	public void setQuizId(int qId) {
		this.qId = qId;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
}
