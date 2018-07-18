package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.answer;

public interface IanswerService {
	List<answer> findAll() throws Exception;
	
	answer findById(Long id) throws Exception;
	
	List<answer> findByFk(Long survey_id) throws Exception;
	
	void save(answer an) throws Exception;
	
	void update(answer an,Long oldid) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
