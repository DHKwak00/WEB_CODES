<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session test</title>
</head>
<body>
	<%
		String userId = (String) session.getAttribute("userId"); // Arribute = object 타입, parameter = String 타입
	%>
	
	<h2><%=userId %>님 안녕하세요</h2>
</body>
</html>