<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	3. 로그인 결과 페이지(HW4_login_result.jsp)
	 - 세션에서 id 값을 꺼내서 HTML 태그에 출력
	 - 만약, 로그인 하지 않고 URL에 접속할 경우 '로그인 해주세요!'라고 alert 띄우고 HW4.jsp 페이지로 이동
	 - alert 띄우는 코드
	 	out.print("<script>alert('로그인 해주세요!');</script>");
 --%>
 
 <%
 	String userId = (String) session.getAttribute("userId");
 	System.out.println("세션에서 받은 " + userId);
 	Date createTime = new Date(session.getCreationTime());
 	Date lastAccessTime = new Date(session.getLastAccessedTime());
 	if(userId != null){
 %>
 	<h1><%=userId %>님 환영합니다!</h1>
 	<h2>세션 아이디 : <%=userId %></h2>
 	<h3>세션 생성 시간 :<%=createTime %></h3>
 	<h3>마지막 접속 시간 : <%=lastAccessTime %></h3>
 <%
 	}else{
 		out.print("<script>alert('로그인 해주세요!');</script>");
 		out.print("<script>location.href='HW4.jsp'</script>");
 	}	
 %>
 	
</body>
</html>