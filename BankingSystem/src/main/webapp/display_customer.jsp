<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Customers</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }
        table {
            width: 95%;
            border-collapse: collapse;
            margin: 20px auto;
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }
        th {
            background-color: #17a2b8;
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
            padding: 15px;
            margin: 30px;
            font-size: 16px;
            background-color: #17a2b8;
            color: #fff;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        button:hover, a:hover {
            background-color: #138496;
        }
    </style>
</head>
<body>
    <form action="showCustomers">
        <table>
            <tr>
                <th>Customer Account Number</th>
                <th>Customer Name</th>
                <th>Customer Balance</th>
            </tr>
            <c:forEach var="customer" items="${list}">
                <tr>
                    <td>${customer.acc_no}</td>
                    <td>${customer.name}</td>
                    <td>${customer.balance}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="admin_menu.jsp">Back to Admin Menu Page</a>
    </form>
</body>
</html>
