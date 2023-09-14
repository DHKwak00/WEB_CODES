package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TODO : member-register.jsp에서 전송받은 데이터를 DB에 저장
//DB 저장 후에 login.jsp로 이동(심심하면 alert도 띄우기)

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberDAO dao;   
    
    public RegisterServlet() {
        dao = MemberDAOImple.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// url로 접근할 경우 경로 변경
		response.sendRedirect("/Homepage_KDH/member-register.jsp"); //"/Homepage_KDH/login.jsp"
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		
		MemberVO vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
		System.out.println(vo);
		int result = dao.insert(vo);
		System.out.println(result);
		response.sendRedirect("login.jsp");
		/* 알림 띄우기*/
		PrintWriter out = response.getWriter(); // 얘는 response에 실려가서 request.인코딩 해도 불가능
		if(result == 1) {
//			out.print("<head><meta charset='UTF-8'></head>"); // alert 한글로 쓰려면 써야함
			out.print("<script>alert('등록 성공');</script>"); // 문제 발생 ??????????? 나옴
			out.print("<script>location.href='login.jsp';</script>");
		}
//		out.append("<!DOCCTYPE HTML>")
//		   .append("<html>")
//		   .append("<head><meta charset='UTF-8'></head>")
//		   .append("<body>")
//		   .append("<script>alert('회원 가입 완료');</script>")
//		   .append("<script>location.href='login.jsp'</script>")
//		   .append("</body>")
//		   .append("</html>");
		
		// DB 저장에 성공하면 다른 페이지에 데이터 전송
//		if(result == 1) { // insert는 필요 없음 여기는 select hint!
//			RequestDispatcher dispatcher = request.getRequestDispatcher("18_db_result.jsp");
//			request.setAttribute("vo", vo); // vo 보내기
//			dispatcher.forward(request, response); // -> jsp에서 출력 ㄱㄱ
//			
////			// 세션으로 클라이언트에 특정 데이터 전송(참고용)
////			HttpSession session = request.getSession();
////			session.setAttribute("userid", vo.getUserid());
////			session.setMaxInactiveInterval(60);
////			response.sendRedirect("18_db_result.jsp");
//		}
	}

}
