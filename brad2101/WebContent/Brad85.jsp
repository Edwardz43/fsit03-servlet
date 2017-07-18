<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib tagdir="/WEB-INF/tags" prefix='ed' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ed:test1/><br>
<ed:test2 user="EdLo" />
<hr>
<ed:test3 x="10" y="3" >10 + 3 = ${add} <br></ed:test3>
<ed:test3 x="10" y="3" >10 - 3 = ${sub}<br></ed:test3>
<ed:test3 x="10" y="3" >10 * 3 = ${multi}<br></ed:test3>
<ed:test3 x="10" y="3" >10 / 3 = ${devi}<br></ed:test3>
<hr>
<ed:test5 user='ed' name='EdLo' sex='Male' Age='34' />
<hr>

<ed:myMail from='b93303015@gmail.com' to='b93303015@gmail.com'/>
</body>
</html>