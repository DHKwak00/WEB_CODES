package edu.web.homework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 여기서 실행(시작)
@WebServlet("/SendListServlet")
public class SendListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME = 
			SendListServlet.class.getName();   
    
    public SendListServlet() {
        
    }

    // <과제2>
    // * BoardVO 생성
    // : boardId(int), boardTitle(String), userId(String), boardRegDate(Date)
    
    // * SendListServlet.java - doGet()
    // ArrayList<BoardVO> 생성
    // - 게시글 데이터 5정개 정도 add
    // - forward 방식으로 HW2.jsp 파일에 list 데이터 전송
    
    // *HW2.jsp (dispatcher 경로 주의)
    // - SendListServlet.java에서 전송된 list 데이터 저장
    // - 저장된 list 데이터 테이블 형태로 출력
    
    // * BoardVO SendListServlet.java, HW2.jsp 파일
    // [본인 이름_HW2].zip으로 압축해서 제출
    // - 경로 : 과제폴더\Web Class\JSP-Servlet\HW2
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " : doGet() 호출");
		
		Date now = new Date();
		BoardVO vo0 = new BoardVO(0, "가입인사요", "1111", now);
		BoardVO vo1 = new BoardVO(1, "하이요", "2222", now);
		BoardVO vo2 = new BoardVO(2, "이거 대박", "3333", now);
		BoardVO vo3 = new BoardVO(3, "오늘 저녁 추천 좀", "4444", now);
		BoardVO vo4 = new BoardVO(4, "오늘 하루 끝", "5555", now);
		
		ArrayList<BoardVO> list = new ArrayList<>();
		list.add(vo0);
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		
		request.setAttribute("list", list);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/homework/HW2.jsp");
		dispatcher.forward(request, response);
		// HW2.jsp 로 ㄱㄱ
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
