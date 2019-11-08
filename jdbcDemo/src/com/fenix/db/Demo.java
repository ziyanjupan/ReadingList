package com.fenix.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;

public class Demo {
	// ?characterEncoding=utf8&serverTimezone=GMT%2B8
	private static final String URL = "jdbc:mysql://localhost:3306/fenix?serverTimezone=GMT";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1.加载驱动
//			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.建立连接
//			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn=DbUtil.getConnection();
			// 3.查询得到结果
			
			// 两种查询方式 Statement和PreparedStatement
			
			// Statement 使用字符串拼接
			// Statement statement = conn.createStatement();
			// ResultSet resultSet = statement.executeQuery("select * from user
			// where id=1");
			
			// prepareStatement方式
			ps = conn.prepareStatement("select * from user where id=?");
			ps.setLong(1, 1);
			ResultSet resultSet = ps.executeQuery();
			// 4.展示结果
			while (resultSet.next()) {
				System.out.println("姓名:" + resultSet.getString("name") + "id:" + resultSet.getLong("id") + "创建时间:"
						+ resultSet.getDate("createtime"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("查询出错");
		} finally {
			// 5.释放资源
			try {
				if (ps!=null) {
					ps.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				if (conn!=null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}
}
