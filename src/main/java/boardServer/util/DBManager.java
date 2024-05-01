package boardServer.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource source = (DataSource) init.lookup("java:comp/env/jdbc/BoardServerDB");
			conn = source.getConnection();
			
			System.out.println("[DB 연동 성공]");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[DB 연동 실패]");
		}
		return conn;
	}

}
