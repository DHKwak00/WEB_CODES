<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="04_error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Directive를 사용한 에러 페이지 처리</h1>
	<p>나눗셈 결과 : <%=123/0 %></p> <!-- 자바에서 에러남 error:500 -->
	<%
		String[] str = new String[2];
		str[5] = "hello";
	%>
</body>
</html>