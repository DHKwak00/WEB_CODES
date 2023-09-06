package edu.web.servlet04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forward")
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CLASSNAME =
    		ForwardTestServlet.class.getName();
    
    public ForwardTestServlet() {
    	
    }
        

	// forward : URL 주소 유지. request/response 객체 유지
    // - 같은 웹 서버 내에 있는 파일들로만 이동이 가능
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 존재하는 JSP 페이지에 데이터를 보내는 방식
		// info.html -> ForwardTestServlet.java(/forward) -> result.jsp
		
		// forward 방식에서 페이지를 이동할 때는 RequestDispatcher 인터페이스의 forward(request, response) 메소드를 사용
		// URL이 변경되지 않고 이동함
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/result.jsp"); // "/result.jsp" 로 바로 전달
		
		// request 객체를 JSP로 전달
		dispatcher.forward(request, response); // request = 자바 
		// result.jsp에 request 객체를 전달하고
		// 전달받는 request에서 parameter를 꺼내는 방식
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
