package edu.web.servlet02;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns =  "/LifeCycleServlet", loadOnStartup = 1) // 두개이상 사용하려면 urlPatterns = 를 명시
// loadOnStartup
// - 서버가 실행될 때 서블릿 인스턴스를 메모리에서 로드하는 우선 순위를 설정
// - 숫자가 작을수록 init() 함수가 실행되는 순서가 빠름
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CLASSNAME = LifeCycleServlet.class.getName();
   
    public LifeCycleServlet() {
        System.out.println(CLASSNAME + " : LifeCycleServlet 생성자 호출");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println(CLASSNAME + " : LifeCycleServlet init() 호출");
    	
    }
    
    // service() : 외부에서 servlet으로 특정 HTTP 요청이 발생하면 처리하는
    //				생명 주기 메소드(GET/POST 처리
    // - doGet()과 doPost()가 service()의 역할로 분담
	
    // url을 치면 자동으로 겟하는 곳
	protected void doGet(HttpServletRequest request, HttpServletResponse response /* ()는 요청을 위한 정보들 */) throws ServletException, IOException {
		System.out.println("test");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	// destroy() : servlet이 종료될 때 호출되는 생명 주기 메소드
	
	@Override
	public void destroy() {
		System.out.println(CLASSNAME + " : LifeCycleServlet destroy() 호출");
	}

}
