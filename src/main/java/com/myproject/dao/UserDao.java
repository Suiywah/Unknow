/**
 * 
 */
package com.myproject.dao;

import com.myproject.entity.User;

/**
 * @author feipt
 *
 */
public interface UserDao {

	/**
	 * 根据用户名，从数据库中查找出该用户的信息
	 * @param name 查找对象，用户名
	 * @return 用户全部信息，方式为一个JavaBean对象
	 */
	public User getUserByName(String name);
	
	/**
	 * 向用户表中插入一条用户数据
	 * @param user 新用户的数据。其中包含了用户名和用户密码。
	 * @return 如果数据库操作返回的影响数据库表行数为1，则返回{@code true}，其他情况返回{@code false}.
	 */
	public boolean insert(User user);
	
	/**
	 * 更新用户表中的一个用户信息
	 * @param user 新的用户信息
	 * @return 更新信息，如果更新成功，则返回{@code true}
	 */
	public boolean updateUserPassword(User user);
	
	/**
	 * 从当前的用户表中删除一条用户数据。<br/>
	 * 实际上，从当前用户表删除一个用户，首先是将用户移动到已删除用户表中，然后再从当前用户表中删除该条数据。
	 * @param user 删除目标用户数据
	 * @return
	 */
	public boolean deleteUser(User user);
	
	public int countUser();
}
