<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK" %>


<%@ page import="java.sql.*" %>
<%@ page language="java" import="java.util.List" %>
<%@ page import="example.SimpleQueueService, example.Test, example.MessageQueue"%>


<body>

<%

Class.forName("com.mysql.jdbc.Driver");

Connection conn=null;

ResultSet rs=null;


String uName="";
String error_msg="";
String uPhone="";
String uEmail="";

try {
	
	uName=request.getParameter("Name");
	uPhone=request.getParameter("Phone");
	uEmail=request.getParameter("Email");
	
	if(uName!=null){
		
		 MessageQueue queue=new MessageQueue("MyQueue1");
		 session.setAttribute("Queue",queue);
		 String myQueueUrl=queue.intialQueue();
		 session.setAttribute("QueueUrl",myQueueUrl);
		 String msm=uName+" "+uPhone+" "+uEmail;
		  queue.send(myQueueUrl,msm);
	
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root","");
		Statement stat=conn.createStatement();
		   
		String query="insert into Agent values ('"+uName+"', '"+ uPhone +"', '" +uEmail +"')";	
	
	    stat.executeUpdate(query);
	 
		response.sendRedirect("AgentCreateSucc.jsp");

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
<center><h3>New Agent</h3></center>
          </head>
    <center>
           <form>
           
          
           
          Name £º<input type="Text" name="Name"  ></input><br><br>
           
         
          Phone £º<input type="Text" name="Phone"  ></input><br><br>

            
          Email £º<input type="Text" name="Email"  ></input><br><br>
                     
          <input type="submit" name="submit"></input>
          </form>       
          
            </center>
</body>


</html>