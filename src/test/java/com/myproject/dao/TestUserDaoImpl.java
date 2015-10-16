/**
 * 
 */
package com.myproject.dao;

/**
 * @author feipt
 *
 */
public class TestUserDaoImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDaoImpl ud = new UserDaoImpl();
		System.out.println(ud.getUserByName("feipt"));
	}

}
