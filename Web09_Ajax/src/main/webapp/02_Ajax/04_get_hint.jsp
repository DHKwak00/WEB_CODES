<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	전송된 데이터가
	만약 'a'로 시작하면 "apple"
	만약 'b'로 시작하면 "banana"
	만약 'c'로 시작하면 "coconut"
	그게 아니면 "not fruits"를 돌려줘라!
	다 지우면 추천: 없어짐
	에러 안됨
 --%>
 
 <%
 	String txt = request.getParameter("txt");
 	char first = txt.charAt(0);
 	if(first == 'a'){
 		out.print("apple");
 	}else if(first == 'b'){
 		out.print("banana");
 	}else if(first == 'c'){
 		out.print("coconut");
 	}else {
 		out.print("not fruits");
 	}
 %>