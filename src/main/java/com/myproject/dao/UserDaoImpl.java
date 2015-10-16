/**
 * 
 */
package com.myproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.myproject.entity.User;

/**
 * @author feipt
 *
 */
public class UserDaoImpl implements UserDao {
	
	private Logger log = Logger.getLogger(UserDaoImpl.class);
	
	@Autowired
	private JdbcTemplate template;
	
	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			return user;
		}
		
	}
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/* (non-Javadoc)
	 * @see com.myproject.dao.UserDao#getUserByName(java.lang.String)
	 */
	public User getUserByName(String name) {
		String selectSql = "select * from SYSTEM_USERS where id= ?";
		log.info("查询语句：" + selectSql);
		User user = this.template.queryForObject(selectSql, new Object[] {new Integer(1)}, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			
		});
		return user;
	}

	/* (non-Javadoc)
	 * @see com.myproject.dao.UserDao#insert(com.myproject.entity.User)
	 */
	public boolean insert(User user) {
		String insertSql = "insert into users(id, name, password) values(nextval for SEQ_USERS, ?, ?)";
		log.info("向表Users中新增一条数据，用户名:" + user.getName() + ", 执行语句：" + insertSql);
		int i = this.template.update(insertSql, user.getName(), user.getPassword());
		log.info("数据库操作结果：影响到的数据库表行数为" + i + "行");
		if(i == 1) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.myproject.dao.UserDao#updateUser(com.myproject.entity.User)
	 */
	public boolean updateUserPassword(User user) {
		String updateSql = "update users set password= " + user.getPassword().trim() + " where name= ?";
		log.info("更新数据库表中表Users中的一条记录，更新语句为：" + updateSql);
		int i = this.template.update(updateSql, user.getName());
		log.info("更新数据库表Users中的数据结果：影响了表Users中的"+ i + "行数据");
		return i == 1 ? true : false;
	}

	/* (non-Javadoc)
	 * @see com.myproject.dao.UserDao#deleteUser(com.myproject.entity.User)
	 */
	public boolean deleteUser(User user) {
		User selectedUserByName = null;
		String selectSql = "select * from SYSTEM_USERS where name= ?";
		List<User> list = this.template.query(selectSql, new Object[] {user.getName().trim()}, new UserMapper());
		int userId = 0;
		if(list.isEmpty()) {
			return false;
		} else {
			selectedUserByName = list.get(0);
			userId = selectedUserByName.getId();
			log.info("根据用户名查找到的用户ID为：" + userId);
		}
//		String deleteSql = "delete from users where name=?";
		String insertSql = "insert users_deleted(id, name, password) values(?, ?, ?)";
		int updateDeletedUserResult = this.template.update(insertSql, selectedUserByName.getId(), selectedUserByName.getName(), selectedUserByName.getPassword());
		log.info("向数据库表users_deleted中插入数据结果：影响了" + updateDeletedUserResult + "行数据");
		return false;
	}
	
	public int countUser() {
		this.template.toString();
		String sql = "select count(*) from SYSTEM_USERS";
		Integer result = this.template.queryForObject(sql, Integer.class);
		log.info("共有" + result + "用户");
		return result;
	}

}
