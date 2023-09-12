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
		String fileName = (String) session.getAttribute("fileName");
	%>
	<!-- 
		파일로 전송한 이미지가 출력되도록 코드 작성
	 -->
	 <img alt="이미지" src="images/<%=fileName %>" width="200" height="300">
	 <a href="images/<%=fileName %>">링크</a>
</body>
</html>