package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login_auth.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAOImple dao;

	public LoginServlet() {
		dao = MemberDAOImple.getInstance();
	}

	/*
	 * TODO : login.jsp에서 입력받은 아이디, 패스워드를 DB의 데이터와 비교해서 데이터가 일치하면 - 로그인 세션 생성 후
	 * 로그인 성공(login-result.jsp)로 이동 및 (아이디 값에 대한 세션 생성. 세션 만료 시간 60초) 데이터가
	 * 일치하지 않으면 - login.jsp로 이동(심심하면 실패 alert 띄우기)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 직접 접속 제한
		response.sendRedirect("/Homepage_KDH/login.jsp"); //"login.jsp" 도 됨
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pw = request.getParameter("password");

		int result = dao.login(id, pw);
		System.out.println(result);
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		if (result == 1) {
			session.setAttribute("userid", id); // 세션 생성
			session.setMaxInactiveInterval(60);
			response.sendRedirect("login-result.jsp");

		} else {
			out.print("<script>alert('로그인 실패');</script>");
			out.print("<script>location.href='login.jsp';</script>");
		}

	}

}
