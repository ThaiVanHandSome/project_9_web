<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Login</title>
</head>
<body>
	<form action="login" method="Post">
		Name: 
		<input type="text" name="username"> 
		<br /> 
		Pass: 
		<input type="password" name="password" /> 
			<input type="submit" value="login"/>
	</form>
</body>
</html>