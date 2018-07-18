package com.briup.app02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.app02.bean.clazz;

public interface clazzMapper {
	List<clazz> findAll();
	
	List<clazz> findByteacherId(Long id);
	
 	List<clazz> findByFk(@Param("grade")Long grade,@Param("teacher")Long teacher);
	
	clazz findById(Long id);
	
	List<clazz> findByName(String name);
	
	void save(clazz cl);
	
	void update(@Param("clazz")clazz cl,@Param("id")Long oldid);
	
	void deleteById(Long id);
}
