package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.qq;

public interface IqqService {
	List<qq> findAll() throws Exception;
	
	qq findById(Long id) throws Exception;
	
	void save(qq op) throws Exception;
	
	void update(qq op,Long oldid) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
