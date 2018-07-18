package com.briup.app02.vm;

import com.briup.app02.bean.qq;

public class questionnaireVM {
	private Long id;
	private String name;
	private String description;
	private String createdate;
	private qq Q;
	public qq getQ() {
		return Q;
	}
	public void setQ(qq q) {
		Q = q;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
}
