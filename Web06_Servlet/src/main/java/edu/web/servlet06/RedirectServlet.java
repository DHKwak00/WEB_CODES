package edu.web.servlet06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RedirectServlet() {
       
    }
    
    // 쿼리스트링=파라미터 같은것
	// redirect : URL 주소 바뀜. request/response 객체 소멸 (forward 반대)
    // - 같은 서버/다른 서버에 있는 페이지로 이동이 가능
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// redirect를 이용한 데이터 전송 방법(GET방식만 가능)
		String path = request.getContextPath(); // context root 대용
		String pageName = "/result.jsp";
//		String url = path + pageName + "redirect"; // (파라미터의 방식 대체)
		String url = path + pageName +
				"?name=test&age=10&email=test@test.c0m&money=100";
		System.out.println(url);
		response.sendRedirect("/result.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
