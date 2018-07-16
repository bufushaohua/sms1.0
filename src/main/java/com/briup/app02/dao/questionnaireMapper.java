package com.briup.app02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.app02.bean.questionnaire;

public interface questionnaireMapper {
	List<questionnaire> findAll();
	
	questionnaire findById(Long id);
	
	void save(@Param("questionnaire")questionnaire qu);
	
	void update(@Param("questionnaire")questionnaire qu,@Param("id")Long oldid);
	
	void deleteById(Long id);
}
