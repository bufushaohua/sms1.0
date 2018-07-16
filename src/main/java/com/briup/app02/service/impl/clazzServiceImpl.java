package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.clazz;
import com.briup.app02.bean.grade;
import com.briup.app02.bean.teacher;
import com.briup.app02.dao.clazzMapper;
import com.briup.app02.service.IclazzService;

@Service
public class clazzServiceImpl implements IclazzService {
	@Autowired
	private clazzMapper cla;
	private grade grade;
	private teacher teacher;
	@Override
	public List<clazz> findAll() throws Exception {
		//调用clazzMapper查询所有学生
		List<clazz> list = cla.findAll();
		return list;
	}

	@Override
	public clazz findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return cla.findById(id);
	}
	
	@Override
	public void save(clazz cl) throws Exception {
		cla.save(cl);
	}

	@Override
	public void update(clazz cl,Long oldid) throws Exception {
		// TODO Auto-generated method stub
		cla.update(cl,oldid);
	}
	@Override
	public void deleteById(Long id) throws Exception {
		clazz cl = cla.findById(id);
		if(cl != null){
		// 
			cla.deleteById(id);
		}else{
			throw new Exception("你要的班级不存在！");
		}
	}
	//通过外键查询
	@Override
	public List<clazz> findByFk(grade gr, teacher te) throws Exception { 
		List<clazz> list = cla.findByFk(gr, te);
		return list;
	}
	
}