package com.vogella.jersey.first;

import java.sql.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/text")
public class Text {
	  private java.sql.Connection conn = null;
	  private java.sql.Statement stat = null;
	  private ResultSet result = null;
		  // This method is called if HTML is request
		  @GET
		  @Produces(MediaType.TEXT_HTML)
		  @Path("{customer}/{agent}")
		  public String sayHtmlHello(@PathParam("customer") String customer,@PathParam("agent") String agent) {
			  String rst="";
			  try{
			Class.forName("com.mysql.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root","");

			stat=conn.createStatement();
		    result=stat.executeQuery("select Model, TextSum from Contact where (Cus='"+customer+"' AND Agent='"+agent+"')");
		    if(result.next())
			rst=customer+"   |   "+agent+"   |   "+result.getString(1)+"   |   "+result.getString(2);
			  }catch(Exception e){
				  System.out.println("There is an Exception.");
			  }
		    return "<html> " + "<title>" + rst + "</title>"
		        + "<body><h1>" + rst + "</body></h1>" + "</html> ";
		  }

}
