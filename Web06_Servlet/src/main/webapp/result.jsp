<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 자바의 의미 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
	<%
		// request : forward에서 넘겨받은 request 객체
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String money = request.getParameter("money");		
	%>
	
	<h1>결과 페이지</h1>
	<p>제 이름은 <%=name %>입니다.</p>
	<p>제 나이는 <%=age %>입니다.</p>
	<p>제 이메일은 <%=email %>입니다.</p>
	<p>제 재산은 <%=money %>입니다.</p>
</body>
</html>