/**
 * 
 */
package com.myproject.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.myproject.dao.UserDao;
import com.myproject.entity.User;
import com.myproject.utils.EncryptUtils;

/**
 * @author feipt
 *
 */
public class UserRegisterService {
	Logger log = Logger.getLogger(UserRegisterService.class);
	
	@Autowired
	public UserDao userDao;
	
	/**
	 * 实现用户注册的功能。<br>
	 * @param request
	 * @return
	 */
	public boolean userRegister(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String encryptedPassword = null;
		//对密码进行加密保存
		if(password != null && !"".equals(password.trim())) {
			encryptedPassword = EncryptUtils.shaEncode(password);
		}
		User user = new User(userName, encryptedPassword, email);
		
		if(userDao != null) {
			return userDao.insert(user);
		}
		return false;
	}
}
