<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Project 4 - Accountant Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            margin-bottom: 30px;
            text-align: center;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }
        button {
            padding: 12px 24px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0056b3;
        }
        .results {
            margin-top: 30px;
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 4px;
            border-left: 4px solid #007bff;
        }
        .alert {
            margin-top: 20px;
            padding: 15px;
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            border-radius: 4px;
            color: #721c24;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        .logout {
            text-align: right;
            margin-bottom: 20px;
        }
        .logout a {
            color: #dc3545;
            text-decoration: none;
        }
        .logout a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="logout">
            <a href="authentication.html">Logout</a>
        </div>
        <h1>Accountant User - Project 4</h1>
        
        <form action="AccountantServlet" method="post">
            <div class="form-group">
                <label for="procedureOption">Select Stored Procedure:</label>
                <select id="procedureOption" name="procedureOption" required>
                    <option value="">Choose a stored procedure...</option>
                    <option value="1">Get The Sum Of All Parts Weights</option>
                    <option value="2">Get The Maximum Status Of All Suppliers</option>
                    <option value="3">Get The Total Number Of Shipments</option>
                    <option value="4">Get The Name Of The Job With The Most Workers</option>
                    <option value="5">List The Name And Status Of All Suppliers</option>
                </select>
            </div>
            <button type="submit">Execute</button>
        </form>
        
        <% if (request.getAttribute("results") != null) { %>
            <div class="results">
                <h3>Results:</h3>
                <%= request.getAttribute("results") %>
            </div>
        <% } %>
        
        <% if (request.getAttribute("error") != null) { %>
            <div class="alert">
                <strong>Error:</strong> <%= request.getAttribute("error") %>
            </div>
        <% } %>
    </div>
</body>
</html> 