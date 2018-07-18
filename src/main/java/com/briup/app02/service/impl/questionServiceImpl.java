package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.option;
import com.briup.app02.bean.question;
import com.briup.app02.dao.optionMapper;
import com.briup.app02.dao.questionMapper;
import com.briup.app02.dao.extend.questionVMMapper;
import com.briup.app02.service.IquestionService;
import com.briup.app02.vm.questionVM;

@Service
public class questionServiceImpl implements IquestionService {
	@Autowired
	private questionMapper que;
	@Autowired
	private optionMapper OptionMapper;
	@Autowired
	private questionVMMapper questionvmmapper;
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

	@Override
	public List<questionVM> findAllQuestionVM() throws Exception {
		return questionvmmapper.findAllquestionVM();
	}

	@Override
	public void saveQuestion(questionVM Q) throws Exception {
		/**
		 * 1.将question和option从questionVM中剥离出来
		 * 
		 * */
		//1.剥离出来question  option
		Long questionId = Q.getId();
		String questionName = Q.getName();
		String questionType = Q.getQuestiontype();
		question q = new question(questionId, questionName, questionType);
		List<option> options = Q.getOptions();
		//2.保存问题
		que.save(q);
		//3.获取刚刚保存的问题的id
		Long question_id = q.getId();
		System.out.println();
		//4.保存选项
		for(option op : options){
			op.setQuestion_id(question_id);
			OptionMapper.save(op);
		}
		
	}
	
}