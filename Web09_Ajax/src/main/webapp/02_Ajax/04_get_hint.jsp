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
 String str = request.getParameter("txt");
 String apple = "사과"; 
 String banana = "바나나";
 String coconut = "코코넛";
 %>
 <%-- <%
 if(param.str.equals("^a")){
 %>
 	<p><%=apple %></p>
 <%
 }else if(str.equals("^b")){
 %>
 	<p><%=banana %></p>
 <%
 }else if(str.equals("^b")){
 %>
 	<p><%=coconut %></p>
 <%
 }
 %> --%>

<p>${param.str }</p> 
 
 
 
 
 
 
 