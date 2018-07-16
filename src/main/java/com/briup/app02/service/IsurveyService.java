package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.survey;

public interface IsurveyService {
	List<survey> findAll() throws Exception;
	
	survey findById(Long id) throws Exception;
	
	void save(survey su) throws Exception;
	
	void update(survey su,Long oldid) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
