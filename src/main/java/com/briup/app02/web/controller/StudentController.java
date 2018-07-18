package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Student;
import com.briup.app02.service.IStudentService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "学生相关接口")
@RestController
@RequestMapping("/student")
public class StudentController {

	// 注入studentService的实例
	@Autowired
	private IStudentService studentService;
	@ApiOperation(value="查找所有学生信息",notes="不能进行级联操作")
	// http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllStudent")
	public MsgResponse findAllStudent() {

		try {
			List<Student> list = studentService.findAll();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id查找所有学生信息",notes="这是备注")
	@GetMapping("findStudentById")
	public MsgResponse findStudentById(long id) {
		try {
			Student student = studentService.findById(id);
			return MsgResponse.success("单个学生信息查询成功！", student);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="更新学生信息",notes="这是备注")
	// 传的值比较多用PostMapper 少就用GetMapper
	@PostMapping("updateStudent")
	// 需要返回值 不能给前端工作者造成困扰
	public MsgResponse updateStudent(Student student) {
		try {
			studentService.update(student);
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
	 * @param student
	 * @return
	 */
	@ApiOperation(value="添加学生信息",notes="这是备注")
	@PostMapping("saveStudent")
	public MsgResponse saveStudent(Student student) {
		try {
			studentService.save(student);
			return MsgResponse.success("保存数据成功！", null);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	@ApiOperation(value="通过id删除学生信息",notes="这是备注")
	@GetMapping("deleteStudent")
	public MsgResponse deleteStudent(long id) {
		try {
			studentService.deleteById(id);
			//如果删除成功 返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在 返回错误信息 让前端开发者也知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}