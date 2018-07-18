package com.briup.app02.vm;

import java.util.List;

import com.briup.app02.bean.option;

public class questionVM {
	private Long id;
	private String name;
	private String questiontype;
	private List<option> options;
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
	public List<option> getOptions() {
		return options;
	}
	public void setOptions(List<option> options) {
		this.options = options;
	}
	
}
