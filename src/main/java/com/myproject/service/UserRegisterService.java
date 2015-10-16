/**
 * 
 */
package com.myproject.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.myproject.dao.UserDao;

/**
 * @author feipt
 *
 */
public class UserRegisterService {
	
	@Autowired
	public UserDao userDao;
	
	public boolean userRegister(HttpServletRequest request) {
		return false;
	}
}
