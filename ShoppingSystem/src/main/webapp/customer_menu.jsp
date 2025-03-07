<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Menu</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }
        h2 {
            margin-top: 0;
            font-size: 28px;
            color: #333;
            text-align: center;
        }
        .button-container {
            margin-top: 30px;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .button {
            flex: 0 0 48%;
            padding: 15px;
            font-size: 18px;
            text-align: center;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .button:hover {
            background-color: #0056b3;
        }
        .back-button {
            margin-top: 30px;
            text-align: center;
        }
        .back-button button, .back-button a {
            display: inline-block;
            vertical-align: middle;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #343a40;
            color: #fff;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        .back-button button:hover, .back-button a:hover {
            background-color: #212529;
        }
        .back-button a {
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Select your Option:</h2>
        <div class="button-container">
            <form action="customer">
                <button onclick="form.action='addProductsToCart'" class="button">Add Product(s) To Cart</button>
                <button onclick="form.action='displayProductsFromCart'" class="button">Display Cart</button>
                <button onclick="form.action='displayandpayBill'" class="button">Bill</button>
                <button onclick="form.action='addBalance'" class="button">Balance in Wallet</button>
            </form>
        </div>
        <div class="back-button">
            <form>
                <button type="button" onclick="window.location.href='index.jsp'" class="button">Back to Login Page</button>
            </form>
        </div>
    </div>
</body>
</html>
