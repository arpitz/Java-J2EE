<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="index.css"></link>
<title>Tansactions</title>
</head>
<body>
	<h2>Perform Debit or Credit operations</h2>
	<h5>Welcome <%= session.getAttribute("UserName") %></h5>
	<form class="form form_trans" action="transact" method="post">
		<div>
			<label>Account Number:</label>
			<input type="text" name="acc_number"/>
		</div>
		<br>
		<div>
			<label>Amount:</label>
			<input type="text" name="amount"/>
		</div>
		<br>
		<div>
			<input type="submit" name="debitFrom" value="Debit From" />
			<input type="submit" name="creditTo" value="Credit To" />
		</div>
		<br>
		<h4><%= session.getAttribute("message") %></h4>
	</form>
</body>
</html>