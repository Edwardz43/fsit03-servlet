<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border='1' width='100%'>
<% 
		out.print("<tr>");
		for(int i = 0; i < 18; i++){
			if((i % 2 == 0 && i % 8 < 4)||(i % 2 != 0 && i % 8 > 4)) 
				out.print("<td align='center' bgcolor='yellow'>");
			else 
				out.print("<td align='center' bgcolor='pink'>");
			for(int j = 0; j < 9; j++){
				int r = (j + 1)* (i + 2);
				out.print((i+2)+"x"+(j + 1)+"="+r+"<br>");
			}
			out.print("</td>");
			if(i % 4 == 3) out.print("<tr></tr>");
		}
		out.print("</tr>");
%>	
</table>
	
</body>
</html>