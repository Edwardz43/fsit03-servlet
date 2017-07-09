<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] names ={"Brad", "III" ,"OK", "World"};
	pageContext.setAttribute("names", names);
	pageContext.setAttribute("step", 1);
%>

<table border='1' width='100%'>
	<tr>
		<th>index</th>
		<th>name</th>
		<th>Count</th>
		<th>First</th>
		<th>Last</th>
	</tr>
	<c:forEach items="${names}" var='name'
		begin="0" end="3" step="${step}" varStatus="status">
		<tr>
			<td align='center'>${status.index }</td>
			<td align='center'>${name }</td>
			<td align='center'>${status.count }</td>
			<td align='center'>${status.first }</td>
			<td align='center'>${status.last }</td>
		</tr>
	</c:forEach>
</table>
<hr>

<%
	String line = "1, brad, male, 0912345678, 2017-01-02, 台中市西屯區";
	pageContext.setAttribute("line", line);
%>
<c:forTokens items="${line}" delims="," var="field" varStatus='status'>
${status.count} : ${field }<br>
</c:forTokens>
<hr>
<c:import var = "data" url = "http://www.tutorialspoint.com"/>
<c:import url="Brad68.jsp" var="data2">
<c:param name="x" value="1"></c:param>
<c:param name="y" value="2"></c:param>
</c:import>
<c:out value = "${data2}"/>
<%
	String data = (String)pageContext.getAttribute("data");
	out.print(data);
%>
</body>
</html>