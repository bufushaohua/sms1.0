package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.clazz;
import com.briup.app02.vm.clazzVM;

public interface IclazzService {
	List<clazz> findAll() throws Exception;
	
	List<clazzVM> findAllclazzVM()throws Exception;
	
 	List<clazz> findByFk(Long grade_id,Long teacher_id)throws Exception;
 	
	clazz findById(Long id) throws Exception;
	
	List<clazz> findByName(String name)throws Exception;
	
	void save(clazz cl) throws Exception;
	
	void update(clazz cl,Long oldid) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
