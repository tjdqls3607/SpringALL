<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mycom.myapp.dto.CarDto" %>
<%
	String seq = (String) request.getAttribute("seq");
	CarDto carDto = (CarDto) request.getAttribute("carDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>viewTest3.jsp</h1>
	<h4>seq : <%= seq %></h4>
	<h4>CarDto</h4>
	<h4>name : <%= carDto.getName() %></h4>
	<h4>name : <%= carDto.getPrice() %></h4>
	<h4>name : <%= carDto.getOwner() %></h4>
</body>
</html>