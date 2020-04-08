<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="index.css"></link>
<title>Authorize credit card</title>
</head>
<body>
	<h2>Authorize Credit Card Transaction</h2>
	<h5>Welcome <%= session.getAttribute("UserName") %></h5>
	<form class="form form_acc_creation" action="authorizeCreditCard" method="post">
		<div>
			<label>Name:</label>
			<input type="text" name="name"/>
		</div>
		<br>
		<div>
			<label>Card Number:</label>
			<input type="text" name="cardNumber"/>
		</div>
		<br>
		<div>
			<label>CVV2:</label>
			<input type="text" name="cvv2"/>
		</div>
		<br>
		<div>
			<label>Amount:</label>
			<input type="text" name="amount"/>
		</div>
		
		<br>
		<br>
		<div>
			<input type="submit" value="Authorize" />
		</div>
		<br>
		<h4><%= session.getAttribute("message") %></h4>
	</form>
</body>
</html>