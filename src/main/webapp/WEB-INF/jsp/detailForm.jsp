<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,dto.PhoneDto" %>
<%
PhoneDto phoneDto = (PhoneDto) request.getAttribute("phoneDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서 상세 및 수정</h1>
	<form action="/phoneManager/phones/update" method="post">
		<input type="text" name="phoneId" value="<%= phoneDto.getphoneId() %>"></input><br>
		<input type="text" name="phoneName" value="<%= phoneDto.getphoneName() %>"></input><br>
		<input type="text" name="publisher" value="<%= phoneDto.getPublisher() %>"></input><br>
		<input type="text" name="price" value="<%= phoneDto.getPrice() %>"></input><br>
		<button type="submit">수정</button>
	</form>
	<a href="/phoneManager/phones/list">목록</a>  <a href="/phoneManager/phones/delete?phoneId=<%= phoneDto.getphoneId() %>">삭제</a>
	<hr>
</body>
</html>



