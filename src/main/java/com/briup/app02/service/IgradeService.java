package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.grade;
import com.briup.app02.vm.gradeVM;

public interface IgradeService {
	List<grade> findAll() throws Exception;
	
	grade findById(Long id) throws Exception;
	
	List<gradeVM> findAllGradeVM() throws Exception;
	
	void save(grade sc) throws Exception;
	
	void update(grade sc,Long id) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
