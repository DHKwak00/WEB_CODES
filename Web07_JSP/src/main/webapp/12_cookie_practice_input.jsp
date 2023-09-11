<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
	12_cookie_practice_input.jsp
	ㄴ아이디 저장 체크
	ㄴ입력한 id/pw 출력
	ㄴ 쿠키에 저장된 아이디 비번 지속적으로 출력

	12_cookie_practice_result.jsp
	ㄴ아이디 비번 전송 받아 쿠키에 저장(아이디 체크한 경우)
	ㄴ쿠키 유지시간 60분
	ㄴ<p> 태그를 이용하여 ()님 환영합니다 출력
 -->
</head>
<body>
	
	<%
	// 저장된 id, pw 쿠키를 꺼내서
	// input 태그(id, pw)에 값 보여주기
	String id= "";
	String pw= "";
	Cookie[] cookies = request.getCookies();
	if(cookies !=null){
		for(Cookie cookie : cookies){
			System.out.println(cookie.getName());
			
			if(cookie.getName().equals("id")){
				id = cookie.getValue();
				System.out.println(id);
				
			}else if(cookie.getName().equals("pw")){
				pw = cookie.getValue();
				System.out.println(pw);
			}
		}
	}
	%>
	<form action="12_cookie_practice_result.jsp" method="post">
		아이디<br>
		<input type="text" name="id" value="<%=id%>"><br>
		비밀번호 <br>
		<input type="password" name="pw" value="<%=pw%>"><br>
		<input type="checkbox" name="isSaveAgreed" value="agreed">
		아이디 저장 <br><br>
		<input type="submit" value="로그인">
	</form>
	
</body>
</html>