package edu.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.go")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String requestMethod = request.getMethod();
		System.out.println("호출 경로 : " + requestURI);
		System.out.println("호출 메소드 : " + requestMethod);

		if (requestURI.contains("login")) {
			System.out.println("login 호출");
			if (requestMethod.equals("GET")) {
				loginGET(request, response);
			} else if (requestMethod.equals("POST")) {
				loginPOST(request, response);
			}
		} else if (requestURI.contains("logout")) {
			System.out.println("logout 호출");
			logoutPOST(request, response);
		}
	}

	private void loginGET(HttpServletRequest request, HttpServletResponse response) // 페이지 불러오기
			throws ServletException, IOException {
		
		System.out.println("loginGET() 호출");
		request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
		// login.jsp로 이동

	}

	private void loginPOST(HttpServletRequest request, HttpServletResponse response) // 로그인 후
			throws ServletException, IOException {
		System.out.println("loginPOST 호출");
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		
		System.out.println("memberId : " + memberId);
		System.out.println("password : " + password);
		
		// * loginPOST를 수행하는 상황
		//  - index.jsp에 login 버튼 클릭 - 로그인 페이지 - 로그인 성공 - index.jsp 이동
		//  - 글 작성 버튼(register.do) 클릭 - 로그인 페이지 - 로그인 성공 - register.do 이동
		if(memberId.equals("test") && password.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberId);
			session.setMaxInactiveInterval(600);
			
			String targetURL = "index.jsp";
			
			Cookie[] cookies = request.getCookies();
			
			// targetURL 존재에 따른 경로 설정
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("targetURL")) {
						// targetURL이 있으면
						// index.jsp -> targetURL(register.do)로
						// 경로를 변경하고 targetURL 정보는 삭제
						targetURL = cookie.getValue();
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		
			response.sendRedirect(targetURL);
		}else {
			response.sendRedirect("login.go");
		}
	} // end loginPOST()

	private void logoutPOST(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("memberId") !=null) {
			session.removeAttribute("memberId");
			response.sendRedirect("index.jsp");
		}
		

	}

	

}
