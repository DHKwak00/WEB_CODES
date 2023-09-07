<%@page import="edu.web.servlet05.InfoVO"%>
<%@page import="java.lang.ProcessHandle.Info"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 페이지</title>
</head>
<body>
	<%
		String name = (String) request.getAttribute("name"); // 다형성 이용
		String lived = (String) request.getAttribute("lived");
		int age = (Integer) request.getAttribute("age");
		InfoVO vo = (InfoVO) request.getAttribute("vo");
	%>
	
	<p>이름 : <%=name %></p>
	<p>나이 : <%=age %></p>
	<p>사는 곳 : <%=lived %></p>
	<p>vo = <%=vo.toString() %></p>
	
	
</body>
</html>