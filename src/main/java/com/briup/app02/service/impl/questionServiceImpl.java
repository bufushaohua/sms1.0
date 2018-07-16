package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.question;
import com.briup.app02.dao.questionMapper;
import com.briup.app02.service.IquestionService;

@Service
public class questionServiceImpl implements IquestionService {
	@Autowired
	private questionMapper que;
	
	@Override
	public List<question> findAll() throws Exception {
		//调用studentMapper查询所有学生
		List<question> list = que.findAll();
		return list;
	}

	@Override
	public question findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return que.findById(id);
	}
	
	@Override
	public void save(question qu) throws Exception {
		// TODO Auto-generated method stub
		que.save(qu);
	}

	@Override
	public void update(question qu,Long oldid) throws Exception {
		// TODO Auto-generated method stub
		que.update(qu,oldid);
	}
	@Override
	public void deleteById(Long id) throws Exception {
		question qu = que.findById(id);
		if(qu != null){
		// 
			que.deleteById(id);
		}else{
			throw new Exception("你要的问题不存在！");
		}
	}
	
}