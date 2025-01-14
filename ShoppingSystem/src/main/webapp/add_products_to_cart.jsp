<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
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
            border-radius: 4px;
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
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover,
        button:hover {
            background-color: #45a049;
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
   <h3>Products List</h3>

    <table class="table table-bordered table-hover table-striped" style="width:100%">
        <tr class="table-success">
            <th>Product ID</th>
            <th>Name</th>
            <th>Cost</th>
            <th>Available Quantity</th>
            <th>Discount</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${list}">
            <tr>
                <td>${product.pro_id}</td>
                <td>${product.pro_name}</td>
                <td>${product.pro_price}</td>
                <td>${product.pro_quantity}</td>
                <td>${product.pro_discount}</td>
				<td>
	                <form action="getProductsFromCart">
        				<input type="hidden" name="pro_id" value="${product.pro_id}"/>
        				<input type="hidden" name="pro_name" value="${product.pro_name}"/>
        				<input type="hidden" name="pro_price" value="${product.pro_price}"/>
        				<input type="number" name="pro_quantity" value="0" min="1" max="${product.pro_quantity}" style="width: 80px"/>
        				<input type="hidden" name="pro_discount" value="${product.pro_discount}"/>
        				<input type="submit" value="Add to Cart" />       	
    	            </form>
				</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
