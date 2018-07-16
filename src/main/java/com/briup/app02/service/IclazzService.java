package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.clazz;
import com.briup.app02.bean.grade;
import com.briup.app02.bean.teacher;

public interface IclazzService {
	List<clazz> findAll() throws Exception;
	
 	List<clazz> findByFk(grade gr,teacher te)throws Exception;
 	
	clazz findById(Long id) throws Exception;
	
	void save(clazz cl) throws Exception;
	
	void update(clazz cl,Long oldid) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
