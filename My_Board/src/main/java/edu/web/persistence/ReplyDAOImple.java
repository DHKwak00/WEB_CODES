package edu.web.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.web.dbcp.connmgr.ConnMgr;
import edu.web.domain.BoardVO;
import edu.web.domain.ReplyVO;

public class ReplyDAOImple implements ReplyDAO, ReplyQuery{
	// 싱글톤
		private static ReplyDAOImple instance = null;

		private ReplyDAOImple() {
		}

		public static ReplyDAOImple getInstance() {
			if (instance == null) {

				instance = new ReplyDAOImple();
			}
			return instance;
		}

	@Override
	public int insert(ReplyVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnMgr.getConnection();
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setInt(1, vo.getBoardId());
			pstmt.setString(2, vo.getMemberId());
			pstmt.setString(3, vo.getReplyContent());

			result = pstmt.executeUpdate();
			System.out.println("insert 성공");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt);
		}

		return result;
	}

	@Override
	public List<ReplyVO> select(int boardId) {
		List<ReplyVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnMgr.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_BY_BOARD_ID);
			pstmt.setInt(1, boardId);

			rs = pstmt.executeQuery();

			int replyId;
			
			String memberId;
			String replyContent;
			Date replyDateCreated;
			ReplyVO vo = null;

			while (rs.next()) {
				replyId = rs.getInt(COL_REPLY_ID);
//				boardId = rs.getInt(COL_BOARD_ID);
				memberId = rs.getString(COL_MEMBER_ID);
				replyContent = rs.getString(COL_REPLY_CONTENT);
				replyDateCreated = rs.getTimestamp(COL_REPLY_DATE_CREATED);
				vo = new ReplyVO(replyId, boardId, memberId, replyContent, replyDateCreated);
				list.add(vo);
			}
			System.out.println("select by board id 성공");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public int update(ReplyVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnMgr.getConnection();
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getReplyContent());
			pstmt.setInt(2, vo.getReplyId());

			result = pstmt.executeUpdate();
			System.out.println("update 성공");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt);
		}

		return result;
	}

	@Override
	public int delete(int replyId) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnMgr.getConnection();
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, replyId);

			result = pstmt.executeUpdate();
			System.out.println("delete 성공");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnMgr.close(conn, pstmt);
		}

		return result;
	}

}
