package com.briup.app02.vm;

import java.util.List;

import com.briup.app02.bean.answer;
import com.briup.app02.bean.clazz;
import com.briup.app02.bean.course;
import com.briup.app02.bean.grade;
import com.briup.app02.bean.questionnaire;
import com.briup.app02.bean.teacher;

public class surveyVM {
	private Long id;
	private String state;
	private Double average;
	private List<grade> class_grade;
	private List<answer> answer; 
	private questionnaire questionnaire;
	private clazz clazz;
	private teacher teacher;
	private course course;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Double getAverage() {
		return average;
	}
	public void setAverage(Double average) {
		this.average = average;
	}
	public questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	public clazz getClazz() {
		return clazz;
	}
	public void setClazz(clazz clazz) {
		this.clazz = clazz;
	}
	public teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(teacher teacher) {
		this.teacher = teacher;
	}
	public course getCourse() {
		return course;
	}
	public void setCourse(course course) {
		this.course = course;
	}
	public List<grade> getClass_grade() {
		return class_grade;
	}
	public void setClass_grade(List<grade> class_grade) {
		this.class_grade = class_grade;
	}
	public List<answer> getAnswer() {
		return answer;
	}
	public void setAnswer(List<answer> answer) {
		this.answer = answer;
	}
}
