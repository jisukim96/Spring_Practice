

<%@page import="java.util.List"%>
<%@page import="com.spring.practice.dto.UserTestDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% List<UserTestDTO> user_list = (List<UserTestDTO>) session.getAttribute("user_list_session");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>리스트</h1>
		<hr>
		<table>
			<tr>
				<th>IDX</th><th>이름</th><th>비밀번호</th>
			</tr>
			<% for(UserTestDTO dto : user_list){ %>
			<tr>
				<td><a href="detail.do?idx_f=<%=dto.getIdx()%>"><%=dto.getIdx()%></a></td> <td><%=dto.getId() %></td> <td><%=dto.getPass() %></td>			
			</tr>
			
			<% } %>
		</table>
	</center>
</body>
</html>