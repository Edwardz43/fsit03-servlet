<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage='Error.jsp' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/sql' prefix='sql' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jsp MySQL</title>
</head>
<body>
<sql:setDataSource driver='com.mysql.jdbc.Driver' 
	url='jdbc:mysql://127.0.0.1:3306/brad' 
	user='root' password='root' />
<sql:query sql='select * from member' var='result' />
<table border = "1" width="100%">
	<tr>
		<th>ID</th>
		<th>Account</th>
		<th>Passwd</th>
		<th>Realname</th>
	</tr>	
	<c:forEach items='${result.rows}' var='row'>
		<tr>
	    	<td> <c:out value = "${row.id}"/></td>
	        <td> <c:out value = "${row.account}"/></td>
	        <td> <c:out value = "${row.pw}"/></td>
	       	<td> <c:out value = "${row.realname}"/></td>
	    </tr>
	</c:forEach>
</table>
<hr>
<sql:query var="result2">
select * from member
</sql:query>
<table border = "1" width="100%">
	<tr>
		<th>ID</th>
		<th>Account</th>
		<th>Passwd</th>
		<th>Realname</th>
	</tr>	
	<c:forEach items='${result2.rows}' var='row'>
		<tr>
	    	<td> <c:out value = "${row.id}"/></td>
	        <td> <c:out value = "${row.account}"/></td>
	        <td> <c:out value = "${row.pw}"/></td>
	       	<td> <c:out value = "${row.realname}"/></td>
	    </tr>
	</c:forEach>
</table>
<hr>

<sql:query var="result3">
select * from member where account = ?
<sql:param>iii</sql:param>
</sql:query>
<table border = "1" width="100%">
	<tr>
		<th>ID</th>
		<th>Account</th>
		<th>Passwd</th>
		<th>Realname</th>
	</tr>	
	<c:forEach items='${result3.rows}' var='row'>
		<tr>
	    	<td> <c:out value = "${row.id}"/></td>
	        <td> <c:out value = "${row.account}"/></td>
	        <td> <c:out value = "${row.pw}"/></td>
	       	<td> <c:out value = "${row.realname}"/></td>
	    </tr>
	</c:forEach>
</table>
<hr>
${result3.rows[0].account}
</body>
</html>