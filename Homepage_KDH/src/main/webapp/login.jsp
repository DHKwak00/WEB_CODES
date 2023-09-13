<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<%
		// TODO : <a>태그를 이용하여 member-register.jsp 이동 링크 생성
		// TODO : 로그인 form 생성. action="login_auth.do" method="post"
	%>
	<form action="login_auth.do" method="post">
	 	아이디 <br><input type="text" name="userid" required="required"><br>
	 	비밀번호 <br><input type="password" name="password"><br>
	 	<br>
	 	<input type="submit" value="로그인"><br>
	 	<a href="member-register.jsp">회원 가입</a>
	 </form>
	 

</body>
</html>





