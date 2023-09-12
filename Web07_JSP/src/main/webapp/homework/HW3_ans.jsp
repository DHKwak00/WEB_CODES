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
	- 회원 가입 form 만들기
	- post 방식
	- action="HW3_member_info.jsp"
	- 아이디(text) : name="userid"
	- 패스워드(password) : name="password"
	- 이메일(email) : name="email"
	- 이메일 수신여부(radio 버튼) : name="emailAgree"
	- 관심사항(checkbox, 관심사항 4개 이상 설정) : name = "interest"
	- 핸드폰(text) : name="phone"
	- 자기소개(<textarea>) : name="introduce"
	- 전송 버튼(submit)
	
	2. MemberVO.java 파일
	- src.edu.web.homework 패키지에 MemberVO.java 클래스 생성
	- (변수들은 위의 form input name과 동일하게 작성)
	- MemberVO 기본 생성자 및 매개변수 생성자, getter/setter는 무조건 생성
	- String[] interest; (관심사항은 배열로 변수 선언)
	- request.getParamtereValues() : checkbox로 선택된 여러 개의 데이터를 저장
	
	3. HW3_member_info.jsp 파일
	- HW3.jsp에서 전송된 데이터를 출력
	- request.getParamter or request.getParameterValues를 사용하지 않고 구현
	- 아래 코드를 추가하면 해결됨
		<jsp:useBean id="member" class="edu.web.homework.MemberVO" />
		<jsp:setProperty property="*" name="member" />
	- property="*" 의 의미 : HW3.jsp에서 넘어온 모든 parameter 값을 member에 저장	
	 --%>
	
	<h2>회원 가입하기</h2>
  	<form action="HW3_member_info.jsp" method="post">
    	<p>아이디</p>
	    <input type="text" name="userid" placeholder="아이디 입력" required="required">
	    <p>패스워드</p>
	    <input type="password" name="password" placeholder="비밀번호 입력" required="required">
	    <p>이메일</p>
	    <input type="email" name="email" placeholder="이메일 입력" required="required">
	    <p>이메일 수신여부</p>
	    <input type="radio" name="emailAgree" value="yes">예
	    <input type="radio" name="emailAgree" value="no" checked="checked">아니오
	    
	    <p>관심사항</p>
	    <input type="checkbox" name="interest" value="IT">IT/인터넷
	    <input type="checkbox" name="interest" value="movie">영화
	    <input type="checkbox" name="interest" value="music">음악
	    <input type="checkbox" name="interest" value="book">책
	    <input type="checkbox" name="interest" value="food">음식    
	    
	    <p>핸드폰</p>
	    <input type="text" name="phone" placeholder="번호 입력" required="required">
	    
	    <p>자기소개</p>
	    <textarea rows="4" cols="30" name="introduce" placeholder="자기소개 입력" required="required"></textarea>
	    <br>
	    <input type="submit" value="전송" >
  	</form>

</body>
</html>









