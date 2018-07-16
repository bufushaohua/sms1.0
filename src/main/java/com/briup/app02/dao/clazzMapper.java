package com.briup.app02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.app02.bean.clazz;
import com.briup.app02.bean.grade;
import com.briup.app02.bean.teacher;

public interface clazzMapper {
	List<clazz> findAll();
	
 	List<clazz> findByFk(@Param("grade")grade gr,@Param("teacher")teacher te);
	
	clazz findById(Long id);
	
	void save(clazz cl);
	
	void update(@Param("clazz")clazz cl,@Param("id")Long oldid);
	
	void deleteById(Long id);
}
