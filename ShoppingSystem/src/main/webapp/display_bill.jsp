<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
</head>
<body>
	<h4>==Thank You==</h4>
        <table border = 1>
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
	<h4>TOTAL AMOUNT OF ALL ITEMS :  ${Amount_list} </h4>
	<h4>TOTAL AMOUNT TO BE PAID:  ${Discount_list} </h4>
	<h4>SAVED AMOUNT :  ${Saved_list} </h4>
	
	<form action="payment">
		<input type="hidden" name="discount_amt" value="${Discount_list}"/>
		<input type="submit" value="Move to Payment"/> 
	</form> 
	
</body>
</html>