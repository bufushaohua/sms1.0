package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.survey;
import com.briup.app02.service.IsurveyService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.surveyVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "课调信息接口")
@RestController
@RequestMapping("/survey")
public class surveyController {

	// 注入studentService的实例
	@Autowired
	private IsurveyService surveyService;
	@ApiOperation(value="查找",notes="这是备注")
	// http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllsurvey")
	public MsgResponse findAllsurvey() {

		try {
			List<survey> list = surveyService.findAll();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findsurveyById")
	public MsgResponse findtById(long id) {
		try {
			survey su = surveyService.findById(id);
			return MsgResponse.success("单个选项信息查询成功！", su);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllsurvey_answerVM")
	public MsgResponse findAllsurvey_answerVM(){
		try {
			List<surveyVM> list = surveyService.findAllsurvey_answerVM();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllsurveyVM")
	public MsgResponse findAllsurveyVM(){
		try {
			List<surveyVM> list = surveyService.findAllsurveyVM();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllnextVM")
	public MsgResponse findAllnextVM(){
		try {
			List<surveyVM> list = surveyService.findAllnextVM();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	// 传的值比较多用PostMapper 少就用GetMapper
	@PostMapping("updatesurvey")
	// 需要返回值 不能给前端工作者造成困扰
	public MsgResponse updatesurvey(survey su,Long oldid) {
		try {
			surveyService.update(su,oldid);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 保存选项信息
	 * 
	 * @author lenove
	 * @param survey
	 * @return
	 */
	@PostMapping("savesurvey")
	public MsgResponse savesurvey(survey su) {
		try {
			surveyService.save(su);
			return MsgResponse.success("保存数据成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@GetMapping("deletesurvey")
	public MsgResponse deletesurvey(long id) {
		try {
			surveyService.deleteById(id);
			//如果删除成功 返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道选项所在 返回错误信息 让前端开发者也知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}