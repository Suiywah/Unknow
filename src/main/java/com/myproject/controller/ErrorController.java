/**
 * 
 */
package com.myproject.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author feipt
 *
 */
@Controller
public class ErrorController {
	private Logger logger = Logger.getLogger(ErrorController.class);
	
	@RequestMapping(value="/error", produces="application/json")
	@ResponseBody
	public String handle(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", request.getAttribute("javax.servlet.error.status_code"));
		map.put("reason", request.getAttribute("javax.servlet.error.message"));
		logger.error("访问请求发生错误，代码：" + request.getAttribute("javax.servlet.error.status_code") + ", 消息：" + request.getAttribute("javax.servlet.error.message"));
		return "error";
	}
}
