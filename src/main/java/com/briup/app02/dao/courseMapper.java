package com.briup.app02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.app02.bean.course;

public interface courseMapper {
	List<course> findAll();
	
	course findById(Long id);
	
	void save(@Param("course")course co);
	
	void update(@Param("course")course co,@Param("id")Long oldid);
	
	void deleteById(Long id);
}
