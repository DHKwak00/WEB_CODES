<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
	border-style : ${param.boardStyle};
	border-color : ${param.boardColor};
	border-width : 1px;
	font-size : ${param.fontSize};
	color : ${param.fontColor};
}


</style>
<meta charset="UTF-8">
<title>${param.title }</title>
</head>
<body>
	<h2>${param.title }</h2>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>링크 주소</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
		<%--
			- JSP 태그(<% %>)와 EL 태그는 혼용해서 사용하기 어려움
			- JSP 태그와 HTML을 같이 사용하면 가독성이 떨어짐
			- EL 태그는 제어문이 없기 때문에 JSTL을 이용하여 반복문 사용
		 --%>
<%-- 			<%
				String[] linkList = request.getParameterValues("link");
			%>
			<%
				for (int i = 0; i < linkList.length; i++) {
			%>
				<tr>
					<td><%=i + 1 %></td>
					<td><a href="<%=linkList[i] %>"><%=linkList[i] %></a></td>
					<td>-</td>
				</tr>
			<%
				}
			%> --%>
			
			<%-- JSTL을 사용하여 만약 link 값이 null인 경우 
				 "선택된 링크가 없습니다"라고 HTML <p>태그로 표현
			 --%>
			<c:if test="${empty paramValues.link}">
				<p>선택된 링크가 없습니다</p>
			</c:if>
			<%-- JSTL을 사용하여 linkList의 값을 표로 출력 --%>
			<c:forEach var="link" items="${paramValues.link }" varStatus="s">
				<tr>
					<td>${s.count }</td>
					<td><a href="${link }">${link }</a></td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>





