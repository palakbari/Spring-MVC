<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ERROR</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f8f9fa;
    }
    .container {
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    h1 {
        text-align: center;
        margin-top: 0;
        font-size: 28px;
        color: #333;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>ERROR</h1>
        <script type="text/javascript">
            var errorMessage = "${errorMessage}";
            alert("An error occurred. Product NOT Available.");
            window.location.href = "add_products_to_cart.jsp"; 
        </script>
    </div>
</body>
</html>
