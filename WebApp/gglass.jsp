<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ page import="example.DynamoDB"%>
<%@ page import="com.amazonaws.services.dynamodbv2.model.*"%>
<%@ page import="com.amazonaws.AmazonServiceException"%>
<%@ page import="example.Test_jedis" %>


<title>Google Glass</title>
</head>
<body>

<%


String color="";
String description="";
String link="";
String sku="";
String size="";
String figure="";
String model="";


GetItemResult result=null;

try{
result=DynamoDB.getBook("107", "ProductCatalog");
}
catch (AmazonServiceException ase) {
    System.err.println(ase.getMessage());
}  

color=DynamoDB.getAttribute("Color",result.getItem());
description=DynamoDB.getAttribute("Description",result.getItem());
link=DynamoDB.getAttribute("Link",result.getItem());
sku=DynamoDB.getAttribute("SKU",result.getItem());
size=DynamoDB.getAttribute("Size",result.getItem());
figure=DynamoDB.getAttribute("Figure",result.getItem());
model=DynamoDB.getAttribute("Model",result.getItem());


Test_jedis jedis= new Test_jedis();

String sessionID=session.getAttribute("sessionId").toString();
jedis.set("liang",sku,sessionID);

String key=jedis.encode("liang",sku,sessionID);
String key2=jedis.encode("liang",sku);

System.out.println(sessionID+"   "+sku+"  "+jedis.getAttribute(key));
System.out.println(sku+"  "+jedis.getAttribute(key2));

%>
<center>
<table>
<br>

<tr>
<td width="350">Color:  <%=color %></td>
</tr>

<tr>
<td width="350">Description:  <%=description %></td>
</tr>

<tr>
<td width="350">Link:  <%=link %></td>
</tr>

<tr>
<td width="350">SKU:  <%=sku %></td>
</tr>

<tr>
<td width="350">Size:  <%=size %></td>
</tr>

<tr>
<td width="350">Figure:  <%=figure %></td>
</tr>

<tr>
<td width="350">Model:  <%=model %></td>
</tr>

</table>
<a href=<%=link %>><b><font style="font-weight:bold" face="Times New Roman" size="3"></font></b>Video</a>
</center>
</body>
</html>
