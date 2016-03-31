/**
 * 
 */
package com.myproject.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.myproject.dao.AdminDao;
import com.myproject.entity.PeopleInfo;

/**
 * @author feipt
 *
 */
public class AdminService {
	private Logger log = Logger.getLogger(AdminService.class);
	@Autowired
	private AdminDao adminDao;
	
	public boolean peopleInfoSave(PeopleInfo pi) {
		log.info("将用户信息存入数据库");
		if (pi == null) {
			return false;
		}
		return adminDao.peopleInfoInsert(pi);
	}
}
