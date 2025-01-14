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
   <h2>Products in Cart:</h2>
   <c:if test="${not empty list}">
        <table>
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Product Quantity</th>
                <th>Product Discount</th>
            </tr>
            <c:forEach var="cart" items="${list}">
                <tr>
                    <td>${cart.pro_id}</td>
                    <td>${cart.pro_name}</td>
                    <td>${cart.pro_price}</td>
                    <td>${cart.pro_quantity}</td>
                    <td>${cart.pro_discount}</td>
                </tr>
            </c:forEach>
        </table>
	</c:if>
<c:if test="${empty list}">
<h4>Cart is Empty</h4>
</c:if>
<form action="addProductsToCart">
	<button type="submit">Add Product to Cart</button>
</form>
</body>
</html>
