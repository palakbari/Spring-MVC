<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Banking System</title>
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
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            margin-top: 0;
            font-size: 28px;
            color: #333;
            margin-bottom: 20px;
        }
        form {
            text-align: center;
            margin-top: 20px;
        }
        input[type="text"],
        input[type="password"],
        input[type="submit"] {
            display: block;
            width: 100%;
            padding: 15px 10px;
            margin: 10px auto;
            font-size: 18px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }
        input[type="text"]:focus,
        input[type="password"]:focus,
        input[type="submit"]:focus {
            outline: none;
            border-color: #16a085;
        }
        input[type="submit"] {
            background-color: #17a2b8; 
            color: #fff;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #138496; 
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome</h1>
        <form action="home">
            Enter Username: <input type="text" name="username" required><br><br>
            Enter Password: <input type="password" name="password" required><br><br>
            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>
