<%@page import="edu.web.homework.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 
    // *HW2.jsp (dispatcher 경로 주의)
    // - SendListServlet.java에서 전송된 list 데이터 저장
    // - 저장된 list 데이터 테이블 형태로 출력
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
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
		ArrayList<BoardVO> list = (ArrayList<BoardVO>) request.getAttribute("list");
		System.out.println("리스트 : " + list);
	%>
	
	<table>
		<thead>
			<tr>
				<th>게시글</th>
			</tr>	
		</thead>
		<tbody>
			<% for(int i=0; i<list.size(); i++) {%>
			<tr>
				<td><%=list.get(i).getBoardId() %><td>
				<td><%=list.get(i).getBoardTitle() %><td>
				<td><%=list.get(i).getUserId() %><td>
				<td><%=list.get(i).getBoardRegDate() %><td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>