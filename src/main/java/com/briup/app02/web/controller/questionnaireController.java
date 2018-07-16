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

@RestController
@RequestMapping("/questionnaire")
public class questionnaireController {

	// 注入studentService的实例
	@Autowired
	private IquestionnaireService questionnaireService;

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