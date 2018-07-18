package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.course;
import com.briup.app02.service.IcourseService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "课程信息接口")
@RestController
@RequestMapping("/course")
public class courseController {

	// 注入studentService的实例
	@Autowired
	private IcourseService courseService;

	// http://127.0.0.1:8080/student/findAllStudent
	@ApiOperation(value="查找所有课程信息",notes="这是备注")
	@GetMapping("findAllcourse")
	public MsgResponse findAllcourse() {

		try {
			List<course> list = courseService.findAll();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id查找课程信息",notes="这是备注")
	@GetMapping("findcourseById")
	public MsgResponse findtById(long id) {
		try {
			course co = courseService.findById(id);
			return MsgResponse.success("单个课程信息查询成功！", co);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// 传的值比较多用PostMapper 少就用GetMapper
	@ApiOperation(value="更新课程信息",notes="这是备注")
	@PostMapping("updatecourse")
	// 需要返回值 不能给前端工作者造成困扰
	public MsgResponse updatecourse(course co,Long oldid) {
		try {
			courseService.update(co,oldid);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 保存课程信息
	 * 
	 * @author lenove
	 * @param course
	 * @return
	 */
	@ApiOperation(value="添加课程信息",notes="这是备注")
	@PostMapping("savecourse")
	public MsgResponse savecourse(course co) {
		try {
			courseService.save(co);
			return MsgResponse.success("保存数据成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	@ApiOperation(value="通过id删除课程信息",notes="这是备注")
	@GetMapping("deletecourse")
	public MsgResponse deletecourse(long id) {
		try {
			courseService.deleteById(id);
			//如果删除成功 返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在 返回错误信息 让前端开发者也知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}