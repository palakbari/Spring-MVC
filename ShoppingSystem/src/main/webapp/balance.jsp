<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h2>Current Balance: ${balance}</h2>
    <table>
        <tr>
            <td>
                <form action="addBalance" method="post">
                    Enter amount: <input type="number" name="amount" required>
                    <button type="submit">Add Balance</button>
                </form>
            </td>
        </tr>
    </table>
    <p>${result != null ? result : ""}</p>
    <form action="customerHome" method="post">
        <button type="submit">Return Home</button>
    </form>
</body>


</html>