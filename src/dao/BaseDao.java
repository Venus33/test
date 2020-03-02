package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDao {
	private static Connection conn;
	// 获得连接的方法
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/testgit?useUnicode=True&characterEncoding=UTF-8", 
					"root", "9999");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 释放资源的方法,先开后关
	public static void closeAll(ResultSet rs,PreparedStatement pst,Connection conn) {
		try {
			if(rs != null){
				rs.close();
			}
			if(pst != null){
				pst.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
