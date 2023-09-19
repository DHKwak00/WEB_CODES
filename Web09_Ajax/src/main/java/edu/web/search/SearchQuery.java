package edu.web.search;

public interface SearchQuery {
	// DB 접속에 필요한 상수 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	// DB 테이블 상수 정의
	public static final String TABLE_NAME = "SEARCH";
	public static final String COL_SNO = "SNO";
	public static final String COL_TITLE = "TITLE";
	
	// Query문
	// SELECT * FROM SEARCH WHERE TITLE LIKE ?
	public static final String SQL_SEARCH = 
			"SELECT " + COL_TITLE + " FROM " + TABLE_NAME + " WHERE " + COL_TITLE + " LIKE ?";
}
