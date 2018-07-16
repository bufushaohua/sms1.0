package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.school;
import com.briup.app02.service.IschoolService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/school")
public class schoolController {

	// 注入studentService的实例
	@Autowired
	private IschoolService schoolService;

	// http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllSchool")
	public MsgResponse findAllSchool() {

		try {
			List<school> list = schoolService.findAll();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findSchoolById")
	public MsgResponse findtById(long id) {
		try {
			school sc = schoolService.findById(id);
			return MsgResponse.success("单个学生信息查询成功！", sc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// 传的值比较多用PostMapper 少就用GetMapper
	@PostMapping("updateSchool")
	// 需要返回值 不能给前端工作者造成困扰
	public MsgResponse updateSchool(school sc,Long id) {
		try {
			schoolService.update(sc,id);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 保存学生信息
	 * 
	 * @author lenove
	 * @param school
	 * @return
	 */
	@PostMapping("saveSchool")
	public MsgResponse saveSchool(school sc,Long id) {
		try {
			schoolService.save(sc,id);
			return MsgResponse.success("保存数据成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@GetMapping("deleteSchool")
	public MsgResponse deleteSchool(long id) {
		try {
			schoolService.deleteById(id);
			//如果删除成功 返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在 返回错误信息 让前端开发者也知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}