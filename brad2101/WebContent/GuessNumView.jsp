<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form action="GuessNumController">
			<div class="ui-block-a">
				<select name="op" id="op" value='4'>
			      <option value="3" ${op3}>3</option>
			      <option value="4" ${op4}>4</option>
			      <option value="5" ${op5}>5</option>
			    </select>
			</div>
			<div>
				<input name="create" type="submit" value="create">
			</div>
			<div class="ui-block-a">
				<input class="form-control input-lg" type='text' name='guess' value='' />
			</div>
			<div>
				<input name="check" type="submit" data-inline="true" value="Check">
				<input name="giveup" type="submit" data-inline="true" value="giveup">
			</div>
			<span style='font-size:22px;color:orange'></span><br>
			${hist}
		</form>
	</div>
</div>
</body>
</html>