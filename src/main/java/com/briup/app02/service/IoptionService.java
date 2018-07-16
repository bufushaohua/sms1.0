package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.option;

public interface IoptionService {
	List<option> findAll() throws Exception;
	
	option findById(Long id) throws Exception;
	
	void save(option op) throws Exception;
	
	void update(option op,Long oldid) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
