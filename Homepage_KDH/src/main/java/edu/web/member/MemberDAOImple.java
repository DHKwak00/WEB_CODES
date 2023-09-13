package edu.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class MemberDAOImple implements MemberDAO, DBConnectionQuery {
	// 싱글톤
	private static MemberDAOImple instance = null;

	private MemberDAOImple() {

	}

	public static MemberDAOImple getInstance() {
		if (instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}

	@Override
	public int insert(MemberVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getEmailAgree());
			pstmt.setString(5, vo.getInterestJoin());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getIntroduce());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}
	
	@Override
	public MemberVO select(String id) {
		MemberVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_SELECT);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String userid = rs.getString(1);
				String password = rs.getString(2);
				String email = rs.getString(3);
				String emailAgree = rs.getString(4);
				String[] interest = rs.getString(5).split(",");
				String phone = rs.getString(6);
				String introduce = rs.getString(7);
				
				vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
				System.out.println(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public int login(String id, String pw) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_LOGIN);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(pw)) {
					result = 1;
					System.out.println("로그인 성공 " + result);
				}else {
					result = 0;
					System.out.println("pw 불일치 " + result);
				}
			}else {
				result = -1;
				System.out.println("없는 id " + result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(String id, MemberVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString();
			pstmt.setString();
			
			result = pstmt.executeUpdate();
			System.out.println("회원 탈퇴 완료");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int delete(String id) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_DELETE);
			
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			System.out.println("회원 탈퇴 완료");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	

}
