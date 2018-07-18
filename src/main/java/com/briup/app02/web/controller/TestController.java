package com.briup.app02.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "测试接口")
@RestController
@RequestMapping("/test")
public class TestController {
	/**
	 * 浏览器发送请求--> 服务接收请求--> 服务器返回响应-->浏览器接收回应
	 * http协议
	 * */
	@ApiOperation(value = "打印出hello world")
	@GetMapping("hello")
	public String hello(){
		return "hello  world";
	}
}
