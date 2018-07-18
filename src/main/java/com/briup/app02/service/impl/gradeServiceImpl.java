package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.grade;
import com.briup.app02.dao.gradeMapper;
import com.briup.app02.dao.extend.gradeVMMapper;
import com.briup.app02.service.IgradeService;
import com.briup.app02.vm.gradeVM;

@Service
public class gradeServiceImpl implements IgradeService {
	@Autowired
	private gradeMapper gra;
	@Autowired
	private gradeVMMapper GradeVMMapper;
	@Override
	public List<grade> findAll() throws Exception {
		//调用studentMapper查询所有学生
		List<grade> list = gra.findAll();
		return list;
	}

	@Override
	public grade findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return gra.findById(id);
	}
	
	@Override
	public void save(grade sc) throws Exception {
		// TODO Auto-generated method stub
		gra.save(sc);
	}

	@Override
	public void update(grade sc,Long id) throws Exception {
		// TODO Auto-generated method stub
		gra.update(sc,id);
	}
	@Override
	public void deleteById(Long id) throws Exception {
		grade sc = gra.findById(id);
		if(sc != null){
		// 
			gra.deleteById(id);
		}else{
			throw new Exception("你要的学校不存在！");
		}
	}

	@Override
	public List<gradeVM> findAllGradeVM() throws Exception {
		// TODO Auto-generated method stub
		return GradeVMMapper.findAllgradeVM();
	}
	
}