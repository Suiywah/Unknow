/**
 * 
 */
package com.myproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.service.UserLoginService;
import com.myproject.utils.UserLoginUtils;

/**
 * @author feipt
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserLoginService userLoginService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam String userName, @RequestParam String password, HttpServletRequest request) {
		logger.info("登录Post请求");
		logger.info("用户登录：姓名：" + userName + ", 用户密码：" + password);
		//登录密码进行加密处理
		if(userLoginService != null) {
			if(userLoginService.isUserLogin(request, userName, password)) {
//				request.get
				logger.info("用户" + userName + "登录，地址为：" + UserLoginUtils.getIpAddr(request));
				return "index";
			}
		} else {
			logger.error("userLoginService不存在");
		}
		logger.info("request:" + request.getProtocol());
		return "error";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("登录GET请求");
		return "login";
	}
	
	@RequestMapping(value="/prelogin", method=RequestMethod.GET)
	@ResponseBody
	public String preLogin(@RequestParam(value="user") String userName,  HttpServletRequest request) {
		logger.info("request: " + request.getRequestURI());
		logger.info("登录用户名：" + userName);
		boolean exitFlag = userLoginService.doesUserExists(userName);
		if(exitFlag) {
			return "{\"exist\": \"true\"}";
		} else {
			return "{\"exist\": \"false\"}";
		}
	}
}
