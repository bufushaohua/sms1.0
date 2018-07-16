package com.briup.app02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.app02.bean.grade;

public interface gradeMapper {
	List<grade> findAll();
	
	grade findById(Long id);
	
	void save(@Param("grade")grade grade);
	
	void update(@Param("grade")grade grade,Long id);
	
	void deleteById(Long id);
}
