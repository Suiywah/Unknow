/**
 * 
 */
package com.myproject.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

import com.myproject.entity.PeopleInfo;

/**
 * @author feipt
 *
 */
public class AdminDaoImpl implements AdminDao {
	private Logger log = Logger.getLogger(AdminDao.class);
	
	@Autowired
	private JdbcTemplate template;

	/* (non-Javadoc)
	 * @see com.myproject.dao.AdminDao#peopleInfoInsert(com.myproject.entity.PeopleInfo)
	 */
	@Override
	public boolean peopleInfoInsert(PeopleInfo pi) {
		if(pi == null) {
			log.error("保存对象为null,保存失败。");
			return false;
		}
		java.util.List<Object> params = new ArrayList<Object>();
		params.add(pi.getId());
		params.add(pi.getName());
		params.add(pi.getAddress());
		params.add(pi.getGender());
		params.add(pi.getBeginDate());
		params.add(pi.getEndDate());
		params.add(pi.getBorn());
		String insertSql = "insert into PEOPLE_INFO(ID, ID_NO, NAME, ADDRESS, GENDER, USE_LIFE_BEGIN, USER_LIFE_END, BORN)"
				+ "VALUES(SEQ_PEOPLE_INFO.NEXTVAL, ?,?,?,?,?,?,?)";
		
		PreparedStatementCreator pstcf = new PreparedStatementCreatorFactory(insertSql).newPreparedStatementCreator(params);
		template.execute(pstcf, null);
		return true;
	}

}
