<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	String op = request.getParameter("op");
	if(op == null) op = "1";
	int X, Y;
	String res = "";
	if(x != null) X = Integer.parseInt(x); else X = 0;
	if(y != null) Y = Integer.parseInt(y); else Y = 0;
	
	switch(op){
		case "1": res = (X + Y) + ""; break;
		case "2": res = (X - Y) + ""; break;
		case "3": res = (X * Y) + ""; break;
		case "4":
			int temp1 = X / Y;
			int temp2 = X % Y;
			res = temp1+"......"+temp2; break;
	}

%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
	<input type='text' name='x' value='<%= X %>'>
	<select name='op'>
		<option value='1' <%= (op.equals("1")?"selected":"") %> >+</option>
		<option value='2' <%= (op.equals("2")?"selected":"") %> >-</option>
		<option value='3' <%= (op.equals("3")?"selected":"") %> >*</option>
		<option value='4' <%= (op.equals("4")?"selected":"") %> >/</option>
	</select>
	<input type='text' name='y' value='<%= Y %>'>
	<input type='submit' value='='><%= res %>
	
</form>
</body>
</html>