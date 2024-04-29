package boardServer.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// UserDao 객체를 단일 인스턴스로 만들기 위해 
	// Singleton Pattern 적용 
	
	// 1. 생성자를 private으로 
	private UserDao() {
		setConnection();
	}
	
	// 2. 단일 인스턴스를 생성 (클래스 내부에서) 
	private static UserDao instance = new UserDao();
	
	// 3. 단일 인스턴스에 대한 getter 
	public static UserDao getInstance() {
		return instance;
	}
	
	private void setConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/board_server_db";		
			String user = "root";		
			String password = "root";		
			
			this.conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("[DB 연동 성공]");
		} catch (Exception e) {
			System.err.println("[DB 연동 실패]");
			e.printStackTrace();
		}
	}
	
	public List<UserResponseDto> findUserAll() {
		List<UserResponseDto> list = new ArrayList<UserResponseDto>();
		
		try {
			// 쿼리할 준비 
			String sql = "SELECT id, email, name, birth, gender, country, telecom, phone, agree FROM users";
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리 실행 
			rs = pstmt.executeQuery();
			
			// 튜플 읽기 
			while(rs.next()) {
				// database의 column index는 1부터 시작! 
				String id = rs.getString(1);
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String gender = rs.getString(5);
				String country = rs.getString(6);
				String telecom = rs.getString(7);
				String phone = rs.getString(8);
				boolean agree = rs.getBoolean(9);
				
				UserResponseDto user = new UserResponseDto(id, email, name, birth, gender, country, telecom, phone, agree);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public UserResponseDto createUser() {
		// sql 구문을 쿼리하고 
		// 실행한 결과 (ResultSet)을 가져와 
		// 성공을 했다면 -> UserResponseDto 객체 생성하여 
		// 반환 
		
		return null;
	}

}
