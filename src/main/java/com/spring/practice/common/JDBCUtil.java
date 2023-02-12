package com.spring.practice.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	
	public static Connection getConnection() {
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url,"C##HR","1234");
			System.out.println("연결성공");
			return conn;
		}catch(Exception e) {
			System.out.println("연결실패");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection conn , PreparedStatement pstmt) {
		if(conn!=null) {
			try {
				conn.close();
				conn=null;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
				pstmt=null;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void close(ResultSet rs,Connection conn , PreparedStatement pstmt) {
		if(rs!=null) {
			try {
				rs.close();
				rs=null;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
				conn=null;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
				pstmt=null;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
