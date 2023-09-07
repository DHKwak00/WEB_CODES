<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 구문 연습</title>
<style type="text/css">
table{
	font-family : arial, sans-serif;
	border-collapse : collapse;
	width : 100%;
}
td, th{
	borfer : 1px, solid, #dddddd;
	text-align : left;
	padding : 8px;	
}
</style>
</head>
<body>
	<%
		ArrayList<String> list = new ArrayList<>();
		list.add("목진혁");
		list.add("최진혁");
		list.add("김진혁");
	%>
	
	<table>
		<thead>
			<tr>
				<th>이름</th>
			</tr>	
		</thead>
		<tbody>
			<% for(int i=0; i<list.size(); i++) {%>
			<tr>
				<td><%=list.get(i) %><td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>




