<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과 화면</h1>
	<p><%=request.getParameter("id") %>님, 환영합니다.</p>
	<%
		String saveId = request.getParameter("id");
		String savePw = request.getParameter("pw");
		String agreed = request.getParameter("isSaveAgreed");
		
		if(agreed != null){ // 아이디 저장이 체크
			Cookie saveIdCookie = new Cookie("id", saveId);
			Cookie savePwCookie = new Cookie("pw", savePw);
			
			saveIdCookie.setMaxAge(60 * 60 * 1);
			savePwCookie.setMaxAge(60 * 60 * 1);
		
			response.addCookie(saveIdCookie);
			response.addCookie(savePwCookie);
		}
		
	%>
</body>
</html>