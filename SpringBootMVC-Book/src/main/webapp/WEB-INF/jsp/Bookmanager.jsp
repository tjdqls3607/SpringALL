<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mycom.myapp.dto.BookDto" %>
<%
	BookDto bookDto = (BookDto) request.getAttribute("bookDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>율라딘</title>
</head>
<body>
	<h1>부욱- 매니져어</h1>
	<h3>제목 : <%= bookDto.getBookName() %></h3>
	<h3>가격 : <%= bookDto.getPrice() %></h3>
	<h3>출판사 : <%= bookDto.getPublisher() %></h3>
</body>
</html>