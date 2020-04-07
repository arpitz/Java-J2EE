<%@page import="javax.ws.rs.core.MediaType"%>
<%@page import="javax.ws.rs.core.UriBuilder"%>
<%@page import="javax.ws.rs.client.WebTarget"%>
<%@page import="javax.ws.rs.client.Client"%>
<%@page import="javax.ws.rs.client.ClientBuilder"%>
<%@page import="org.glassfish.jersey.client.ClientConfig"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ClientConfig con = new ClientConfig();
		Client c = ClientBuilder.newClient(con);
		WebTarget target = c.target(UriBuilder.fromUri("http://localhost:8080/Module14EEWebServiceREST"));
		
		String str = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		
		out.print(str);
		
		out.print("<br><br>");
		
		String str1 = target.path("rest").path("hello").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		out.print(str1);
	%>
</body>
</html>