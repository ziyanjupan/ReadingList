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
			// 1.��������
//			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.��������
//			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn=DbUtil.getConnection();
			// 3.��ѯ�õ����
			
			// ���ֲ�ѯ��ʽ Statement��PreparedStatement
			
			// Statement ʹ���ַ���ƴ��
			// Statement statement = conn.createStatement();
			// ResultSet resultSet = statement.executeQuery("select * from user
			// where id=1");
			
			// prepareStatement��ʽ
			ps = conn.prepareStatement("select * from user where id=?");
			ps.setLong(1, 1);
			ResultSet resultSet = ps.executeQuery();
			// 4.չʾ���
			while (resultSet.next()) {
				System.out.println("����:" + resultSet.getString("name") + "id:" + resultSet.getLong("id") + "����ʱ��:"
						+ resultSet.getDate("createtime"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("��ѯ����");
		} finally {
			// 5.�ͷ���Դ
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
