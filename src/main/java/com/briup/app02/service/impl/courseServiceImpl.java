package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.course;
import com.briup.app02.dao.courseMapper;
import com.briup.app02.service.IcourseService;

@Service
public class courseServiceImpl implements IcourseService {
	@Autowired
	private courseMapper cou;
	
	@Override
	public List<course> findAll() throws Exception {
		//调用studentMapper查询所有学生
		List<course> list = cou.findAll();
		return list;
	}

	@Override
	public course findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return cou.findById(id);
	}
	
	@Override
	public void save(course co) throws Exception {
		// TODO Auto-generated method stub
		cou.save(co);
	}

	@Override
	public void update(course co,Long oldid) throws Exception {
		// TODO Auto-generated method stub
		cou.update(co,oldid);
	}
	@Override
	public void deleteById(Long id) throws Exception {
		course co = cou.findById(id);
		if(co != null){
		// 
			cou.deleteById(id);
		}else{
			throw new Exception("你要的课程不存在！");
		}
	}
	
}