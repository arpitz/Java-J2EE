<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="index.css"></link>
<title>Main Menu</title>
</head>
<body>
	<h2>Banking System</h2>
	<h5>Welcome <%= session.getAttribute("UserName") %></h5>
	<div class="main_menu">
		<a href="Account_Creation.jsp" name="create">Create Account</a>
		<a href="Transactions.jsp" name="transaction">Transaction</a>
		<a href="Display_Statement.jsp" name="display">Display Bank Statement</a>
		<a href="Authorize_credit_card.jsp" name="authorize">Authorize Credit Card Amount</a>
	</div>
</body>
</html>