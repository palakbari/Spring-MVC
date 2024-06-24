<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Integer a=(Integer)request.getAttribute("a");
  Integer b=(Integer)request.getAttribute("b");
%>
<h1>Addition=<%=a+b%></h1>

<h1>Subtraction=<%=a-b%></h1>

<h1>Multiplication=<%=a*b%></h1>

<h1>Division=<%=a/b%></h1>
</body>
</html>