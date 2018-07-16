package com.briup.app02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.app02.bean.survey;

public interface surveyMapper {
	List<survey> findAll();
	
	survey findById(Long id);
	
	void save(@Param("survey")survey su);
	
	void update(@Param("survey")survey su,@Param("id")Long oldid);
	
	void deleteById(Long id);
}
