<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Login.jsp" method="post">
		<div>
			<label>UserName:</label>
			<input type="text" name="name"/>
		</div>
		<br>
		<div>
			<label>Password:</label>
			<input type="password" name="pass"/>
		</div>
		<br>
		<div>
			<input type="submit" value="Login" />
		</div>
	</form>
</body>
</html>