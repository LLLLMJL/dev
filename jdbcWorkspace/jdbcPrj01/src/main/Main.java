package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("JDBC 프로젝트");
		
		// 연결정보 준비
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";  //@ip주소:port주소:db name
		String username = "C##KH";
		String pwd = "1234";
		
		// DB 연결해서 Connection 얻기
		Connection conn = DriverManager.getConnection(url, username, pwd);
		
		// 쿼리문 실행 및 결과받기
		Statement stmt = conn.createStatement();
		
		String sql = "INSERT INTO MEMBER(ID, PWD) VALUES ('JAVA', '7777')"; 
		int result = stmt.executeUpdate(sql);
		
		System.out.println("result: " + result);
		
		
	}//main

}//class
