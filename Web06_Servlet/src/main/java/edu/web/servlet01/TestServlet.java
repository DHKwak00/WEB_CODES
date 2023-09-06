package edu.web.servlet01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// * 서블릿(servlet)
// - 자바를  이용하여 웹 페이지를 동적으로 생성하는 server-side 프로그램
// - 웹 서버의 성능을 향상하기 위해 사용되는 자바 클래스의 일종
// - 서블릿은 자바 코드 안에 HTML을 포함
// - JSP는 HTML 문서 안에서 자바 코드를 포함
// - JSP는 최종적으로 서블릿 형태로 실행됨(컴파일러가 서블릿으로 읽음)

// * 서블릿의 서버 경로 사용 방법
// 1. Annotation 방식 : Servlet 3.0 버전 이후부터 적용
// @WebServlet(urlPatterns = {})
@WebServlet(urlPatterns = {"/test", "/hello"}, loadOnStartup = 2) // 클래스의 정보나 특정값 (두개면 경로가 두개란 뜻)

// 2. 배포 관리자(deployment descriptor)를 사용
// <web.xml 생성 방법>
// - 프로젝트 마우스 우클릭 - Java EE Tools
// - Generate Deployment Descriptor Stub - WEB INF -> web.xml 수정
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CLASSNAME = TestServlet.class.getName();
    
    		
    public TestServlet() { // 서버를 처음에만 생성하고 인스턴스를 재활용 (=싱글톤)
        System.out.println(CLASSNAME + "TestServlet 생성자 호출"); // 생성자: 인스턴스를 쓰기위해 불러오는 것
        
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println(CLASSNAME + " TestServlet init() 호출");
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
