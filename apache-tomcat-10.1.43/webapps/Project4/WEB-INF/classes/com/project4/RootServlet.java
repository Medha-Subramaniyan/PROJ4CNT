/*
 * Name: Medha Subramaniyan
 * Course: CNT 4714 – Summer 2025 – Project Four
 * Assignment title: A Three-Tier Distributed Web-Based Application
 * Date: July 31, 2025
 * Class: RootServlet
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
            // Connect to project4 as root using DBConnectionUtil
            try (Connection conn = DBConnectionUtil.getConnection(
                    getServletContext(), "/WEB-INF/conf/root.properties")) {
                
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
                    } else {
                        // Handle UPDATE, INSERT, DELETE statements
                        int rowsAffected = stmt.executeUpdate(sqlCommand);
                        
                        // Check if this is an UPDATE on shipments table
                        if (trimmedSQL.startsWith("update") && trimmedSQL.contains("shipments")) {
                            // Check if any shipment quantity >= 100
                            try (ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM shipments WHERE quantity >= 100")) {
                                if (rs.next() && rs.getInt(1) > 0) {
                                    businessLogicTriggered = true;
                                }
                            }
                        }
                        
                        String message = rowsAffected + " row(s) affected.";
                        if (businessLogicTriggered) {
                            message += " Business logic triggered: Shipment quantities >= 100 detected!";
                        }
                        request.setAttribute("results", "<p>" + message + "</p>");
                    }
                }
                
            }
            
        } catch (SQLException e) {
            request.setAttribute("error", "SQL Error: " + e.getMessage());
        } catch (Exception e) {
            request.setAttribute("error", "Error: " + e.getMessage());
        }
        
        // Set the SQL command back in the request for the JSP to display
        request.setAttribute("sqlCommand", sqlCommand);
        
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