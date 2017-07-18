<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix='ed' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
寄件者: <input type='email' name='from'><br>
收件者: <input type='email' name='to'><br>
<input type='submit' value='Send' />
</form>
<c:if test="${param.from != \"\" && param.to != \"\"}">
<ed:myMail from='${param.from}' to='${param.from}'/>
</c:if>
</body>
</html>