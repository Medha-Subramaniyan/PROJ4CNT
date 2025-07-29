/*
 * Project 4 - CNT 4714
 * RootServlet.java
 * 
 * This servlet handles root-level SQL commands. The root user has
 * full privileges on the project4 database and can trigger business
 * logic when shipment quantities >= 100.
 * 
 * Author: [Your Name]
 * Course: CNT 4714
 * Date: [Current Date]
 */

package com.project4;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class RootServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String sqlCommand = request.getParameter("sqlCommand");
        boolean businessLogicTriggered = false;
        
        try {
            // Load root properties for project4 connection
            Properties props = new Properties();
            props.load(getServletContext().getResourceAsStream("/WEB-INF/conf/root.properties"));
            
            // Load JDBC driver
            Class.forName(props.getProperty("driver"));
            
            // Connect to project4 as root
            try (Connection conn = DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("user"),
                    props.getProperty("password"))) {
                
                // Execute SQL command
                try (Statement stmt = conn.createStatement()) {
                    
                    String trimmedSQL = sqlCommand.trim().toLowerCase();
                    
                    if (trimmedSQL.startsWith("select")) {
                        // Handle SELECT statements
                        try (ResultSet rs = stmt.executeQuery(sqlCommand)) {
                            ResultSetMetaData metaData = rs.getMetaData();
                            int columnCount = metaData.getColumnCount();
                            
                            StringBuilder resultHtml = new StringBuilder();
                            resultHtml.append("<table border='1'>");
                            
                            // Add header row
                            resultHtml.append("<tr>");
                            for (int i = 1; i <= columnCount; i++) {
                                resultHtml.append("<th>").append(metaData.getColumnName(i)).append("</th>");
                            }
                            resultHtml.append("</tr>");
                            
                            // Add data rows
                            while (rs.next()) {
                                resultHtml.append("<tr>");
                                for (int i = 1; i <= columnCount; i++) {
                                    resultHtml.append("<td>").append(rs.getString(i)).append("</td>");
                                }
                                resultHtml.append("</tr>");
                            }
                            
                            resultHtml.append("</table>");
                            
                            request.setAttribute("results", resultHtml.toString());
                        }
                    } else if (trimmedSQL.startsWith("insert") || trimmedSQL.startsWith("update")) {
                        // Handle INSERT/UPDATE statements
                        int rowsAffected = stmt.executeUpdate(sqlCommand);
                        
                        // Check if business logic should be triggered
                        if (trimmedSQL.contains("shipments") && 
                            (trimmedSQL.contains("quantity") || trimmedSQL.contains("insert"))) {
                            
                            // Check if any shipments have quantity >= 100
                            String checkSQL = "SELECT COUNT(*) FROM shipments WHERE quantity >= 100";
                            try (ResultSet rs = stmt.executeQuery(checkSQL)) {
                                if (rs.next() && rs.getInt(1) > 0) {
                                    // Trigger business logic
                                    String updateSQL = "UPDATE suppliers SET status = status + 5 " +
                                                     "WHERE snum IN (SELECT DISTINCT snum FROM shipments WHERE quantity >= 100)";
                                    stmt.executeUpdate(updateSQL);
                                    businessLogicTriggered = true;
                                }
                            }
                        }
                        
                        request.setAttribute("results", "Command executed successfully. Rows affected: " + rowsAffected);
                    } else {
                        // Handle other statements (DELETE, etc.)
                        int rowsAffected = stmt.executeUpdate(sqlCommand);
                        request.setAttribute("results", "Command executed successfully. Rows affected: " + rowsAffected);
                    }
                }
                
            }
            
        } catch (SQLException e) {
            request.setAttribute("error", "SQL Error: " + e.getMessage());
        } catch (Exception e) {
            request.setAttribute("error", "Error: " + e.getMessage());
        }
        
        // Set business logic flag
        request.setAttribute("businessLogicTriggered", businessLogicTriggered);
        
        // Forward back to root home page
        RequestDispatcher dispatcher = request.getRequestDispatcher("rootHome.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirect GET requests to login page
        response.sendRedirect("authentication.html");
    }
} 