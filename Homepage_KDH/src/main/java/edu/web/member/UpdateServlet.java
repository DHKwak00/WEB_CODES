package edu.web.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO : member-update.jsp에서 전송받은 데이터로 DB 회원 정보 수정
//		  회원 정보 수정에 성공하면 member-result.jsp에 vo 데이터 전송하여 출력
@WebServlet("/Update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;

	public UpdateServlet() {
		dao = MemberDAOImple.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
