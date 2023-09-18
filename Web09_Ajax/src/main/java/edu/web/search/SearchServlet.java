package edu.web.search;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/search_title.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static SearchDAOImple dao;   
   
    public SearchServlet() {
       dao = SearchDAOImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget()");
		String title = request.getParameter("txt");
		System.out.println("검색어 : " + title);
		ArrayList<SearchVO> list = dao.select(title);
		System.out.println(list);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
