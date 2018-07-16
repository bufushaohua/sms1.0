package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.course;

public interface IcourseService {
	List<course> findAll() throws Exception;
	
	course findById(Long id) throws Exception;
	
	void save(course co) throws Exception;
	
	void update(course co,Long oldid) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
