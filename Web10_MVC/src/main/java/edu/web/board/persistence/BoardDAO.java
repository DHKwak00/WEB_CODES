package edu.web.board.persistence;

import java.util.List;

import edu.web.board.domain.BoardVO;

public interface BoardDAO {
	int insert(BoardVO vo);
	List<BoardVO> select();
	BoardVO select(int boardId);
	int update(BoardVO vo);
	int delete(int boardId);
}
