package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.qq;
import com.briup.app02.dao.qqMapper;
import com.briup.app02.dao.extend.qqVMMapper;
import com.briup.app02.service.IqqService;
import com.briup.app02.vm.qqVM;

@Service
public class qqServiceImpl implements IqqService {
	@Autowired
	private qqMapper opt;
	@Autowired
	private qqVMMapper qqvmmapper;
	@Override
	public List<qq> findAll() throws Exception {
		//调用qqMapper查询所有学生
		List<qq> list = opt.findAll();
		return list;
	}

	@Override
	public qq findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return opt.findById(id);
	}
	
	@Override
	public void save(qq op) throws Exception {
		// TODO Auto-generated method stub
		opt.save(op);
	}

	@Override
	public void update(qq op,Long oldid) throws Exception {
		// TODO Auto-generated method stub
		opt.update(op,oldid);
	}
	@Override
	public void deleteById(Long id) throws Exception {
		qq op = opt.findById(id);
		if(op != null){
		// 
			opt.deleteById(id);
		}else{
			throw new Exception("你要的选项不存在！");
		}
	}

	@Override
	public List<qqVM> findAlqqVM() throws Exception {
		return qqvmmapper.findAllqqVM();
	}
	
}