<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import='java.util.*' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Brad Big Company</h1>
<hr>
<% 
	StringBuffer lottery = new StringBuffer();
	for(int i = 0; i < 6; i ++){
		lottery.append((int)(Math.random()*49 +1) + (i==5?"":","));
	}
	
%>

<%= lottery %><br>
<%= Calendar.getInstance().get(Calendar.YEAR) %>
</body>
</html>