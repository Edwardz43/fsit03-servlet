<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import='java.util.*, java.sql.*,java.io.*' %>
<%@page session='true' buffer='8kb' autoFlush="true" %>
<%@page info='Hello World' %>   
<%@page errorPage='Brad44.jsp' %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= getServletInfo() %>
<% 
	int a = 10, b = 0;
	out.print(a / b);
%>
</body>
</html>