package com.briup.app02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.app02.bean.option;

public interface optionMapper {
	List<option> findAll();
	
	option findById(Long id);
	
	void save(@Param("option")option op);
	
	void update(@Param("option")option op,@Param("id")Long oldid);
	
	void deleteById(Long id);
}
