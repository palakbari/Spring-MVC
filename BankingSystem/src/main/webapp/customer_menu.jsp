<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Page</title>
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
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            margin-top: 0;
            font-size: 28px;
            color: #333;
            margin-bottom: 20px;
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
		    width: 100%;
		    margin-bottom: 10px; 
		}
		
		.button:hover {
		    background-color: #138496; 
		}
		
		.back-button {
		    margin-top: 30px;
		    text-align: center;
		}
		
		.back-button button, .back-button a {
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
                <button onclick="form.action='deposit'" class="button">Deposit Amount</button>
                <button onclick="form.action='withdraw'" class="button">Withdraw Amount</button>
                <button onclick="form.action='view'" class="button">View Balance</button>
            	<button type="button" onclick="window.location.href='index.jsp'" class="button">Back to Index Page</button>
            </form>
        </div>
    </div>
</body>
</html>
