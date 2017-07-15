<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Locale locale =  request.getLocale();
%>
Locale : <%= locale.getCountry() %><br>
Locale : <%= locale.getDisplayCountry() %><br>
Locale : <%= locale.getLanguage() %><br>
<hr>
<fmt:setBundle basename="res"/>
<fmt:message key='Hello'/>, <fmt:message key='World'/> 
<hr>
<fmt:message key='Companyname'/>
<hr>
<% 
Date now = new Date();
out.print(now);
pageContext.setAttribute("now", now);
%>
<hr>
<fmt:setTimeZone value="Asia/Taipei"/>
<fmt:formatDate value="${now}" type='both' dateStyle='long' /><br>
<fmt:setTimeZone value="Africa/Kampala"/>
<fmt:formatDate value="${now}" type='both' dateStyle='long' /><br>
<hr>
Default :<fmt:formatNumber value='${1234567.890123 }'/><br><hr>
沒有千分位 :<fmt:formatNumber value='${1234567.890123 }' groupingUsed='false'/><br><hr>
Max 4 digit :<fmt:formatNumber value='${1234567.890123 }' maxIntegerDigits="4"/><br><hr>
Min 8 digit :<fmt:formatNumber value='${1234567.890123 }' minIntegerDigits="8" groupingUsed='false'/><br><hr>
Fraction Max 2 digit : <fmt:formatNumber value='${1234567.890123 }' maxFractionDigits="0" groupingUsed='false'/><br><hr>
<fmt:formatNumber value='${123}' type='currency' currencyCode='CNY'/>

</body>
</html>