<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage='Error.jsp' %>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix = "fn" 
   uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var='thestring' value="I'm a String"></c:set>
${fn:contains(theString, 'test')}
<hr>
<c:set var = "string1" value = "This is first String."/>
<c:set var = "string2" value = "${fn:substringAfter(string1, 'Th')}" />
==>${string2}
</body>
</html>