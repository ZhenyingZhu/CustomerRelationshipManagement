package com.vogella.jersey.first;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;


@Path("/customer")
public class CustomersResource {
	
	 // Allows to insert contextual objects into the class,
	  // e.g. ServletContext, Request, Response, UriInfo
	  @Context
	  UriInfo uriInfo;
	  @Context
	  Request request;
	  
	  
	  private java.sql.Connection conn = null;
	  private java.sql.Statement stat = null;
	  private ResultSet result = null;
	  
	 // @GET
	//  @Produces(MediaType.TEXT_XML)
	  @Path("{name}")
	  public CustomerResource getCustomerBrowser(@PathParam("name") String name) {
	    return new CustomerResource(uriInfo, request, name);
	  }
	  
	  @POST
	  @Produces(MediaType.TEXT_HTML)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public void newCustomer(@FormParam("name") String name,
	      @FormParam("phone") String phone,
	      @FormParam("email") String email,
	      @Context HttpServletResponse servletResponse) throws IOException {
	    Customer customer= new Customer(name, phone, email);
	    try{
			Class.forName("com.mysql.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root","");

			stat=conn.createStatement();
		    stat.executeUpdate("insert into Cus values ('"+customer.getName()+"', '"+ customer.getPhone() +"', '" +customer.getEmail()+"')");
			  }catch(Exception e){
				  System.out.println("There is an Exception.");
			  }
	  //  servletResponse.sendRedirect("../create_todo.html");
	  }
	  
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public List<Customer> getCustomersBrowser() {
	    List<Customer> Customers = new ArrayList<Customer>();
	    ResultSet result=null;
		  try{
				Class.forName("com.mysql.jdbc.Driver");

				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root","");

				stat=conn.createStatement();
			    result=stat.executeQuery("select * from Cus");  
			    	while(result.next())
			    	   Customers.add(new Customer(result.getString(2),result.getString(3),result.getString(1)));
				  }catch(Exception e){
					  System.out.println("There is an Exception.");
				  }
	    return Customers;
	  }

	  // Return the list of todos for applications
	  @GET
	  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public List<Customer> getCustomers() {
		  List<Customer> Customers = new ArrayList<Customer>();
		    ResultSet result=null;
			  try{
					Class.forName("com.mysql.jdbc.Driver");

					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root","");

					stat=conn.createStatement();
				    result=stat.executeQuery("select * from Cus");  
				    	while(result.next())
				    	   Customers.add(new Customer(result.getString(2),result.getString(3),result.getString(1)));
					  }catch(Exception e){
						  System.out.println("There is an Exception.");
					  }
		    return Customers;
	  }
     
	  
		  // This method is called if HTML is request
	/*	  @GET
		  @Produces(MediaType.TEXT_HTML)
		  @Path("{name}")
		  public String sayHtmlHello(@PathParam("name") String name) {
			  String rst="";
			  try{
			Class.forName("com.mysql.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root","");

			stat=conn.createStatement();
		    result=stat.executeQuery("select * from Cus where Name= '"+name+"'");
		    if(result.next())
			rst=result.getString(1)+"   |   "+result.getString(2)+"   |   "+result.getString(3);
			  }catch(Exception e){
				  System.out.println("There is an Exception.");
			  }
		    return "<html> " + "<title>" + rst + "</title>"
		        + "<body><h1>" + rst + "</body></h1>" + "</html> ";
		  }
		  */

}
