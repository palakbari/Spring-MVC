<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Customer</title>
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
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-top: 0;
            font-size: 28px;
            color: #333;
        }
        form {
            text-align: center;
            margin-top: 20px;
        }
        input[type="number"],
        input[type="text"],
        input[type="submit"],
        button,
        a {
            display: block;
            width: calc(100% - 20px);
            padding: 15px 10px;
            margin: 10px auto;
            font-size: 18px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }
        input[type="number"]:focus,
        input[type="text"]:focus,
        input[type="submit"]:focus,
        button:focus,
        a:focus {
            outline: none;
            border-color: #007bff;
        }
        input[type="submit"],
        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover,
        button:hover {
            background-color: #0056b3;
        }
        a {
            text-decoration: none;
            color: #333;
            text-align: center;
            transition: color 0.3s ease;
        }
        a:hover {
            color: #007bff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Customer</h1>
        <form action="getCustomers">
            Enter Id: <input type="number" name="id" required>
            Enter Name: <input type="text" name="name" required>
            Enter Balance: <input type="number" name="balance" required>
            <button type="submit" class="button">Add Customer</button>
           	<button type="button" onclick="window.location.href='admin_menu.jsp'" class="button">Back to Admin Menu Page</button>
        </form>
    </div>
</body>
</html>
