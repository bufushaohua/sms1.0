package com.briup.app02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.app02.bean.qq;

public interface qqMapper {
	List<qq> findAll();
	
	qq findById(Long id);
	
	List<qq> findByQuestionnaireId(Long id);
	
	void save(@Param("qq")qq op);
	
	void update(@Param("qq")qq op,@Param("id")Long oldid);
	
	void deleteById(Long id);
}
