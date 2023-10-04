package edu.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.domain.BoardVO;
import edu.web.persistence.BoardDAO;
import edu.web.persistence.BoardDAOImple;
import edu.web.util.PageCriteria;
import edu.web.util.PageMaker;

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
			list(request, response); // get이네
		} else if (requestURI.contains(REGISTER + SERVER_EXTENSION)) {
			System.out.println("Regster 호출 확인");
			if (requestMethod.equals("GET")) { // **GET 방식(페이지 불러오기) 그냥 jsp로 보내냐 or 데이터도 같이 보내냐
				registerGET(request, response);
			} else if (requestMethod.equals("POST")) { // **POST 방식(DB에 저장) 등록버튼 누르네
				registerPOST(request, response);
			}
		} else if (requestURI.contains(DETAIL + SERVER_EXTENSION)) {
			System.out.println("Detail 호출 확인");
//			detail(request, response); // get이네
		} else if (requestURI.contains(UPDATE + SERVER_EXTENSION)) {
			System.out.println("Update 호출 확인"); // get- / post - 수정
			if (requestMethod.equals("GET")) {
//				updateGET(request, response);
			} else if (requestMethod.equals("POST")) {
//				updatePOST(request, response);
			}
		} else if (requestURI.contains(DELETE + SERVER_EXTENSION)) {
			System.out.println("delete 호출 확인");
			if (requestMethod.equals("POST")) {
//				deletePOST(request, response);
			}
		}

	} // end controlURI()
	
	// 전체 게시판 내용(list)을 DB에서 가져오고, 그 데이터를 list.jsp 페이지에 보내기
		private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			List<BoardVO> list = dao.select();
//			String path = BOARD_URL + LIST + EXTENSION;
//			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//
//			request.setAttribute("list", list);
//			dispatcher.forward(request, response); // list.jsp로 url이 덮어씌워짐 여기가 페이징 처리 전 코드
			
			String page = request.getParameter("page");

			PageCriteria criteria = new PageCriteria();
			if (page != null) { // 첫 접속엔 필요 없고 페이지를 눌러야 의미가 있으니까 페이지 Criteria에 이미 디폴트로 1이 설정되있음
				criteria.setPage(Integer.parseInt(page));
			}

			List<BoardVO> list = dao.select(criteria);

			String path = BOARD_URL + LIST + EXTENSION;
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);

			request.setAttribute("list", list); // 여기까지 하고 pageMaker 했음 (연관 없음)
//			dispatcher.forward(request, response); // list.jsp로 url이 덮어씌워짐

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCriteria(criteria);
			// 현재 페이지 번호 및 페이지 당 게시글 개수 정보 저장
			int totalCount = dao.getTotalCounts(); // 전체 계시글 수
			pageMaker.setTotalCount(totalCount);
			pageMaker.setPageData(); // 저장된 데이터를 바탕으로 page 링크 데이터 생성

			System.out.println("전체 게시글 수 : " + pageMaker.getTotalCount());
			System.out.println("현재 선택된 페이지 : " + criteria.getPage());
			System.out.println("한 페이지 당 게시글 수 : " + criteria.getNumsPerPage());
			System.out.println("페이지 링크 번호 개수 : " + pageMaker.getNumsOfPageLinks());
			System.out.println("시작 페이지 링크 번호 : " + pageMaker.getStartPageNo());
			System.out.println("끝 페이지 링크 번호 : " + pageMaker.getEndPageNo());
			System.out.println("이전 버튼 존재 유무 : " + pageMaker.isHasPrev());
			System.out.println("다음 버튼 존재 유루 : " + pageMaker.isHasNext());

			request.setAttribute("pageMaker", pageMaker);
			dispatcher.forward(request, response);

		} // end list()

		// register.jsp 페이지 호출
		private void registerGET(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			// 로그인 세션 체크 (나중에 공부)
			HttpSession session = request.getSession();
			System.out.println(session);
			
			String memberId = (String) session.getAttribute("memberId");
			
			if(memberId != null) { // memberId 세션이 존재(로그인 상태)
				String path = BOARD_URL + REGISTER + EXTENSION;
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
					
				dispatcher.forward(request, response);
			}else { // memberId 세션이 존재하지 않음(로그아웃 상태)
				// 쿠키에 targetURL 정보를 저장
				// targetURL = register.do
				Cookie urlCookie = new Cookie("targetURL", REGISTER + SERVER_EXTENSION);
				response.addCookie(urlCookie);
				// 페이지 이동 전에 로그인을 먼저 하러 간다
				response.sendRedirect("login.go");
			}
			

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
}
