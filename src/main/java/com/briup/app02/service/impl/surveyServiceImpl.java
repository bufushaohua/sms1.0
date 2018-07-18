package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.survey;
import com.briup.app02.dao.surveyMapper;
import com.briup.app02.dao.extend.surveyVMMapper;
import com.briup.app02.service.IsurveyService;
import com.briup.app02.vm.surveyVM;

@Service
public class surveyServiceImpl implements IsurveyService {
	@Autowired
	private surveyMapper sur;
	@Autowired 
	private surveyVMMapper surveyvmmapper;
	@Override
	public List<survey> findAll() throws Exception {
		//调用surveyMapper查询所有学生
		List<survey> list = sur.findAll();
		return list;
	}

	@Override
	public survey findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return sur.findById(id);
	}
	
	@Override
	public void save(survey op) throws Exception {
		// TODO Auto-generated method stub
		sur.save(op);
	}

	@Override
	public void update(survey op,Long oldid) throws Exception {
		// TODO Auto-generated method stub
		sur.update(op,oldid);
	}
	@Override
	public void deleteById(Long id) throws Exception {
		survey op = sur.findById(id);
		if(op != null){
		// 
			sur.deleteById(id);
		}else{
			throw new Exception("你要的调查表不存在！");
		}
	}

	@Override
	public List<surveyVM> findAllsurveyVM() throws Exception {
		return surveyvmmapper.findAllsurveyVM();
	}

	@Override
	public List<surveyVM> findAllnextVM() throws Exception {
		// TODO Auto-generated method stub
		return surveyvmmapper.findAllnextVM();
	}

	@Override
	public List<surveyVM> findAllsurvey_answerVM() throws Exception {
		// TODO Auto-generated method stub
		return surveyvmmapper.findAllsurvey_answerVM();
	}
	
}