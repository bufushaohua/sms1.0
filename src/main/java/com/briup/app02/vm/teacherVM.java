package com.briup.app02.vm;

import java.util.List;

import com.briup.app02.bean.clazz;

public class teacherVM {
	private Long id;
	private String name;
	private String birth;
	private String gender;
	private String hiredate;
	private List<clazz> clazzs;
	public List<clazz> getClazzs() {
		return clazzs;
	}
	public void setClazzs(List<clazz> clazzs) {
		this.clazzs = clazzs;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
}
