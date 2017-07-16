<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage='Error.jsp' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/sql' prefix='sql' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty param.account}">
	<c:redirect url = "Brad73.jsp"/>
</c:if>
<sql:setDataSource driver='com.mysql.jdbc.Driver' 
	url='jdbc:mysql://127.0.0.1:3306/brad' 
	user='root' password='root' />
<c:if test="${!empty param.account}">
	<sql:update var='count'>
		update member set account=?, pw=?, realname=? where id=?
		<sql:param>${param.account}</sql:param>	
		<sql:param>${param.pw}</sql:param>	
		<sql:param>${param.realname}</sql:param>
		<sql:param>${param.id}</sql:param>
	</sql:update>	
	<c:redirect url = "Brad73.jsp"/>
</c:if>
</body>
</html>