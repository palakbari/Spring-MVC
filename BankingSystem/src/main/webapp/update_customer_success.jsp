<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            margin-top: 0;
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }
        button, a {
            display: inline-block;
            padding: 15px;
            margin: 10px;
            font-size: 18px;
            text-align: center;
            background-color: #17a2b8;
            color: #fff;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            margin-bottom: 10px;
            width: 80%;
            transition: background-color 0.3s ease;
        }
        button:hover, a:hover {
            background-color: #138496;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Row updated successfully!!</h2>
        <form>
	        <a href="update_customer.jsp">Back to Update Customer Page</a>
        </form> 
    </div>
</body>
</html>
