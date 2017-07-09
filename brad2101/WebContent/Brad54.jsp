<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import='tw.ed.beans.*' %>    
<%
	//Member member = new Member();
	//member.setID("001");
	//member.setName("Ed");
	Member member2 = new Member("002", "Andy");
	
	application.setAttribute("member", member2);
	
	member2.setId("003");
	member2.setName("Tony");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome, <%= member2.toString() %>
<% 
	member2.m1();
%>
</body>
</html>