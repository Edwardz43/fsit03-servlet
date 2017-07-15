<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage='Error.jsp' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/sql' prefix='sql' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<sql:setDataSource driver='com.mysql.jdbc.Driver' 
	url='jdbc:mysql://127.0.0.1:3306/brad' 
	user='root' password='root' />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty param.delid}">
	<sql:update var='count'>
	delete from member where id = ${param.delid}
	</sql:update>
</c:if>


<sql:query sql='select * from member' var='result' />
<table border='1' width='100%'>
	<tr>
		<th>Id</th>
		<th>Account</th>
		<th>Passwd</th>
		<th>Real name</th>
		<th>Delete</th>
		<th>Edit</th>
	</tr>
	<c:forEach items='${result.rows}' var='row'>
		<tr>
	    	<td> <c:out value = "${row.id}"/></td>
	        <td> <c:out value = "${row.account}"/></td>
	        <td> <c:out value = "${row.pw}"/></td>
	       	<td> <c:out value = "${row.realname}"/></td>
	       	<td> <a href='?delid=${row.id}'>Delete</a></td>
	       	<td> <a href='Brad74.jsp?editid=${row.id}'>Edit</a></td>
	    </tr>
	 </c:forEach>  
</table>

</body>
</html>