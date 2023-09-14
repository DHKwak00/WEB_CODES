<%@page import="edu.web.member.MemberVO"%>
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
		// TODO : 회원 정보 출력
		// TODO : 회원 수정 버튼 생성(member-update.jsp)
		// TODO : 회원 탈퇴 버튼 생성(delete.do)
		MemberVO vo = (MemberVO)request.getAttribute("vo");
		
		
	%>
	<h2>회원 정보 출력</h2>
	<h3><%=(String) session.getAttribute("userid") %>님의 회원 정보</h3>

	<br>
	<p>비밀번호 : <%=vo.getPassword() %></p>
	<p>이메일 : <%=vo.getEmail() %></p>
	<p>이메일 수신여부 : <%=vo.getEmailAgree() %></p>
	<p>관심사항 : <%=vo.getInterestJoin() %></p>
	<p>휴대폰 : <%=vo.getPhone() %></p>
	<p>자기 소개 : <%=vo.getIntroduce() %></p><br>
		
	<button onclick="location.href='delete.do'">회원 탈퇴</button> <!-- 디비에 무언가 가면 pOSt 방식 사용 -->
	<button onclick="location.href='member-update.jsp'">회원정보 수정</button>
	
</body>
</html>