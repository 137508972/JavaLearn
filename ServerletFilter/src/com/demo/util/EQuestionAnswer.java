package com.demo.util;

public enum EQuestionAnswer {
	write("true","��"),wrong("false","��");
	private String value;
	private String key;
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	private EQuestionAnswer(String key,String value)
	{
		this.key=key;
		this.value=value;
	}
}
