package edu.web.servlet05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Send")
public class SendToClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SendToClientServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.setAttribute // request.getAttribute
		// - 데이터를 key-value 형식으로 전송하는 방식
		// - 문자열 뿐만 아니라, 다양한 변수 및 객체를 전송할 수 있음
		// * attribute와 parameter의 차이점***
		// - parameter는 html form 태그를 통해 데이터 전송 (클라이언트에서 서버로)
		// - parameter는 String 형태로 값을 전송
		// - attribute는 주로 서버에서 클라이언트로 데이터 전송
		// - attribute는 Object 형태로 값을 전송
		
		request.setAttribute("name", "고길동"); // 파라미터는 string으로만 가능 attribute는 클래스로 묶기 가능
		request.setAttribute("lived", "서울 쌍문동"); // request만 써야되고 그럴려면 forward 방식으로만 사용 가능
		request.setAttribute("age", 40);
		
		//VO로 묶기
		InfoVO vo = new InfoVO("둘리", "서울 쌍문동", 1000);
		request.setAttribute("vo", vo);
		
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/my_info.jsp");
		dispatcher.forward(request, response);
		// 다음은 JSP를 쓰자
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
