package com.fenix.db;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class procDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		// PreparedStatement ps = null;
		try {
			// 连接
			conn = DbUtil.getConnection();
			// 无参存储过程
			// 获得 CallableStatement
			CallableStatement cs = conn.prepareCall("call sp_get_all_users()");
			// 执行
			cs.execute();
			// 处理结果
			ResultSet resultSet = cs.getResultSet();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("name"));
			}

			// 入参 存储过程
			// 获得 CallableStatement
			CallableStatement cs1 = conn.prepareCall("call sp_get_user_by_id(?)");
			// 构造参数
			cs1.setLong(1, 2);
			// 执行
			cs1.execute();
			// 处理结果
			ResultSet resultSet1 = cs1.getResultSet();
			while (resultSet1.next()) {
				System.out.println(resultSet1.getString("name"));
			}

			// 出参存储过程
			// 获得 CallableStatement
			CallableStatement cs2 = conn.prepareCall("call sp_get_user_count(?)");
			// 注册输出参数 （数据类型）
			cs2.registerOutParameter(1, java.sql.Types.INTEGER);
			// 执行
			cs2.execute();
			// 处理结果
			Integer count = cs2.getInt(1);
			System.out.println(count);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
