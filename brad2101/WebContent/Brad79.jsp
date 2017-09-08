<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Test" 
	enctype='multipart/form-data' method='post' >
	<input type='file' name='upload'>
	<input type='text' name='upload' value='text'>
	<input type='checkbox' name='upload' value='c1'>
	<input type='checkbox' name='upload' value='c1'>
	<input type='checkbox' name='upload' value='c1'>
	<input type='radio' name='upload' value='d'>
	<input type='submit' value='upload'>
	<hr/>
	
	<input type='file' name='upload2'>
	<input type='text' name='upload2' value='text'>
	<input type='checkbox' name='upload2' value='c2'>
	<input type='checkbox' name='upload2' value='c2'>
	<input type='checkbox' name='upload2' value='c2'>
	<input type='radio' name='upload2' value='d'>
	
	
	<input type='submit' value='upload2'>
</form>

</body>
</html>