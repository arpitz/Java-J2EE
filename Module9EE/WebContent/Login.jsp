<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

	Connection con;
	PreparedStatement pst;
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		System.out.println("Driver Loaded");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		System.out.println("Connection created");
		pst = con.prepareStatement("select * from user_pass");
		ResultSet rs = pst.executeQuery();
		
		String user_id = "", password = "";
		
		while(rs.next()){
			user_id = rs.getString(1);
			password = rs.getString(2);
			System.out.println("user : " + user_id +  " password : " + password);
		}
		if(user_id.equals(request.getParameter("name")) && password.equals(request.getParameter("pass"))){
			out.print("Valid User ...");
		} else {
			out.print("Invalid user id/password..");
		%>
			<jsp:include page="Index.jsp" />
		<%}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

%>
</body>
</html>