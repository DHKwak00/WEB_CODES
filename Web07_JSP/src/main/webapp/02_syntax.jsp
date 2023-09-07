<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
	// 멤버 변수
	int fontSize;
	int day = 4;
%>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 구문</title>
</head>
<body>
	<%--
		JSP 태크는 HTML 내 어느 위치에서든 사용 가능
	--%>
	<%
		int day = 1; // 지역 변수
	%>
	
	<%
		if(day == 1 || day == 7){
	%>
		<p>오늘은 주말입니다.</p>
	<% 
		}else{
	%>
		<p>오늘은 평일입니다.</p>
	<%
		}	
	%>
	
	<%
		for(fontSize = 1; fontSize <= 3; fontSize ++) {
	%>
		<font color="green" size="<%=fontSize %>">JSP 구문 연습</font><br>
	<%
		}
	%>
</body>
</html>