package kh.my.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTemplate {

	public JdbcTemplate() {
	}

	public static Connection getConnection() {
		Connection conn = null;
		String dr = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";  //TODO: 설명
		String uid = "scott";
		String pwd = "1234";
		
		try {
			Class.forName(dr);
			conn = DriverManager.getConnection(url, uid, pwd);
			if(conn!=null) System.out.println("연결성공");
			else System.out.println("연결실패!!!!!!!!!!!!!");
		}catch(Exception e) {
			System.out.println("연결실패!!!!!!!!!!!!!");
			e.printStackTrace();
		}
//		setAutoCommit(conn, false);
		
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement s) {
		try {
			s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//	public static void close(PreparedStatement s) {
//		try {
//			s.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	public static void close(ResultSet s) {
		try {
			if(s!=null) s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void setAutoCommit(Connection conn, boolean onOff) {
		try {
			conn.setAutoCommit(onOff);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
