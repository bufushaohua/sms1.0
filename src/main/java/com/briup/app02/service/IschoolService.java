package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.school;

public interface IschoolService {
	
	List<school> findAll() throws Exception;
	
	school findById(Long id) throws Exception;
	
	void save(school sc,Long id) throws Exception;
	
	void update(school sc,Long id) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
