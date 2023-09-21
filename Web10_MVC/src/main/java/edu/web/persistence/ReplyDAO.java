package edu.web.persistence;

import java.util.List;

import edu.web.domain.ReplyVO;

public interface ReplyDAO {
	// insert, select, update, delete
	int insert(ReplyVO vo);
	List<ReplyVO> select();
	int update(ReplyVO vo);
	int delete(int replyId);
}
