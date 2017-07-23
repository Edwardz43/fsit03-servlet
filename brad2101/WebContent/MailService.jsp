<%@page import="javax.mail.MessagingException"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
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
標題: <input type='text' name='sub'><br>
內文 : <br> <textarea rows="4" cols="50" name='text'>
 		  </textarea>
<input type='submit' value='Send' />
</form>
<c:if test="${param.from != \"\" && param.to != \"\"}">
<ed:myMail from='${param.from}' to='${param.to}' 
			sub='${param.sub}' text='${param.text}' />
</c:if>
</body>
</html>