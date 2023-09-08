<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP useBean</title>
</head>
<body>
	<%--
		* JSP : useBean
		- 특정 클래스 객체(object)를 쉽게 사용하기 위한 태그
		- 기본 타입
			<jsp:useBean id="name" class="package.classname.java" />
			<jsp: setProperty> 저장 및 변경
			<jsp: getProperty> 가져오기
		- 속성(attribute)
			id : 빈의 이름
			class : 빈이 사용될 클래스 위치
			scope : 빈이 사용될 범위
			property : 빈의 각 속성 이름(생성된 클래스의 변수 이름과 일치해야 함) - 변수
			value : property에 들어갈 값(데이터)
		- 범위(scope)
			page : 생성된 페이지 내에서 사용 가능 (나 jsp)
			request : 요청된 페이지 내에서 사용 가능 (나와 너)
			session : 웹 브라우저(크라이언트)의 생명 주기 내에서 사용 가능 (크롬 끄기)
			application : 웹 어플리케이션의 생명 주기 내에서 사용 가능
		- scope의 포함 관계
			page < request < session < application
			
			
	--%>
	<jsp:useBean id="test" class="edu.web.jsp01.TestBean"></jsp:useBean><%-- 인스턴스가 생성 된다. -->
	<%-- useBean 사용 상법1 --%>
	<jsp:setProperty name="test" property="msg" value="msg 값이 변경됨" />
	<%-- name : id 값과 일치, property : 클래스 변수명과 일치, value : 적용할 값 --%>
	<p>변경된 값 출력 : <jsp:getProperty name="test" property="msg" /></p>
	
	<%-- useBean 사용 방법2 : getter/setter 이용 --%>
	<% test.setMsg("getter/setter 사용"); %>
	
	<%-- useBean 사용 방법3 : EL 표기법 사용 --%>
	${test.msg}
	
</body>
</html>