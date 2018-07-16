package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.question;

public interface IquestionService {
	List<question> findAll() throws Exception;
	
	question findById(Long id) throws Exception;
	
	void save(question qu) throws Exception;
	
	void update(question qu,Long oldid) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
