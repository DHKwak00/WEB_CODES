package edu.web.servlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginTest")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CLASSNAME = 
    		LoginServlet.class.getName();
    
    public LoginServlet() {
        
    }

	// doGet() : form method = "GET" 방식으로 전송할 경우 doGet()으로 수신
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " : doGet() 호출");
		login(request, response);
	}
	
	// doPost() : form method = "POST" 방식으로 전송할 경우 doPost()로 수신
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " : doPost() 호출");
		login(request, response);
	}
	
	// 택배차량의 역할
	// HttpServletRequest : 요청한 HTTP의 객체(ip 주소, 파라미터 등)를 저장하는 클래스
	// HttpServletResponse : HTTP 요청에 대응하는(보내는) 정보를 저장하는 클래스
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 브라우저에서 받은 데이터를 꺼내는 방식
		String ip = request.getRemoteAddr(); // 요청한 HTTP의 IP 주소를 가져옴
		System.out.println("[" + ip + "]");
		
		// * request url 정보
		// ㄴ GET 방식에서 요청 파라미터는 URL 줏의 query String에 포함되어 있음
		// ㄴ http://localhost:8080/loginTest?userid=test&password=1234
		// ㄴ 브라우저 -> F12(개발자 툴) -> Network 탭 -> 요청 정보 확인
		// - http : 통신 규약(프로토콜)
		// - localhost ; 호스트 이름(도메인 이름)
		// - 8080 : 포트 번호
		// - Web06_Servlet : context root(서버에서 파일을 찾아갈 최초의 경로
		// - loginTest : servlet 경로(urlPatterns)
		// - ?userid=test&password=1234 : query string 
		
		// 요청 파라미터(request parameter)의 값을 읽어옴
		String userid = request.getParameter("userid"); // 변수명, 파라미터, html 폼의 name의 이름 같게
		String password = request.getParameter("password"); // 파라미터로 넘겨 받는 (키벨류 방식)
		
		System.out.println("아이디 : " + userid);
		System.out.println("비밀번호 : " + password);
		
		// 새로운 페이지를 생성하는 방식
		response.setCharacterEncoding("UTF-8");
		// PrintWriter 클래스
		// - HTML 페이지를 생성해주는 클래스
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE HTML>")
			.append("<header><meta charset='utf-8'></head>")
			.append("<body>")
			.append("<h1>로그인 결과 페이지</h1>")
			.append("아이디 : " + userid + "<br>")
			.append("비밀번호 : " + password + "<br>")
			.append("</body>")
			.append("</html>");
		
	}
}
