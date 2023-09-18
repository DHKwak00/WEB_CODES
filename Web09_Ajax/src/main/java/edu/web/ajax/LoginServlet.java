package edu.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * json 라이브러리 다운
		// https://code.google.com/archive/p/json-simple/downloads
		
		String obj = request.getParameter("obj");
		System.out.println(obj);
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(obj);
			System.out.println(jsonObject);
			
			String userid = (String) jsonObject.get("userid");
			String password = (String) jsonObject.get("password");
			System.out.println(userid);
			System.out.println(password);
			
			if(userid.equals("test") && password.equals("1234")) {
				PrintWriter out = response.getWriter();
				out.append("success");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
