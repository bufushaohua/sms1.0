package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.teacher;
import com.briup.app02.dao.teacherMapper;
import com.briup.app02.service.IteacherService;

@Service
public class teacherServiceImpl implements IteacherService {
	@Autowired
	private teacherMapper tea;
	
	@Override
	public List<teacher> findAll() throws Exception {
		//调用studentMapper查询所有学生
		List<teacher> list = tea.findAll();
		return list;
	}

	@Override
	public teacher findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return tea.findById(id);
	}
	
	@Override
	public void save(teacher te) throws Exception {
		// TODO Auto-generated method stub
		tea.save(te);
	}

	@Override
	public void update(teacher te,Long oldid) throws Exception {
		// TODO Auto-generated method stub
		tea.update(te,oldid);
	}
	@Override
	public void deleteById(Long id) throws Exception {
		teacher te = tea.findById(id);
		if(te != null){
		// 
			tea.deleteById(id);
		}else{
			throw new Exception("你要的教师不存在！");
		}
	}
	
}