package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.question;
import com.briup.app02.service.IquestionService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.questionVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "问题相关接口")
@RestController
@RequestMapping("/question")
public class questionController {

	// 注入studentService的实例
	@Autowired
	private IquestionService questionService;
	@ApiOperation(value ="保存问题",notes = "保存问题的同时还应该保存选项")
	@PostMapping("savequestionVM")
	public MsgResponse savequestionVM(questionVM que){
		try {
			//调用业务逻辑层方法完成保存
			questionService.saveQuestion(que);
			return MsgResponse.success("保存成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// http://127.0.0.1:8080/student/findAllStudent
	@ApiOperation(value="查找所有问题信息",notes="不能进行级联操作")
	@GetMapping("findAllquestion")
	public MsgResponse findAllquestion() {

		try {
			List<question> list = questionService.findAll();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id查找所有问题",notes="这是备注")
	@GetMapping("findquestionById")
	public MsgResponse findtById(long id) {
		try {
			question qu = questionService.findById(id);
			return MsgResponse.success("单个问题信息查询成功！", qu);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="查找所有问题信息",notes="能进行级联操作")
	@GetMapping("findAllquestionVM")
	public MsgResponse findAllquestionVM(){
		try {
			List<questionVM> list = questionService.findAllQuestionVM();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	// 传的值比较多用PostMapper 少就用GetMapper
	@ApiOperation(value="更新问题信息",notes="这是备注")
	@PostMapping("updatequestion")
	// 需要返回值 不能给前端工作者造成困扰
	public MsgResponse updatequestion(question qu,Long oldid) {
		try {
			questionService.update(qu,oldid);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 保存问题信息
	 * 
	 * @author lenove
	 * @param question
	 * @return
	 */
	@ApiOperation(value="添加问题信息",notes="这是备注")
	@PostMapping("savequestion")
	public MsgResponse savequestion(question qu) {
		try {
			questionService.save(qu);
			return MsgResponse.success("保存数据成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	@ApiOperation(value="通过id删除问题信息",notes="这是备注")
	@GetMapping("deletequestion")
	public MsgResponse deletequestion(long id) {
		try {
			questionService.deleteById(id);
			//如果删除成功 返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在 返回错误信息 让前端开发者也知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}