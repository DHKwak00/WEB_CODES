package edu.web.search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class SearchDAOImple implements SearchDAO, SearchQuery{
	
	private static SearchDAOImple instance = null;
	
	private SearchDAOImple() {
		
	}
	
	static SearchDAOImple getInstance() {
		if(instance == null) {
			instance = new SearchDAOImple();
		}
		return instance;
	}
	
	@Override
	public ArrayList<SearchVO> select(String title) {
		ArrayList<SearchVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_SEARCH);
			
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String txt = rs.getString(1);
				SearchVO vo = new SearchVO(txt);
				System.out.println(txt);
				list.add(vo);
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
		
		
		return list;
	}

}
