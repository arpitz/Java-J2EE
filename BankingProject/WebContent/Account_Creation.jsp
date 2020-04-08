<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="index.css"></link>
<title>Account Creation</title>
</head>
<body>
	<h2>Account Creation Screen</h2>
	<h5>Welcome <%= session.getAttribute("UserName") %></h5>
	<form class="form form_acc_creation" action="newAccount" method="post">
		<div>
			<label>Name:</label>
			<input type="text" name="name"/>
		</div>
		<br>
		<div>
			<label>DOB:</label>
			<input type="text" name="dob"/>
		</div>
		<br>
		<div>
			<label style="position: absolute">Address:</label>
			<textarea rows="5" name="address"></textarea>
		</div>
		<br>
		<div>
			<label>Email ID:</label>
			<input type="text" name="email"/>
		</div>
		<br>
		<div>
			<label>Type of account:</label>
			<select id="account_types" name="accountTypes">
			  <option value="savings">Savings Bank Account</option>
			  <option value="current">Current Account</option>
			  <option value="recurring">Recurring Account</option>
			</select>
		</div>
		<br>
		<br>
		<div>
			<input type="submit" value="Create Account" />
		</div>
		<br>
		<h4><%= session.getAttribute("message") %></h4>
	</form>
</body>
</html>