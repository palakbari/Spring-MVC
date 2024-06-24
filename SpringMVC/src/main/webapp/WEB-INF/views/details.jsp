<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Details</h1>
<% String n =(String)request.getAttribute("name");%>
<h3>Name: <%=n%></h3>
<% String a =(String)request.getAttribute("address");%>
<h3>Address: <%=a%></h3>
</body>
</html>