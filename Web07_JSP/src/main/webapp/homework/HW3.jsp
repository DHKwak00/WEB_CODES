<%@page import="java.lang.reflect.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<%--
	1. HW3.jsp 파일 
	 - 회원가입 form 만들기
	 - POST 방식
	 - action="HW3_member_info.jsp"
	 - 아이디(text) : name="userId"
	 - 패스워드(password) : name="password"
	 - 이메일(email) : name="email"
	 - 이메일 수신여부(radio 버튼) : name="emailAgree"
	 - 관심사항(checkbox, 관심사항 4개 이상 설정) : name="interest"
	 - 핸드폰(text) : name="phone"
	 - 자기소개(<textarea>) : name="introduce"
	 - 전송 버튼(submit)
	 --%>
	 
	 <h2>회원가입</h2>
	 <form action="HW3_member_info.jsp" method="post">
	 	아이디<br><input type="text" name="userId"><br>
	 	패스워드<br><input type="password" name="password"	><br>
	 	이메일<br><input type="email" name="email"><br>
	 	이메일 수신여부<br><input type="radio" name="emailAgree" value="O" checked>수신
	 					<input type="radio" name="emailAgree" value="X">미수신<br>
	 	관심사항<br><input type="checkbox" name="interest" value="IT">IT
	 				<input type="checkbox" name="interest" value="FOOD">음식
	 				<input type="checkbox" name="interest" value="SPORTS">스포츠
	 				<input type="checkbox" name="interest" value="BOOK">도서<br>
	 	휴대폰<br><input type="text" name="phone"><br>
	 	자기소개<br><textarea rows="10" cols="30" name="introdue"></textarea><br>
	 	<input type="submit" value="전송">
	 </form>
	 
	 
	<%--
	2. MemberVO.java 파일
	 - src.edu.web.homework 패키지에 MemberVO.java 클래스 생성
	 - (변수들은 위의 form input name과 동일하게 작성)
	 - MemberVO 기본 생성자 및 매개변수 생성자, getter/setter는 무조건 생성
	 - String[] interest; (관심사항은 배열로 변수 선언)
	 - request.getParameterValues() : checkbox로 선택된 여러 개의 데이터를 저장(선택 안할 수 있다.)
	 --%>
	
	<%-- 
	3. HW3_member_info.jsp 파일
	 - HW3.jsp에서 전송된 데이터를 출력
	 - request.getParameter or request.getParameterValues를 사용하지 않고 구현
	 - 아래 코드를 추가하면 해결
	 	<jsp:useBean id="member" class"edu.web.homework.MemberVO" />
	 	<jsp:setProperty property= "*" name="member" />
	 - property="*" 의 의미 : HW3.jsp에서 넘어온 모든 parameter 값을 member에 저장
	 --%>
	 
</body>
</html>