<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK" %>


<%@ page import="java.sql.*" %>
<%@ page language="java" import="java.util.List" %>
<%@ page import="example.SimpleQueueService, example.Test, example.MessageQueue"%>


<body>

<%

Class.forName("com.mysql.jdbc.Driver");

Connection conn=null;

ResultSet rs=null;


String Cus="";
String error_msg="";
String Agent="";
String Model="";
String Text="";

try {
	
	Cus=request.getParameter("Customer");
	Agent=request.getParameter("Agent");
	Model=request.getParameter("Model");
	Text=request.getParameter("TextSummary");
	
	if(Cus!=null){
		
		 MessageQueue queue=new MessageQueue("MyQueue2");
		 session.setAttribute("Queue",queue);
		 String myQueueUrl=queue.intialQueue();
		 session.setAttribute("QueueUrl",myQueueUrl);
		 String msm=Cus+" "+Agent+" "+Model+" "+Text;
		  queue.send(myQueueUrl,msm);
	
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root","");
		Statement stat=conn.createStatement();
		   
		String query="update Contact Set Cus='"+Cus+"', Agent='"+Agent+"', Model='"+Model+"',TextSum='"+Text+"' WHERE Cus='" +Cus+"' AND Agent='"+Agent+"'";	
	
	    stat.executeUpdate(query);
	 
		response.sendRedirect("ConUpdateSucc.jsp");

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
<center><h3>Update Contact History</h3></center>
          </head>
    <center>
           <form>
           
       
          Customer ��<input type="Text" name="Customer"  ></input><br><br>
      
          Agent �� &nbsp; &nbsp; <input type="Text" name="Agent"  ></input><br><br> 
            
          Model ��   &nbsp; &nbsp; <input type="Text" name="Model"  ></input><br><br>
          
          Text ��    &nbsp; &nbsp; &nbsp;&nbsp; <input type="Text" name="TextSummary"  ></input><br><br>
                     
                     
          <input type="submit" name="submit"></input>
          </form>       
          
            </center>
</body>


</html>