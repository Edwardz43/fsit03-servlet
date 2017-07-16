<%@tag import="java.util.HashMap"%>
<%@ tag dynamic-attributes='product' %>
<%@ attribute name='user' required='true' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<%
	out.print("<h1>Brad Big Company</h1>");
%>

<table border='1' width='100%'>
<tr>
<th>Item</th>
<th>Value</th>
</tr>
<%
	HashMap<String, String> ps = 
		(HashMap<String, String>)jspContext.getAttribute("product");
	//Object ps = pageScope.getAttribute("user");
    out.print("name : "+ps.get("name"));
%>
</table>

