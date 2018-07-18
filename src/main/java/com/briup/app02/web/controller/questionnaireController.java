package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.questionnaire;
import com.briup.app02.service.IquestionnaireService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.questionnaireVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "问卷相关接口")
@RestController
@RequestMapping("/questionnaire")
public class questionnaireController {

	// 注入studentService的实例
	@Autowired
	private IquestionnaireService questionnaireService;
	@ApiOperation(value="查找所有问卷信息",notes="不能进行级联操作")
	// http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllquestionnaire")
	public MsgResponse findAllquestionnaire() {

		try {
			List<questionnaire> list = questionnaireService.findAll();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="查找所有问卷信息",notes="能够级联查询出问卷与题目关系的信息")
	@GetMapping("findAllQuestionnaireVM")
	public MsgResponse findAllQuestionnaireVM(){
		try {
			List<questionnaireVM> list = questionnaireService.findAllQuestionnaireVM();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id查找所有问卷",notes="这是备注")
	@GetMapping("findquestionnaireById")
	public MsgResponse findtById(long id) {
		try {
			questionnaire qu = questionnaireService.findById(id);
			return MsgResponse.success("单个调查问卷信息查询成功！", qu);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="更新问卷信息",notes="这是备注")
	// 传的值比较多用PostMapper 少就用GetMapper
	@PostMapping("updatequestionnaire")
	// 需要返回值 不能给前端工作者造成困扰
	public MsgResponse updatequestionnaire(questionnaire qu,Long oldid) {
		try {
			questionnaireService.update(qu,oldid);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 保存调查问卷信息
	 * 
	 * @author lenove
	 * @param questionnaire
	 * @return
	 */
	@ApiOperation(value="添加问卷信息",notes="这是备注")
	@PostMapping("savequestionnaire")
	public MsgResponse savequestionnaire(questionnaire qu) {
		try {
			questionnaireService.save(qu);
			return MsgResponse.success("保存数据成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	@ApiOperation(value="通过id删除问卷信息",notes="这是备注")
	@GetMapping("deletequestionnaire")
	public MsgResponse deletequestionnaire(long id) {
		try {
			questionnaireService.deleteById(id);
			//如果删除成功 返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道调查问卷所在 返回错误信息 让前端开发者也知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}