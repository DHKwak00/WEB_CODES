package edu.web.persistence;

import java.util.List;

import edu.web.domain.BoardVO;
import edu.web.util.PageCriteria;

public interface BoardDAO {
	int insert(BoardVO vo);
	List<BoardVO> select();
	BoardVO select(int boardId);
	int update(BoardVO vo);
	int delete(int boardId);
	List<BoardVO> select(PageCriteria criteria);
	int getTotalCounts();
}
