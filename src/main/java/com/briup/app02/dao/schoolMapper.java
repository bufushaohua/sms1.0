package com.briup.app02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.app02.bean.school;

public interface schoolMapper {
	List<school> findAll();
	
	school findById(Long id);
	
	void save(@Param("school")school school,@Param("id")Long id);
	
	void update(@Param("school")school school,@Param("id")Long id);
	
	void deleteById(Long id);
}
