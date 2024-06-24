<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="in.microsoft.pojo.Customer" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Details</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
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
            color: #333;
            margin-top: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Customer Details</h1>
        <% 
            List<Customer> customers = (List<Customer>)request.getAttribute("customers");
            for(Customer customer : customers) { 
        %>
        <div class="customer-details">
            <p><span class="customer-label">Account Number:</span> <%= customer.getAcc_no() %></p>
            <p><span class="customer-label">Name:</span> <%= customer.getName() %></p>
            <p><span class="customer-label">Balance:</span> <%= customer.getBalance() %></p>
        </div>
        <% } %>
    </div>
</body>
</html>
