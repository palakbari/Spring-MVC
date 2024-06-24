<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Arithmetic Operations</title>
    <script>
        function performOperation(operation) 
        {
            var form = document.getElementById("mathForm");
            var a = parseFloat(form.a.value);
            var b = parseFloat(form.b.value);

            if (isNaN(a) || isNaN(b)) 
            {
                alert("Please enter valid numbers.");
                return;
            }

            form.action = operation;
            form.submit();
        }
    </script>
</head>
<body>
    <h2>Arithmetic Operations</h2>
    <form id="mathForm" method="post">
        Enter first number:
        <input type="text" name="a" required/><br>
        Enter second number:
        <input type="text" name="b" required/><br>
        <button type="button" onclick="performOperation('add')">Addition</button>
        <button type="button" onclick="performOperation('sub')">Subtraction</button>
        <button type="button" onclick="performOperation('mul')">Multiplication</button>
        <button type="button" onclick="performOperation('div')">Division</button>
    </form>
</body>
</html>
