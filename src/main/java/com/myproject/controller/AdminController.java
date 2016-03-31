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

import com.myproject.entity.PeopleInfo;
import com.myproject.service.AdminService;

/**
 * @author feipt
 *
 */
@RequestMapping("/admin")
@Controller
public class AdminController {
	private Logger log = Logger.getLogger(AdminController.class);
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		return "admin";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String post(HttpServletRequest request) {
		log.info("用户提交, 姓名：" + request.getParameter("name"));
		PeopleInfo pi = new PeopleInfo();
		pi.setName(request.getParameter("name"));
		pi.setId(request.getParameter("id"));
		pi.setAddress(request.getParameter("address"));
		pi.setGender(request.getParameter("gender"));
		pi.setBeginDate(request.getParameter("begin"));
		pi.setEndDate(request.getParameter("end"));
//		pi.setBorn(request.getParameter("born"));
		adminService.peopleInfoSave(pi);
		return "";
	}
}
