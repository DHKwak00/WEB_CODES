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
	List<BoardVO> select(PageCriteria criteria); // 페이징 criteria 자체를 라이브러리라고 생각
	int getTotalCounts();
}
