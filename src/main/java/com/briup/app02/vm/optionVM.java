package com.briup.app02.vm;

import com.briup.app02.bean.question;

public class optionVM {
	private Long id;
	private String label;
	private String content;
	private Integer score;
	private question question;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public question getQuestion() {
		return question;
	}
	public void setQuestion(question question) {
		this.question = question;
	}
	
}
