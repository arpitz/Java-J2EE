package com.edureka.Client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Client {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(){
		return "Hello from REST Web Services !!";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String jsonResponse(){
		return "{ name: 'Arpit', age: 30, occupation: 'service'}";
	}

}
