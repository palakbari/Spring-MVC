<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Result</title>
</head>
<body>
    <h3>
        <% 
            Integer result = (Integer) request.getAttribute("result");
            String operation = (String) request.getAttribute("operation");
            if (result != null && operation != null) { 
                switch (operation) { 
                    case "add": 
                        out.print("Addition: " + result);
                        break;
                    case "sub": 
                        out.print("Subtraction: " + result);
                        break;
                    case "mul": 
                        out.print("Multiplication: " + result);
                        break;
                    case "div": 
                        out.print("Division: " + result);
                        break;
                    default: 
                        out.print("Invalid operation.");
                } 
            } else { 
                out.print("No result available."); 
            } 
        %>
    </h3>
</body>
</html>
