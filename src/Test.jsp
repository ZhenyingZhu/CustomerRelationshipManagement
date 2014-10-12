<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK" %>

<%@ page import="java.sql.*" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">

<title> Test to Connect MySQL</title>
</head>

<body>

<%

Class.forName("com.mysql.jdbc.Driver");

Connection conn=null;//DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");

//Statement stat=conn.createStatement();

ResultSet rs=null;//=stat.executeQuery("select * from CusInfo");


String uName="";
String error_msg="";

try {
	uName=request.getParameter("Name");
	
	
	
	if(uName!=null){
		
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
		Statement stat=conn.createStatement();
		rs=stat.executeQuery("select * from CusInfo where Name='" + uName +"'");
		
		if (rs.next()){
			session.setAttribute("Name",uName);
			response.sendRedirect("CusSucc.jsp");
		
     }
		else
		response.sendRedirect("Test.jsp");
  }
}
catch (Exception e)
{
    error_msg = e.getMessage();
    if (conn != null)
    {
        conn.close();
    }
}

%>
</body>



<body>
<h3>Home Page</h3>
          </head>
    
           <form ><br>
          ID £º<input type="Text" name="Name"  ></input><br>
              <br>
              
<a href="Agent.jsp"><input type="button" VALUE="I am Agent"></a>    <a href="Customer.jsp"><input type="button" VALUE="I am Customer"></a> <br><br>
<a href="Registration.jsp"><input type="button" VALUE="Sigh Up"></a>
</form>
         
</body>


</html>