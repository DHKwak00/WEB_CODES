<%@page import="edu.web.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberVO vo = (MemberVO) request.getAttribute("vo");
		request.getSession(); // 여기 session이나 servlet session이나 같은거다
	%>
	<p><%=vo.getUserid() %>님, 환영합니다!</p>
	
</body>
</html>