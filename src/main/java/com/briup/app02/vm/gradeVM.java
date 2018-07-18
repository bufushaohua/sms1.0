package com.briup.app02.vm;

import com.briup.app02.bean.clazz;

public class gradeVM {
	private Long id;
	private String name;
	private String description;
	private clazz C;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public clazz getC() {
		return C;
	}
	public void setC(clazz c) {
		C = c;
	}
}
