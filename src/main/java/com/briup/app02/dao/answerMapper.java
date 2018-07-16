package com.briup.app02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.app02.bean.answer;

public interface answerMapper {
	List<answer> findAll();
	
	answer findById(Long id);
	
	void save(@Param("answer")answer an);
	
	void update(@Param("answer")answer an,@Param("id")Long oldid);
	
	void deleteById(Long id);
}
