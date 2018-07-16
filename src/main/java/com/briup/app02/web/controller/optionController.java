package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.option;
import com.briup.app02.service.IoptionService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/option")
public class optionController {

	// 注入studentService的实例
	@Autowired
	private IoptionService optionService;

	// http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAlloption")
	public MsgResponse findAlloption() {

		try {
			List<option> list = optionService.findAll();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findoptionById")
	public MsgResponse findtById(long id) {
		try {
			option op = optionService.findById(id);
			return MsgResponse.success("单个选项信息查询成功！", op);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// 传的值比较多用PostMapper 少就用GetMapper
	@PostMapping("updateoption")
	// 需要返回值 不能给前端工作者造成困扰
	public MsgResponse updateoption(option op,Long oldid) {
		try {
			optionService.update(op,oldid);
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
	 * @param option
	 * @return
	 */
	@PostMapping("saveoption")
	public MsgResponse saveoption(option op) {
		try {
			optionService.save(op);
			return MsgResponse.success("保存数据成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@GetMapping("deleteoption")
	public MsgResponse deleteoption(long id) {
		try {
			optionService.deleteById(id);
			//如果删除成功 返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道选项所在 返回错误信息 让前端开发者也知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}