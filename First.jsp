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

Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");

Statement stat=conn.createStatement();

ResultSet rs=stat.executeQuery("select * from CusInfo");

while (rs.next())
{	
%>
<table>
<tr>

<td width="20"> <%=rs.getString(1) %></td>

</tr>
<tr>
<td width="20"> <%=rs.getString(2) %></td>
</tr>

<tr>
<td width="20"> <%=rs.getString(3) %></td>
</tr>
</table>


<%
}
%>
</body>
</html>

