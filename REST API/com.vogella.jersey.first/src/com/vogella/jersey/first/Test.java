package com.vogella.jersey.first;

import java.sql.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/xy2220")
public class Test {
	  private java.sql.Connection conn = null;
	  private java.sql.Statement stat = null;
	  private ResultSet result = null;
	
	// This method is called if TEXT_PLAIN is request
		  @GET
		  @Produces(MediaType.TEXT_PLAIN)
		  public String sayPlainTextHello() {
			  String rst="";
			  try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root","");
			stat=conn.createStatement();
		    result=stat.executeQuery("select * from Cus where Name= '"+"xy2220"+"'");
			rst="  "+result.getString(1)+"  "+result.getString(2)+"  "+result.getString(3);
			  }catch(Exception e){
				  System.out.println("There is an Exception.");
			  }
		    return rst;
		  }

		  // This method is called if XML is request
		  @GET
		  @Produces(MediaType.TEXT_XML)
		  public String sayXMLHello() {
			  String rst="";
			  try{
			Class.forName("com.mysql.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root","");

			stat=conn.createStatement();
		    result=stat.executeQuery("select * from Cus where Name= '"+"xy2220"+"'");
			rst="  "+result.getString(1)+"  "+result.getString(2)+"  "+result.getString(3);
			  }catch(Exception e){
				  System.out.println("There is an Exception.");
			  }
		    return "<?xml version=\"1.0\"?>" + "<hello>  "+ rst + "</hello>";
		  }

		  // This method is called if HTML is request
		  @GET
		  @Produces(MediaType.TEXT_HTML)
		  public String sayHtmlHello() {
			  String rst="";
			  try{
			Class.forName("com.mysql.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root","");

			stat=conn.createStatement();
		    result=stat.executeQuery("select * from Cus where Name= '"+"xy2220"+"'");
		    if(result.next())
			rst="  "+result.getString(1)+"   |   "+result.getString(2)+"   |   "+result.getString(3);
			  }catch(Exception e){
				  System.out.println("There is an Exception.");
			  }
		    return "<html> " + "<title>" + rst + "</title>"
		        + "<body><h1>" + rst + "</body></h1>" + "</html> ";
		  }

}
