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
			// ����
			conn = DbUtil.getConnection();
			// �޲δ洢����
			// ��� CallableStatement
			CallableStatement cs = conn.prepareCall("call sp_get_all_users()");
			// ִ��
			cs.execute();
			// ������
			ResultSet resultSet = cs.getResultSet();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("name"));
			}

			// ��� �洢����
			// ��� CallableStatement
			CallableStatement cs1 = conn.prepareCall("call sp_get_user_by_id(?)");
			// �������
			cs1.setLong(1, 2);
			// ִ��
			cs1.execute();
			// ������
			ResultSet resultSet1 = cs1.getResultSet();
			while (resultSet1.next()) {
				System.out.println(resultSet1.getString("name"));
			}

			// ���δ洢����
			// ��� CallableStatement
			CallableStatement cs2 = conn.prepareCall("call sp_get_user_count(?)");
			// ע��������� ���������ͣ�
			cs2.registerOutParameter(1, java.sql.Types.INTEGER);
			// ִ��
			cs2.execute();
			// ������
			Integer count = cs2.getInt(1);
			System.out.println(count);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
