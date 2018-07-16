package com.briup.app02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.app02.bean.question;

public interface questionMapper {
	List<question> findAll();
	
	question findById(Long id);
	
	void save(@Param("question")question qu);
	
	void update(@Param("question")question qu,@Param("id")Long oldid);
	
	void deleteById(Long id);
}
