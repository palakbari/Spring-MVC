<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Products</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px auto;
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #e2e2e2;
        }
        button, a {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            font-size: 16px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        button:hover, a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <form action="showCustomers">
        <table>
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Product Quantity</th>
                <th>Product Discount</th>
            </tr>
            <c:forEach var="product" items="${list}">
                <tr>
                    <td>${product.pro_id}</td>
                    <td>${product.pro_name}</td>
                    <td>${product.pro_price}</td>
                    <td>${product.pro_quantity}</td>
                    <td>${product.pro_discount}</td>
                </tr>
            </c:forEach>
        </table>
        <button type="button" onclick="window.location.href='add_product.jsp'" class="button">Back to Add Product Page</button>
        <button type="button" onclick="window.location.href='add_products_to_cart.jsp'" class="button">Back to Add Product To Cart Page</button>
    </form>
</body>
</html>
