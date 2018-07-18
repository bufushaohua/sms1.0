package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.answer;
import com.briup.app02.service.IanswerService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "问卷答案接口")
@RestController
@RequestMapping("/answer")
public class answerController {

	// 注入studentService的实例
	@Autowired
	private IanswerService answerService;

	// http://127.0.0.1:8080/student/findAllStudent
	@ApiOperation(value="查找所有问卷答案",notes="这是不能级联查询出课调信息")
	@GetMapping("findAllanswer")
	public MsgResponse findAllanswer() {

		try {
			List<answer> list = answerService.findAll();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过外键查找问卷答案",notes="这是备注")
	@GetMapping("findByFk")
	public MsgResponse findByFk(Long survey_id){
		try {
			List<answer> list = answerService.findByFk(survey_id);
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id查找问卷答案",notes="这是备注")
	@GetMapping("findanswerById")
	public MsgResponse findtById(long id) {
		try {
			answer an = answerService.findById(id);
			return MsgResponse.success("单个答案信息查询成功！", an);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// 传的值比较多用PostMapper 少就用GetMapper
	@ApiOperation(value="更新问卷答案信息",notes="这是备注")
	@PostMapping("updateanswer")
	// 需要返回值 不能给前端工作者造成困扰
	public MsgResponse updateanswer(answer an,Long oldid) {
		try {
			answerService.update(an,oldid);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 保存答案信息
	 * 
	 * @author lenove
	 * @param answer
	 * @return
	 */
	@ApiOperation(value="添加问卷答案信息",notes="这是备注")
	@PostMapping("saveanswer")
	public MsgResponse saveanswer(answer an) {
		try {
			answerService.save(an);
			return MsgResponse.success("保存数据成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	@ApiOperation(value="通过id删除问卷答案信息",notes="这是备注")
	@GetMapping("deleteanswer")
	public MsgResponse deleteanswer(long id) {
		try {
			answerService.deleteById(id);
			//如果删除成功 返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道答案所在 返回错误信息 让前端开发者也知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}