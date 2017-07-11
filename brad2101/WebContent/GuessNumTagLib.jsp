
<%@page import="java.util.HashMap,com.sun.glass.ui.Application,tw.ed.beans.GuessNumBean"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="guessnum" class="tw.ed.beans.GuessNumBean" scope='application' />
<%
	String op = request.getParameter("op");
	HashMap<String, String> info = new HashMap<>();
	if(op != null){
		String op3 = (op.equals("3"))?"selected":"";
		String op4 = (op.equals("4"))?"selected":"";
		String op5 = (op.equals("5"))?"selected":"";
		String placeHolder = "請輸入"+op+"個數字";
		info.put("op3", op3);info.put("op4", op4);info.put("op5", op5);
		info.put("placeHolder", placeHolder);
	}else{
		String placeHolder = "請選擇難度";
		info.put("placeHolder", placeHolder);
	}
	pageContext.setAttribute("info", info);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<title>猜數字</title>
</head>
<body>
<div data-role="page">
	<div data-role="header">
		<h1>猜數字</h1>
	</div>
	<div data-role="main" class="ui-content">
		<form>
			<div class="ui-block-a">
				<select name="op" id="op" >
					<option value="3" ${info["op3"]}>3</option>
					<option value="4" ${info["op4"]}>4</option>
					<option value="5" ${info["op5"]}>5</option>
			    </select>
			</div>
			<div>
				<input name="create" type="submit" value="create">
			</div>
			<div class="ui-block-a">
				<input class="form-control input-lg" placeholder='${info["placeHolder"]}' 
					type='text' name='guess' value='' />
			</div>
			<div class="ui-block-b">
				<input name="check" type="submit" data-inline="true" value="check">
				<input name="giveup" type="submit" data-inline="true" value="giveup">
			</div>
			<c:if test="${param.create != null}">
				<jsp:setProperty property="answer" name="guessnum" value="${param.op }" />
				<jsp:setProperty property="len" name="guessnum" value="${param.op }" />
			</c:if>
			<div class="ui-block-a">
				<c:if test="${param.check != null}">
					<jsp:setProperty property="guess" name="guessnum" value='${param.guess}'/>
					<jsp:setProperty property="result" name="guessnum" value='${param.guess}'/>
					<jsp:setProperty property="hist" name="guessnum" value='${param.guess}'/>
					<jsp:getProperty property="hist" name="guessnum"/>
				</c:if>
				<c:if test="${param.giveup != null}">
					<jsp:getProperty property="hist" name="guessnum"/>
					Answer is "<jsp:getProperty property="answer" name="guessnum"/>" !<br>
				</c:if>
				<h1>
					<jsp:getProperty property="gameStatus" name="guessnum"/>
				</h1>
			</div>			
		</form>
	</div>
</div>
</body>
</html>