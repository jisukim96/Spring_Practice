<%@page import="com.spring.practice.dto.UserTestDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% UserTestDTO user_detail = (UserTestDTO) session.getAttribute("user_detail"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>유저 정보</h1>
		<hr>
		<table>
			<tr>
				<th>인덱스번호</th><th>아이디</th><th>비밀번호</th>
			</tr>
			<tr>
				<td><%=user_detail.getIdx()%></td><td><%=user_detail.getId()%></td><td><%=user_detail.getPass()%></td>
			</tr>
		</table>
	</center>
</body>
</html>