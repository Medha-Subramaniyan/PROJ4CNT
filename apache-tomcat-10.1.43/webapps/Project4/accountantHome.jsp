<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accountant Home - Project 4</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        .user-info {
            background-color: #e9ecef;
            padding: 15px;
            border-radius: 4px;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: bold;
        }
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
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
        .error {
            background-color: #f8d7da;
            color: #721c24;
            padding: 10px;
            border-radius: 4px;
            margin-bottom: 20px;
        }
        .results {
            margin-top: 20px;
        }
        .results table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }
        .results th, .results td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        .results th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        .note {
            background-color: #fff3cd;
            color: #856404;
            padding: 10px;
            border-radius: 4px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="logout">
            <a href="authentication.html">Logout</a>
        </div>
        
        <h1>Accountant Home - Project 4</h1>
        
        <div class="user-info">
            <strong>User:</strong> ${sessionScope.username} (${sessionScope.userType})
        </div>
        
        <div class="note">
            <strong>Note:</strong> Accountant users can execute stored procedures on the project4 database.
        </div>
        
        <% if (request.getAttribute("error") != null) { %>
            <div class="error">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>
        
        <form action="AccountantServlet" method="post">
            <div class="form-group">
                <label for="procedureOption">Select Stored Procedure:</label>
                <select id="procedureOption" name="procedureOption" required>
                    <option value="">Choose a procedure...</option>
                    <option value="1">1. Get The Sum Of All Parts Weights</option>
                    <option value="2">2. Get The Maximum Status Of All Suppliers</option>
                    <option value="3">3. Get The Total Number Of Shipments</option>
                    <option value="4">4. Get The Name Of The Job With The Most Workers</option>
                    <option value="5">5. List The Name And Status Of All Suppliers</option>
                </select>
            </div>
            <button type="submit">Execute Procedure</button>
        </form>
        
        <% if (request.getAttribute("results") != null) { %>
            <div class="results">
                <h3>Procedure Results:</h3>
                <%= request.getAttribute("results") %>
            </div>
        <% } %>
    </div>
</body>
</html> 