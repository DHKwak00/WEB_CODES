<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* java의 servlet의 service 공간 */
	String name = request.getParameter("name");
	String city = request.getParameter("city");
	
	out.write("name : " + name + ", name " + city);
	
%> 