package com.briup.app02.bean;

public class question {
	private Long id;
	private String name;
	private String questiontype;
	public question(){
		
	}
	public question(Long id, String name, String questiontype) {
		super();
		this.id = id;
		this.name = name;
		this.questiontype = questiontype;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuestiontype() {
		return questiontype;
	}
	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}
	
}
