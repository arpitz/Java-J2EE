<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="index.css"></link>
<title>Banking System</title>
</head>
<body>
	<h2>Banking System</h2>
	<form class="form form_login" action="LoginFilter" method="post">
		<div>
			<label>UserName:</label>
			<input type="text" name="user"/>
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
		<br>
		<%
			String invalidLogin = (String) session.getAttribute("message");
			if(invalidLogin != null){ 
		%>
				<h4 style="text-align: center"><%= session.getAttribute("message") %></h4>
		<%
			}
		%>	
	</form>
</body>
</html>