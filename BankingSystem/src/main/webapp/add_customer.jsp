<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Customer</title>
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
        h1, h2, h3 {
            margin-top: 0;
            font-size: 28px;
            color: #333;
            margin-bottom: 20px;
        }
        form {
            margin-top: 20px;
            text-align: center;
        }
        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-group input[type="text"],
        .form-group input[type="number"],
        .form-group .button {
            width: calc(100% - 32px);
            padding: 15px;
            margin: 10px auto;
            font-size: 18px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
            display: block;
        }
        .form-group input[type="text"]:focus,
        .form-group input[type="number"]:focus,
        .form-group .button:focus {
            outline: none;
            border-color: #16a085;
        }
        .form-group .button {
            background-color: #17a2b8;
            color: #fff;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .form-group .button:hover {
            background-color: #138496;
        }
        .button-container {
            display: flex;
            flex-direction: column;
            align-items: stretch;
        }
        .button {
            padding: 15px;
            font-size: 18px;
            text-align: center;
            background-color: #17a2b8;
            color: #fff;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-bottom: 10px;
            width: 100%;
        }
        .button:hover {
            background-color: #138496; 
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Customer</h1>
        <form action="getCustomers">
            <div class="form-group">
                <label for="acc_no">Enter Account Number:</label>
                <input type="number" id="acc_no" name="acc_no" required>
            </div>
            <div class="form-group">
                <label for="name">Enter Account Holder Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="balance">Enter Balance:</label>
                <input type="number" id="balance" name="balance" required>
            </div>
            <button type="submit" class="button">Add Customer</button>
            <button type="button" onclick="window.location.href='admin_menu.jsp'" class="button">Back to Admin Menu Page</button>
        </form>
    </div>
</body>
</html>
