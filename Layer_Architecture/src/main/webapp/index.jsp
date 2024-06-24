<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Data</title>
</head>
<body>
	<h2>Hello World!</h2>
		<body>
			<form action="insert">
				Enter Laptop id:
				<input type = "text" name = "id">
				<br>
				Enter Laptop name:
				<input type = "text" name = "name">
				<br> 
				Enter Laptop cost:
				<input type = "text" name = "cost">
				<br>
				<input type = "submit" value = "Add Details">
			</form>
			<form action="showdata">
				<input type = "submit" value = "Show Details">
			</form>
		</body>
</body>
</html>
