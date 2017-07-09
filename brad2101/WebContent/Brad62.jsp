<%@page import="java.util.LinkedList,java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>    
<%
	String[] names = {"Brad", "III", "Ok"};
	request.setAttribute("usernames", names);
	
	LinkedList<String> list = new LinkedList<>();
	list.add("AAA");
	list.add("BBB");
	list.add("CCC");
	request.setAttribute("list", list);
	
	HashMap<String, String> map = new HashMap<>();
	map.put("name", "Ed");
	map.put("account", "b93303015");
	map.put("passwd", "123456");
	request.setAttribute("map", map);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Name1 : ${usernames[0]}<br>
Name2 : ${usernames[1]}<br>
Name3 : ${usernames[2]}<br>
<hr>
List : ${list[param.i] }<br>
List1 : ${list[0] }<br>
List2 : ${list[1] }<br>
List3 : ${list[2] }<br>
<hr>
Map : ${map[param.j] }<br>
Name : ${map["name"] }<br>
Account : ${map["account"] }<br>
Password : ${map["passwd"] }<br>
<hr>
${10 + 3 / 7 }<br>
${(param.i=="1")?"Yes": "No"}<br>
${1 > 3 }<br>

</body>
</html>

