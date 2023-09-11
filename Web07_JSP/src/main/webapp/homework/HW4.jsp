<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%--
	1. 로그인 정보 전송 페이지(HW4.jsp)
	 - <form action="HW4_login_auth.jsp" method="post">
	 - id, pw 전송
	 
	2. 로그인 인증 페이지(HW4_login_auth.jsp) 확인만 하는 페이지
	 - 전송 받은 id, pw를 확인하여 id는 "test", pw는 "1234"일 경우
	   id 세션을 생성(만료 시간은 마음대로)
	 - 세션을 생성한 이후에 HW4_login_result.jsp 페이지로 이동
	 - 페이지 이동 코드
	 	out.print("<script>location.href='HW4_logion_result.jsp'</script>");
	 - 전송 받은 id, pw가 "test", "1234"가 아닌 경우, HW4.jsp 페이지로 이동
	 
	3. 로그인 결과 페이지(HW4_login_result.jsp)
	 - 세션에서 id 값을 꺼내서 HTML 태그에 출력
	 - 만약, 로그인 하지 않고 URL에 접속할 경우 '로그인 해주세요!'라고 alert 띄우고 HW4.jsp 페이지로 이동
	 - alert 띄우는 코드
	 	out.print("<script>alert('로그인 해주세요!');</script>");
	 --%>
	 
	 <form action="HW4_login_auth.jsp" method="post">
	 	아이디 <br><input type="text" name="userId"><br>
	 	비밀번호 <br><input type="password" name="password"><br>
	 	<input type="submit" value="로그인">
	 </form>
</body>
</html>