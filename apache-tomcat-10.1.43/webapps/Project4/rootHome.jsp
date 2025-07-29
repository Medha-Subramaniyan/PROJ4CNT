<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Project 4 - Root Home</title>
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
        textarea {
            width: 100%;
            height: 150px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            font-family: monospace;
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
            background-color: #d4edda;
            border: 1px solid #c3e6cb;
            border-radius: 4px;
            color: #155724;
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
        <h1>Root User - Project 4</h1>
        
        <form action="RootServlet" method="post">
            <div class="form-group">
                <label for="sqlCommand">SQL Command:</label>
                <textarea id="sqlCommand" name="sqlCommand" placeholder="Enter your SQL command here..." required></textarea>
            </div>
            <button type="submit">Execute</button>
        </form>
        
        <% if (request.getAttribute("results") != null) { %>
            <div class="results">
                <h3>Results:</h3>
                <%= request.getAttribute("results") %>
            </div>
        <% } %>
        
        <% if (request.getAttribute("businessLogicTriggered") != null && (Boolean) request.getAttribute("businessLogicTriggered")) { %>
            <div class="alert">
                <strong>Business Logic Triggered!</strong> Supplier status has been updated due to shipment quantity >= 100.
            </div>
        <% } %>
        
        <% if (request.getAttribute("error") != null) { %>
            <div class="alert" style="background-color: #f8d7da; border-color: #f5c6cb; color: #721c24;">
                <strong>Error:</strong> <%= request.getAttribute("error") %>
            </div>
        <% } %>
    </div>
</body>
</html> 