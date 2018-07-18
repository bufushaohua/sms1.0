package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.qq;
import com.briup.app02.service.IqqService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.qqVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "问题与问卷关系信息接口")
@RestController
@RequestMapping("/qq")
public class qqController {

	// 注入studentService的实例
	@Autowired
	private IqqService qqService;

	// http://127.0.0.1:8080/student/findAllStudent
	@ApiOperation(value="查找所有问题与问卷关系信息",notes="不能进行级联操作")
	@GetMapping("findAllqq")
	public MsgResponse findAllqq() {

		try {
			List<qq> list = qqService.findAll();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id查找问题与问卷关系信息",notes="这是备注")
	@GetMapping("findqqById")
	public MsgResponse findtById(long id) {
		try {
			qq op = qqService.findById(id);
			return MsgResponse.success("单个问题与问卷关系信息查询成功！", op);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="查找所有问题与问卷信息",notes="可以进行级联操作")
	@GetMapping("findAllqqVM")
	public MsgResponse findAllqqVM(){
		try {
			List<qqVM> list = qqService.findAlqqVM();
			return MsgResponse.success("查找成功！", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	// 传的值比较多用PostMapper 少就用GetMapper
	@ApiOperation(value="更新所有问题与问卷信息",notes="这是备注")
	@PostMapping("updateqq")
	// 需要返回值 不能给前端工作者造成困扰
	public MsgResponse updateqq(qq op,Long oldid) {
		try {
			qqService.update(op,oldid);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 保存问题与问卷关系信息
	 * 
	 * @author lenove
	 * @param qq
	 * @return
	 */
	@ApiOperation(value="添加新的问题与问卷关系信息",notes="这是备注")
	@PostMapping("saveqq")
	public MsgResponse saveqq(qq op) {
		try {
			qqService.save(op);
			return MsgResponse.success("保存数据成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	@ApiOperation(value="通过id删除问题与问卷关系信息",notes="这是备注")
	@GetMapping("deleteqq")
	public MsgResponse deleteqq(long id) {
		try {
			qqService.deleteById(id);
			//如果删除成功 返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题与问卷关系所在 返回错误信息 让前端开发者也知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}