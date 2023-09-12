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
	2. 로그인 인증 페이지(HW4_login_auth.jsp) 확인만 하는 페이지
	 - 전송 받은 id, pw를 확인하여 id는 "test", pw는 "1234"일 경우
	   id 세션을 생성(만료 시간은 마음대로)
	 - 세션을 생성한 이후에 HW4_login_result.jsp 페이지로 이동
	 - 페이지 이동 코드
	 	out.print("<script>location.href='HW4_logion_result.jsp'</script>");
	 - 전송 받은 id, pw가 "test", "1234"가 아닌 경우, HW4.jsp 페이지로 이동
 --%>
 
 <%
 	String userId = request.getParameter("userId"); /* form은 parameter 사용해야한다 */
 	String userPw = request.getParameter("password");
 	System.out.println("폼에서 받은 " + userId);
 	System.out.println(userPw);
 	
 	if(userId.equals("test") && userPw.equals("1234")){
 	
 		session.setMaxInactiveInterval(30);
 		session.setAttribute("userId", userId); // 세션 생성
 		out.print("<script>location.href='HW4_login_result.jsp'</script>");
 		
 	}else{
 		out.print("<script>location.href='HW4.jsp'</script>");
 	}
 %>
</body>
</html>