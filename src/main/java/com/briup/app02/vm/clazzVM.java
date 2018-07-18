package com.briup.app02.vm;

import com.briup.app02.bean.grade;
import com.briup.app02.bean.teacher;

public class clazzVM {
	private Long id;
	private String name;
	private String description;
	private grade grade;	//年级
	private teacher teacher; //班主任
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
	public grade getGrade() {
		return grade;
	}
	public void setGrade(grade gr) {
		this.grade = gr;
	}
	public teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(teacher te) {
		this.teacher = te;
	}
	
}
