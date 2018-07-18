package com.briup.app02.vm;

import com.briup.app02.bean.question;
import com.briup.app02.bean.questionnaire;

public class qqVM {
	private Long id;
	private question question;
	private questionnaire questionnaire;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public question getQuestion() {
		return question;
	}
	public void setQuestion(question question) {
		this.question = question;
	}
	public questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
}
