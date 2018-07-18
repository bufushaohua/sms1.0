package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.option;
import com.briup.app02.vm.optionVM;

public interface IoptionService {
	List<option> findAll() throws Exception;
	
	List<optionVM> findAlloptionVM() throws Exception;
	
	option findById(Long id) throws Exception;
	
	List<option> findByFk(Long question_id);
	
	void save(option op) throws Exception;
	
	void update(option op,Long oldid) throws Exception;
	
	void deleteById(Long id) throws Exception;
}
