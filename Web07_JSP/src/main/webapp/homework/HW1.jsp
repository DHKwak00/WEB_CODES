<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>적금 계산기</title>
</head>
<body>
	<%--
		JSP 파일 생성(적금 계산 결과 페이지)
		1. 월 적금액, 기간, 이자율을 전송하는 form 만들기 (HW1.jsp)
		- <form action="HW1_result.jsp" method="GET">
		2. 월 적금액, 기간, 이자율을 전송받아 계산하여
			출력하는 jsp 파일 만들기 (HW1_result.jsp)
	 --%>
	
	<form action="HW1_result.jsp" method="get">
		<input type="number" name="inputMoney" placeholder="월 적금액"><br> <!-- 에러 잡기에 입력 단에서 제한걸기가 쉽다 -->
		<input type="number" name="period" placeholder="기간"><br> <!-- type="number" text로 하면 문자입력시 500 에러 -->
		<input type="number" name="interest" placeholder="이자율">
		<input type="submit" value="계산">
	</form>
	
	<%--
	
	 --%>
	 
</body>
</html>