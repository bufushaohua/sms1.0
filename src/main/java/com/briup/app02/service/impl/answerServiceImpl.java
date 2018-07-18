package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.answer;
import com.briup.app02.dao.answerMapper;
import com.briup.app02.service.IanswerService;

@Service
public class answerServiceImpl implements IanswerService {
	@Autowired
	private answerMapper ans;
	
	@Override
	public List<answer> findAll() throws Exception {
		//调用answerMapper查询所有学生
		List<answer> list = ans.findAll();
		return list;
	}

	@Override
	public answer findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return ans.findById(id);
	}
	
	@Override
	public void save(answer op) throws Exception {
		// TODO Auto-generated method stub
		ans.save(op);
	}

	@Override
	public void update(answer op,Long oldid) throws Exception {
		// TODO Auto-generated method stub
		ans.update(op,oldid);
	}
	@Override
	public void deleteById(Long id) throws Exception {
		answer op = ans.findById(id);
		if(op != null){
		// 
			ans.deleteById(id);
		}else{
			throw new Exception("你要的答案不存在！");
		}
	}

	@Override
	public List<answer> findByFk(Long survey_id) throws Exception {
		List<answer> list = ans.findByFk(survey_id);
		return list;
	}
	
}