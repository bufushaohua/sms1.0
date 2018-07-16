package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.clazz;
import com.briup.app02.bean.grade;
import com.briup.app02.bean.teacher;
import com.briup.app02.service.IclazzService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/clazz")
public class clazzController {

	// 注入clazzService的实例
	@Autowired
	private IclazzService clazzService;
	private grade gr;
	private teacher te;
	// http://127.0.0.1:8080/student/findAllStudent
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
	@GetMapping("findByFk")
	public MsgResponse findByFk(Long gr_id,Long te_id){
		try {
			gr.setId(gr_id);
			te.setId(te_id);
			List<clazz> list = clazzService.findByFk(gr, te);
			return MsgResponse.success("按要求查询成功！", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
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