/**
 * 
 */
package com.myproject.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.myproject.dao.UserDao;
import com.myproject.entity.User;
import com.myproject.utils.EncryptUtils;

/**
 * @author feipt
 *
 */
public class UserLoginService {
	Logger log = Logger.getLogger(UserLoginService.class);
	
	@Autowired
	private UserDao userDao;
	
	public boolean isUserLogin(HttpServletRequest request, String userName, String password) {
		password = EncryptUtils.shaEncode(password);
		User user = null;
		try {
			user = userDao.getUserByName(userName);
		} catch(EmptyResultDataAccessException e) {
			log.warn("登录用户名：" + userName + "，该用户不存在");
			request.setAttribute("javax.servlet.error.message", "用户不存在");
			return false;
		}
		if(user != null) {
			if(password.equals(user.getPassword())) {
				request.setAttribute("user", user);
				return true;
			} else {
				log.warn("用户密码不正确");
				request.setAttribute("javax.servlet.error.message", "用户登录密码不正确");
			}
		}
		return false;
	}
	
	public boolean doesUserExists(String userName) {
		User user = null;
		if(userDao != null) {
			user = userDao.getUserByName(userName);
			log.info("用户名为" + userName + "的用户" + (user == null ? "不存在" : "存在"));
		}
		return user == null ? false : true;
	}
}
