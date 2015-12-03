package com.demo.util;

public enum EQuestionType {

	QChoice("Choice","ѡ����"),QCompletion("Completion","�����"),QTrueOrFalse("TrueOrFalse","�ж���"),QSAQ("SAQ","�����");
	private String value;
	private String key;
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	private EQuestionType(String key,String value)
	{
		this.key=key;
		this.value=value;
	}
}
