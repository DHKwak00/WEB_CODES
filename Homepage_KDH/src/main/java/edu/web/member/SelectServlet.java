package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// TODO : login-result.jsp에서 이동
// session에서 userid 값을 가져와서 DB 회원 정보 select
// doGet() 메소드에서 수행
// select된 VO 데이터를 member-result.jsp로 전송
@WebServlet("/select.do")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberDAOImple dao;
    
    public SelectServlet() {
        dao = MemberDAOImple.getInstance();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		MemberVO vo =  dao.select(userid);
		System.out.println(vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member-result.jsp");
		request.setAttribute("vo", vo);
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
