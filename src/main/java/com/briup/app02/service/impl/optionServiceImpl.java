package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.option;
import com.briup.app02.dao.optionMapper;
import com.briup.app02.dao.extend.optionVMMapper;
import com.briup.app02.service.IoptionService;
import com.briup.app02.vm.optionVM;

@Service
public class optionServiceImpl implements IoptionService {
	@Autowired
	private optionMapper opt;
	@Autowired 
	private optionVMMapper optionvmmapper;
	@Override
	public List<option> findAll() throws Exception {
		//调用optionMapper查询所有学生
		List<option> list = opt.findAll();
		return list;
	}

	@Override
	public option findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return opt.findById(id);
	}
	
	@Override
	public void save(option op) throws Exception {
		// TODO Auto-generated method stub
		opt.save(op);
	}

	@Override
	public void update(option op,Long oldid) throws Exception {
		// TODO Auto-generated method stub
		opt.update(op,oldid);
	}
	@Override
	public void deleteById(Long id) throws Exception {
		option op = opt.findById(id);
		if(op != null){
		// 
			opt.deleteById(id);
		}else{
			throw new Exception("你要的选项不存在！");
		}
	}

	@Override
	public List<option> findByFk(Long question_id) {
		List<option> list = opt.findByFk(question_id);
		return list;
	}

	@Override
	public List<optionVM> findAlloptionVM() throws Exception {
		return optionvmmapper.findAlloptionVM();
	}
	
}