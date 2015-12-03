package com.demo.domain;

/**
 * Choicequestion entity. @author MyEclipse Persistence Tools
 */

public class Choicequestion implements java.io.Serializable {

	// Fields

	private Integer hiloId;
	private String content;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String optionE;
	private String answer;

	// Constructors

	/** default constructor */
	public Choicequestion() {
	}

	/** minimal constructor */
	public Choicequestion(String content, String optionA, String optionB,
			String optionC, String optionD, String answer) {
		this.content = content;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
	}

	/** full constructor */
	public Choicequestion(String content, String optionA, String optionB,
			String optionC, String optionD, String optionE, String answer) {
		this.content = content;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.optionE = optionE;
		this.answer = answer;
	}

	// Property accessors

	public Integer getHiloId() {
		return this.hiloId;
	}

	public void setHiloId(Integer hiloId) {
		this.hiloId = hiloId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOptionA() {
		return this.optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return this.optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return this.optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return this.optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getOptionE() {
		return this.optionE;
	}

	public void setOptionE(String optionE) {
		this.optionE = optionE;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}