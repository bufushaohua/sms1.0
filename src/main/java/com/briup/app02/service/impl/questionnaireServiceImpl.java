package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.questionnaire;
import com.briup.app02.dao.questionnaireMapper;
import com.briup.app02.service.IquestionnaireService;

@Service
public class questionnaireServiceImpl implements IquestionnaireService {
	@Autowired
	private questionnaireMapper que;
	
	@Override
	public List<questionnaire> findAll() throws Exception {
		//调用questionnaireMapper查询所有学生
		List<questionnaire> list = que.findAll();
		return list;
	}

	@Override
	public questionnaire findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return que.findById(id);
	}
	
	@Override
	public void save(questionnaire qu) throws Exception {
		// TODO Auto-generated method stub
		que.save(qu);
	}

	@Override
	public void update(questionnaire qu,Long oldid) throws Exception {
		// TODO Auto-generated method stub
		que.update(qu,oldid);
	}
	@Override
	public void deleteById(Long id) throws Exception {
		questionnaire qu = que.findById(id);
		if(qu != null){
		// 
			que.deleteById(id);
		}else{
			throw new Exception("你要的调查问卷不存在！");
		}
	}
	
}