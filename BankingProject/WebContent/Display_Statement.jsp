<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.edureka.Model.Record" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="index.css"></link>
<title>Display Statement</title>
</head>
<body>
	<h2>Display Statement</h2>
	<h5>Welcome <%= session.getAttribute("UserName") %></h5>
	<form class="form_disp" action="display" method="post">
		<div>
			<label>Date Range:</label>
		</div>
		<br>
		<div>
			<label>From:</label>
			<input type="text" name="from"/>
			
			<label>To:</label>
			<input type="text" name="to"/>
			
			<input type="submit" value="Display" />
		</div>
	</form>
	<br><br><br>
	
	<table>
	<thead>
		<tr>
	      <th>Serial No.</th><th>Date</th><th>Description</th><th>Cheque No</th><th>Withdraw</th><th>Deposit</th><th>Available Balance</th>
	  </tr>
	</thead>
	  <tbody>
		  <%
		  	int count = 1;
		  	List<Record> recordsList = (List<Record>)session.getAttribute("records");
		  	if(recordsList != null){
				for (Record record : recordsList) { %>
					<tr>
						<td><%= count++ %>.</td>
						<td><%= record.getTrans_date() %></td>
						<td><%= record.getDescription() %></td>
						<% if(record.getCheque_no() == null){ %>
							<td>&nbsp;</td>
						<% } else { %>
							<td><%= record.getCheque_no() %></td>
						<% } %>
						<% if(record.getWithdraw() == null){ %>
							<td>&nbsp;</td>
						<% } else { %>
							<td><%= record.getWithdraw() %></td>
						<% } %>
						<% if(record.getDeposit() == null){ %>
							<td>&nbsp;</td>
						<% } else { %>
							<td><%= record.getDeposit() %></td>
						<% } %>
						<td><%= record.getBalance() %></td>
					</tr>
				<% }
		  	} else { %>
		  		
		  		<p>Enter the dates to get the transaction records.</p>
		  <% }
		  %>
		  
	  </tbody>
	</table>
</body>
</html>