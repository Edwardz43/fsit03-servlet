<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import='tw.ed.beans.Member'/>
<%
	Member member = new Member();
	member.setId("008");member.setName("Brone");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:declaration>
int i; String name;
</jsp:declaration>
<jsp:scriptlet>
	i = 10;
	name = "Brad";
</jsp:scriptlet>
<jsp:expression>member</jsp:expression>
<jsp:text>I am Brad</jsp:text>
</body>
</html>