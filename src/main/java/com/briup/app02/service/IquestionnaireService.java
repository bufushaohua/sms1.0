package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.questionnaire;
import com.briup.app02.vm.questionnaireVM;

public interface IquestionnaireService {
	List<questionnaire> findAll() throws Exception;
	
	questionnaire findById(Long id) throws Exception;
	
	List<questionnaireVM> findAllQuestionnaireVM() throws Exception;
	
	void save(questionnaire qu) throws Exception;
	
	void update(questionnaire qu,Long oldid) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
