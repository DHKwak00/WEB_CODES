package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO : member-result.jsp에서 이동
//		session에서 userid 값을 저장 DB 회원 정보 삭제
//		삭제 성공 후에 login.jsp 페이지로 이동
@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAOImple dao;   
    
    public DeleteServlet() {
    	dao = MemberDAOImple.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		System.out.println(userid);
		int result = dao.delete(userid);
		System.out.println(result);
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
//		PrintWriter out = response.getWriter();
//		out.append("<!DOCCTYPE HTML>")
//		   .append("<html>")
//		   .append("<header><meta charset='UTF-8'></header>")
//		   .append("<body>")
//		   .append("<script>alert('회원 탈퇴 완료');</script>")
//		   .append("<script>location.href='login.jsp'</script>")
//		   .append("</body>")
//		   .append("</html>");
	}

}
