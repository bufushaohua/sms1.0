package com.briup.app02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.app02.bean.teacher;

public interface teacherMapper {
	List<teacher> findAll();
	
	teacher findById(Long id);
	
	void save(@Param("teacher")teacher te);
	
	void update(@Param("teacher")teacher te,@Param("id")Long oldid);
	
	void deleteById(Long id);
}
