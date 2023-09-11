<%@page import="edu.web.homework.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%-- 
	3. HW3_member_info.jsp 파일
	 - HW3.jsp에서 전송된 데이터를 출력
	 - request.getParameter or request.getParameterValues를 사용하지 않고 구현
	 - 아래 코드를 추가하면 해결
	 	<jsp:useBean id="member" class="edu.web.homework.MemberVO" />
	 	<jsp:setProperty property= "*" name="member" />
	 - property="*" 의 의미 : HW3.jsp에서 넘어온 모든 parameter 값을 member에 저장
	 --%>
<head>
<meta charset="UTF-8">
<title>member info</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="member" class="edu.web.homework.MemberVO" />
	<jsp:setProperty property= "*" name="member" />
	
	<h1>회원 정보</h1>
	<p>아이디 : <%=member.getUserId() %></p>
	<p>패스워드 : <%=member.getPassword() %></p>
	<p>이메일 : <%=member.getEmail() %></p>
	<p>이메일 수신여부 : <%=member.getEmailAgree() %></p>
	<p>관심사항 : 
	<%
	String[] str = member.getInterest();
	
	if(member.getInterest() == null){
		out.println(" 없음 ");
	}else{
		for(int i=0; i<str.length; i++){
			out.println(str[i]);
			out.println(" ");
		}
	}
	%></p>
	<p>휴대폰 : <%=member.getPhone() %></p>
	<p>자기소개 : <%=member.getIntrodue() %></p>
	
</body>
</html>