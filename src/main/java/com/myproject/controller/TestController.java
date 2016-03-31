package com.myproject.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {
	private Logger logger = Logger.getLogger(TestController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	private String get() {
		logger.info("GET请求测试页面");
		return "test/test";
	}
}
