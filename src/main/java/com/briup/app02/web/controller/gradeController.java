package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.grade;
import com.briup.app02.service.IgradeService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "年级信息接口")
@RestController
@RequestMapping("/grade")
public class gradeController {

	// 注入studentService的实例
	@Autowired
	private IgradeService gradeService;

	// http://127.0.0.1:8080/student/findAllStudent
	@ApiOperation(value="查找所有年级信息",notes="这是备注")
	@GetMapping("findAllgrade")
	public MsgResponse findAllgrade() {

		try {
			List<grade> list = gradeService.findAll();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id查找年级",notes="这是备注")
	@GetMapping("findgradeById")
	public MsgResponse findtById(long id) {
		try {
			grade sc = gradeService.findById(id);
			return MsgResponse.success("单个成绩信息查询成功！", sc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="更新年级信息",notes="这是备注")
	// 传的值比较多用PostMapper 少就用GetMapper
	@PostMapping("updategrade")
	// 需要返回值 不能给前端工作者造成困扰
	public MsgResponse updategrade(grade sc,Long id) {
		try {
			gradeService.update(sc,id);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 保存成绩信息
	 * 
	 * @author lenove
	 * @param grade
	 * @return
	 */
	@ApiOperation(value="添加一个年级信息",notes="这是备注")
	@PostMapping("savegrade")
	public MsgResponse savegrade(grade sc) {
		try {
			gradeService.save(sc);
			return MsgResponse.success("保存数据成功！", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	@ApiOperation(value="通过id删除年级信息",notes="这是备注")
	@GetMapping("deletegrade")
	public MsgResponse deletegrade(long id) {
		try {
			gradeService.deleteById(id);
			//如果删除成功 返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在 返回错误信息 让前端开发者也知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}