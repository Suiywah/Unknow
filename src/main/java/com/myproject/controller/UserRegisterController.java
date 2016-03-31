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

import com.myproject.service.UserRegisterService;
import com.myproject.utils.UserLoginUtils;

/**
 * @author feipt
 *
 */
@Controller
@RequestMapping("/register")
public class UserRegisterController {
	@Autowired
	private UserRegisterService userRegisterService;
	
	private Logger log = Logger.getLogger(UserRegisterController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		log.info("用户请求注册");
		return "register";
	}
	
	@RequestMapping(value="/email", method=RequestMethod.POST)
	public String post(HttpServletRequest request) {
		boolean flag = false;
		log.info("用户注册register");
		String name = request.getParameter("userName");
		log.info("用户注册使用IP地址：" + UserLoginUtils.getIpAddr(request));
		log.info("用户注册名：" + name);
		if(userRegisterService != null) {
			flag = userRegisterService.userRegister(request);
		} else {
			log.error("UserRegisterService未被实例化");
		}
		if(flag) {
			//如果注册成功，应该给注册邮箱发送邮件
			return "loginSuccess";
		} else {
			return "error";
		}
	}
}
