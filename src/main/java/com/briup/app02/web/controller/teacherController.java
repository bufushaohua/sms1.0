package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.teacher;
import com.briup.app02.service.IteacherService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.teacherVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "教师相关接口")
@RestController
@RequestMapping("/teacher")
public class teacherController {

	// 注入studentService的实例
	@Autowired
	private IteacherService teacherService;
	@ApiOperation(value="查询所有老师信息",notes="不能进行级联操作")
	// http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllteacher")
	public MsgResponse findAllteacher() {

		try {
			List<teacher> list = teacherService.findAll();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="查询所有老师信息",notes="能级联查询出班级信息")
	@GetMapping("findAllquestionVM")
	public MsgResponse findAllquestionVM(){
		try {
			List<teacherVM> list = teacherService.findAllteacherVM();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id查询老师信息",notes="这是备注")
	@GetMapping("findteacherById")
	public MsgResponse findtById(long id) {
		try {
			teacher te = teacherService.findById(id);
			return MsgResponse.success("单个教师信息查询成功！", te);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id更新老师信息",notes="这是备注")
	// 传的值比较多用PostMapper 少就用GetMapper
	@PostMapping("updateteacher")
	// 需要返回值 不能给前端工作者造成困扰
	public MsgResponse updateteacher(teacher te,Long oldid) {
		try {
			teacherService.update(te,oldid);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 保存教师信息
	 * 
	 * @author lenove
	 * @param teacher
	 * @return
	 */
	@ApiOperation(value="添加老师信息",notes="这是备注")
	@PostMapping("saveteacher")
	public MsgResponse saveteacher(teacher te) {
		try {
			teacherService.save(te);
			return MsgResponse.success("保存数据成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	@ApiOperation(value="通过id删除老师信息",notes="删除老师信息")
	@GetMapping("deleteteacher")
	public MsgResponse deleteteacher(long id) {
		try {
			teacherService.deleteById(id);
			//如果删除成功 返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在 返回错误信息 让前端开发者也知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}