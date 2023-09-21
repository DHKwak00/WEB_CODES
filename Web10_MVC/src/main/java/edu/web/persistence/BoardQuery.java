package edu.web.persistence;

public interface BoardQuery {
	public static final String TABLE_NAME = "BOARD";
	public static final String COL_BOARD_ID = "BOARD_ID";
	public static final String COL_BOARD_TITLE = "BOARD_TITLE";
	public static final String COL_BOARD_CONTENT = "BOARD_CONTENT";
	public static final String COL_MEMBER_ID = "MEMBER_ID";
	public static final String COL_BOARD_DATE_CREATED = "BOARD_DATE_CREATED";
	
	// 새 글 작성
	// INSERT INTO BOARD
	// VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE);
	public static final String SQL_INSERT = 
			"INSERT INTO " + TABLE_NAME + " VALUES "
			+ "(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
	
	// 전체 게시글 선택
	// SELECT * FROM BOARD ORDER BY BOARD_ID DESC;
	public static final String SQL_SELECT_ALL = 
			"SELECT * FROM " + TABLE_NAME +
			" ORDER BY " + COL_BOARD_ID + " DESC";
	
	// 특정 게시글 선택
	// SELECT * FROM BOARD WHERE BOARD_ID = ?;
	public static final String SQL_SELECT_BY_BOARD_ID = 
			"SELECT * FROM " + TABLE_NAME + " WHERE "
			+ COL_BOARD_ID + " = ?";
	
	// 특정 게시글 수정
	// UPDATE BOARD SET 
	// BOARD_TITLE = ?, BOARD_CONTENT = ?, BOARD_DATE_CREATED = SYSDATE
	// WHERE BOARD_ID = ?
	public static final String SQL_UPDATE =
			"UPDATE " + TABLE_NAME + " SET "
			+ COL_BOARD_TITLE + " = ?, "
			+ COL_BOARD_CONTENT + " = ?, "
			+ COL_BOARD_DATE_CREATED + " = SYSDATE "
			+ " WHERE " + COL_BOARD_ID + " = ?";
	
	// 특정 게시글 삭제
	// DELETE BOARD WHERE BOARD_ID = ?
	public static final String SQL_DELETE =
			"DELETE " + TABLE_NAME + 
			" WHERE " + COL_BOARD_ID + " = ?";
	
	// 게시글 페이징 처리 (검색)
//	SELECT BOARD_ID, BOARD_TITLE, BOARD_CONTENT, MEMBER_ID, BOARD_DATE_CREATED 
//	FROM(
//	    SELECT ROWNUM RN, A.* FROM(
//	        SELECT * FROM BOARD ORDER BY BOARD_ID DESC
//	    )A
//	) WHERE RN BETWEEN 1 AND 5;
	
	public static final String SQL_SELECT_PAGESCOPE = 
			"SELECT " + COL_BOARD_ID + ", " + COL_BOARD_TITLE + ", " + COL_BOARD_CONTENT + ", " + COL_MEMBER_ID + ", " + COL_BOARD_DATE_CREATED 
			+ " FROM ("
			+ " SELECT ROWNUM RN, A.* FROM(" 
			+ " SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_BOARD_ID + " DESC " 
			+ ")A " 
			+ ") WHERE RN BETWEEN ? AND ?";
	
	// 전체 게시물 몇 개인지 카운팅
	// SELECT COUNT(BOARD_ID) TOTAL_CNT FROM BOARD;
	public static final String SQL_TOTAL_CNT =
			"SELECT COUNT(" + COL_BOARD_ID + ") TOTAL_CNT FROM " + TABLE_NAME;
}





