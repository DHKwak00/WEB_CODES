package edu.web.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.board.domain.BoardVO;
import edu.web.board.persistence.BoardDAO;
import edu.web.board.persistence.BoardDAOImple;

@WebServlet("*.do") // *.do : ~.do로 선언된 HTTP 호출에 전부 반응
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BOARD_URL = "WEB-INF/board/";
	private static final String MAIN = "index";
	private static final String LIST = "list";
	private static final String REGISTER = "register";
	private static final String DETAIL = "detail";
	private static final String UPDATE = "update";
	private static final String DELETE = "delete";
	private static final String EXTENSION = ".jsp";
	private static final String SERVER_EXTENSION = ".do";

	private static BoardDAO dao;

	public BoardController() {
		dao = BoardDAOImple.getInstance();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		controlURI(request, response);

	}

	private void controlURI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String requestMethod = request.getMethod();
		System.out.println("호출 경로 : " + requestURI);
		System.out.println("호출 방식 : " + requestMethod);

		if (requestURI.contains(LIST + SERVER_EXTENSION)) {
			System.out.println("List 호출 확인");
//			if(requestMethod.equals("GET")) {} 요청 방식 확인
			list(request, response);
		} else if (requestURI.contains(REGISTER + SERVER_EXTENSION)) {
			System.out.println("Regster 호출 확인");
			if (requestMethod.equals("GET")) { // **GET 방식(페이지 불러오기) 그냥 jsp로 보내냐 or 데이터도 같이 보내냐
				registerGET(request, response);
			} else if (requestMethod.equals("POST")) { // **POST 방식(DB에 저장)
				registerPOST(request, response);
			}
		} else if (requestURI.contains(DETAIL + SERVER_EXTENSION)) {
			System.out.println("Detail 호출 확인");
			detail(request, response);
		}else if(requestURI.contains(UPDATE + SERVER_EXTENSION)){
			System.out.println("Update 호출 확인"); // get- / post - 수정
			if(requestMethod.equals("GET")) {
				updateGET(request, response);
			}else if (requestMethod.equals("POST")) {
				updatePOST(request, response);
			}
		}else if(requestURI.contains(DELETE + SERVER_EXTENSION)){
			System.out.println("delete 호출 확인");
			if(requestMethod.equals("POST")) {
				deletePOST(request, response);
			}
		}

	} // end controlURI()


	

	// 전체 게시판 내용(list)을 DB에서 가져오고, 그 데이터를 list.jsp 페이지에 보내기
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO> list = dao.select();

		String path = BOARD_URL + LIST + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);

		request.setAttribute("list", list);
		dispatcher.forward(request, response); // list.jsp로 url이 덮어씌워짐
	} // end list()

	// register.jsp 페이지 호출
	private void registerGET(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = BOARD_URL + REGISTER + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);

		dispatcher.forward(request, response);

	} // end registerGET()

	private void registerPOST(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String boardTitle = request.getParameter("boardTitle");
		String memberId = request.getParameter("memberId");
		String boardContent = request.getParameter("boardContent");
		BoardVO vo = new BoardVO(0, boardTitle, boardContent, memberId, null);
		System.out.println(vo);

		int result = dao.insert(vo);
		System.out.println("결과 : " + result);

		if (result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('게시글 등록 성공');</script>");
			out.print("<script>location.href='" + MAIN + EXTENSION + "';</script>");
		}

	} // end registerPOST()

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		BoardVO vo = dao.select(boardId);
		System.out.println(vo);

		String path = BOARD_URL + DETAIL + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		request.setAttribute("vo", vo);
		dispatcher.forward(request, response);
		
	} // end detail()
	
	private void updateGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		BoardVO vo = dao.select(boardId);
		
		String path = BOARD_URL + UPDATE + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		request.setAttribute("vo", vo);
		dispatcher.forward(request, response);
		
	} // end updateGET()
	
	private void updatePOST(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		BoardVO vo = new BoardVO(boardId, boardTitle, boardContent, null, null);
		int result = dao.update(vo);
		System.out.println(vo);
		
		if(result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('게시글 수정 성공');</script>");
			out.print("<script>location.href='" + DETAIL + SERVER_EXTENSION + "?boardId=" + boardId + "';</script>");
		}
	}// end updatePOST()
	
	private void deletePOST(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		int result = dao.delete(boardId);
		
		if(result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('게시글 삭제 성공');</script>");
			out.print("<script>location.href='" + MAIN + EXTENSION + "';</script>");
		}
		
	}// end deletePOST()

}// end BoardController
