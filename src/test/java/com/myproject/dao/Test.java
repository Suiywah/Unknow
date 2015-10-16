package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;


public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		dataSource.setUsername("scott");
		dataSource.setPassword("123456");
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott","123456");
		try {
			String sql = "select count(*) from SYSTEM_USERS";
			Connection con = dataSource.getConnection();
			System.out.println(con.toString());
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			if(rst.next()) {
				int i = rst.getInt(1);
				System.out.println(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}