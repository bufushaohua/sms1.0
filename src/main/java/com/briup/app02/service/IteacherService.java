package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.teacher;
import com.briup.app02.vm.teacherVM;

public interface IteacherService {
	List<teacher> findAll() throws Exception;
	
	List<teacherVM> findAllteacherVM() throws Exception;
	
	teacher findById(Long id) throws Exception;
	
	void save(teacher te) throws Exception;
	
	void update(teacher te,Long oldid) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
