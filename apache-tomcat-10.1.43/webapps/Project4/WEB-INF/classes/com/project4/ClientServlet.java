/*
 * Name: Medha Subramaniyan
 * Course: CNT 4714 – Summer 2025 – Project Four
 * Assignment title: A Three-Tier Distributed Web-Based Application
 * Date: July 31, 2025
 * Class: ClientServlet
 */

package com.project4;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ClientServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String sqlCommand = request.getParameter("sqlCommand");
        
        try {
            // Connect to project4 as client using DBConnectionUtil
            try (Connection conn = DBConnectionUtil.getConnection(
                    getServletContext(), "/WEB-INF/conf/client.properties")) {
                
                // Execute SQL command
                try (Statement stmt = conn.createStatement()) {
                    
                    // Check if it's a SELECT statement (only allowed for client)
                    String trimmedSQL = sqlCommand.trim().toLowerCase();
                    if (!trimmedSQL.startsWith("select")) {
                        request.setAttribute("error", "Permission denied. Client user can only execute SELECT statements.");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("clientHome.jsp");
                        dispatcher.forward(request, response);
                        return;
                    }
                    
                    // Execute the query
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
                }
                
            }
            
        } catch (SQLException e) {
            // Handle SQL exceptions (including permission errors)
            String errorMessage = "SQL Error: " + e.getMessage();
            if (e.getMessage().contains("Access denied") || e.getMessage().contains("privilege")) {
                errorMessage = "Permission denied. Client user can only execute SELECT statements.";
            }
            request.setAttribute("error", errorMessage);
        } catch (Exception e) {
            request.setAttribute("error", "Error: " + e.getMessage());
        }
        
        // Set the SQL command back in the request for the JSP to display
        request.setAttribute("sqlCommand", sqlCommand);
        
        // Forward back to client home page
        RequestDispatcher dispatcher = request.getRequestDispatcher("clientHome.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirect GET requests to login page
        response.sendRedirect("authentication.html");
    }
} 