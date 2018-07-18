package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.clazz;
import com.briup.app02.service.IclazzService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.clazzVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Api(tags = "班级相关接口")
@Api(description = "班级相关接口")
@RestController
@RequestMapping("/clazz")//做映射
public class clazzController {

	// 注入clazzService的实例
	@Autowired
	private IclazzService clazzService;
	// http://127.0.0.1:8080/student/findAllStudent port(端口)：8080
	@ApiOperation(value="查询所有班级",notes="只能查询出班级的基本信息，无法级联查询年级和班主任")
	@GetMapping("findAllclazz")
	public MsgResponse findAllclazz() {
		try {
			List<clazz> list = clazzService.findAll();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="查询所有班级",notes="能查询出班级的基本信息，并且级联查询年级和班主任")
	@GetMapping("findAllclazzVM")
	public MsgResponse findAllclazzVM() {
		try {
			List<clazzVM> list = clazzService.findAllclazzVM();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="按id查询班级信息",notes="findclazzById")
	@GetMapping("findclazzById")
	public MsgResponse findtById(long id) {
		try {
			clazz cl = clazzService.findById(id);
			return MsgResponse.success("单个班级信息查询成功！", cl);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过外键查询班级信息",notes="外键包含grade、teacher")
	@GetMapping("findByFk")
	public MsgResponse findByFk(Long gr_id,Long te_id){
		try {
			List<clazz> list = clazzService.findByFk(gr_id, te_id);
			return MsgResponse.success("按要求查询成功！", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="更新班级信息",notes="鞍山市")
	// 传的值比较多用PostMapper 少就用GetMapper
	@PostMapping("updateclazz")
	// 需要返回值 不能给前端工作者造成困扰
	public MsgResponse updateclazz(clazz cl,Long oldid) {
		try {
			clazzService.update(cl,oldid);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 保存班级信息
	 * 
	 * @author lenove
	 * @param clazz
	 * @return
	 */
	@PostMapping("saveclazz")
	public MsgResponse saveclazz(clazz cl) {
		try {
			clazzService.save(cl);
			return MsgResponse.success("保存数据成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	@ApiOperation(value="通过班级名字查询",notes="这是备注")
	@GetMapping("findByName")
	public MsgResponse findByName(String name){
		try {
			List<clazz> list = clazzService.findByName(name);
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id删除班级信息",notes="这是备注")
	@GetMapping("deleteclazz")
	public MsgResponse deleteclazz(long id) {
		try {
			clazzService.deleteById(id);
			//如果删除成功 返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道班级所在 返回错误信息 让前端开发者也知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}