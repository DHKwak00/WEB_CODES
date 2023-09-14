package edu.web.member;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


public class CharFilter extends HttpFilter implements Filter {
       
    public CharFilter() {
        
    }

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); // alert을 한글로 띄우기 위해
		chain.doFilter(request, response);
		// web.xml 가서 적용*
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
