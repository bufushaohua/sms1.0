package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.school;
import com.briup.app02.dao.schoolMapper;
import com.briup.app02.service.IschoolService;

@Service
public class schoolServiceImpl implements IschoolService {
	@Autowired
	private schoolMapper sch1;
	
	@Override
	public List<school> findAll() throws Exception {
		//调用studentMapper查询所有学生
		List<school> list = sch1.findAll();
		return list;
	}

	@Override
	public school findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return sch1.findById(id);
	}
	
	@Override
	public void save(school sc,Long id) throws Exception {
		// TODO Auto-generated method stub
		sch1.save(sc,id);
	}

	@Override
	public void update(school sc,Long id) throws Exception {
		// TODO Auto-generated method stub
		sch1.update(sc,id);
	}
	@Override
	public void deleteById(Long id) throws Exception {
		school sc = sch1.findById(id);
		if(sc != null){
		// 
			sch1.deleteById(id);
		}else{
			throw new Exception("你要的学校不存在！");
		}
	}
	
}