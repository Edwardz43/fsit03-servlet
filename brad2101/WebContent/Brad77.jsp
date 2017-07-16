<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
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
<!-- 利用 c:import 抓遠端資料 -->
<c:import url="http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvPermitAgri.aspx" var='data' />
<% 
	String strJSON = (String)pageContext.getAttribute("data");
	//out.print(strJSON);
	JSONArray root = new JSONArray(strJSON);
	
	for(int i = 0; i < root.length(); i++){
		JSONObject objData = root.getJSONObject(i);
		String name = objData.getString("AgriMainName");
		String adrs = objData.getString("AgriMainAdrs");
		String tel = objData.getString("AgriTel");
		
		out.print(name +" : " + adrs +" : "+ tel + "<br>");
	}
	
%>
</body>
</html>