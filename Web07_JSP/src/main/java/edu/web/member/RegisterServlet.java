package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberDAO dao;   
    
    public RegisterServlet() {
        dao = MemberDAOImple.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// url로 접근할 경우 경로 변경
		response.sendRedirect("/Web07_JSP/18_db_connection.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form과 매칭해가며 쓰기
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		
		MemberVO vo = new MemberVO(userId, password, email, emailAgree, interest, phone, introduce);
		System.out.println(vo);
		int result = dao.insert(vo);
		System.out.println(result);
		
		// DB 저장에 성공하면 다른 페이지에 데이터 전송
		if(result == 1) { // insert는 필요 없음 여기는 select hint!
			RequestDispatcher dispatcher = request.getRequestDispatcher("18_db_result.jsp");
			request.setAttribute("vo", vo); // vo 보내기
			dispatcher.forward(request, response); // -> jsp에서 출력 ㄱㄱ
			
//			// 세션으로 클라이언트에 특정 데이터 전송(참고용)
//			HttpSession session = request.getSession();
//			session.setAttribute("userid", vo.getUserid());
//			session.setMaxInactiveInterval(60);
//			response.sendRedirect("18_db_result.jsp");
		}
	}

}
