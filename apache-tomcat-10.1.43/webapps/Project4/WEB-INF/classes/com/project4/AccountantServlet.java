/*
 * Name: Medha Subramaniyan
 * Course: CNT 4714 – Summer 2025 – Project Four
 * Assignment title: A Three-Tier Distributed Web-Based Application
 * Date: July 31, 2025
 * Class: AccountantServlet
 */

package com.project4;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AccountantServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String procedureOption = request.getParameter("procedureOption");
        
        try {
            // Connect to project4 as accountant using DBConnectionUtil
            try (Connection conn = DBConnectionUtil.getConnection(
                    getServletContext(), "/WEB-INF/conf/accountant.properties")) {
                
                // Execute stored procedure based on selection
                String procedureName = getProcedureName(procedureOption);
                if (procedureName != null) {
                    String callSQL = "CALL " + procedureName + "()";
                    
                    try (CallableStatement cstmt = conn.prepareCall(callSQL)) {
                        try (ResultSet rs = cstmt.executeQuery()) {
                            ResultSetMetaData metaData = rs.getMetaData();
                            int columnCount = metaData.getColumnCount();
                            
                            StringBuilder resultHtml = new StringBuilder();
                            resultHtml.append("<h4>Stored Procedure: ").append(procedureName).append("</h4>");
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
                } else {
                    request.setAttribute("error", "Invalid procedure selection.");
                }
                
            }
            
        } catch (SQLException e) {
            request.setAttribute("error", "SQL Error: " + e.getMessage());
        } catch (Exception e) {
            request.setAttribute("error", "Error: " + e.getMessage());
        }
        
        // Forward back to accountant home page
        RequestDispatcher dispatcher = request.getRequestDispatcher("accountantHome.jsp");
        dispatcher.forward(request, response);
    }
    
    private String getProcedureName(String option) {
        switch (option) {
            case "1": return "Get_The_Sum_Of_All_Parts_Weights";
            case "2": return "Get_The_Maximum_Status_Of_All_Suppliers";
            case "3": return "Get_The_Total_Number_Of_Shipments";
            case "4": return "Get_The_Name_Of_The_Job_With_The_Most_Workers";
            case "5": return "List_The_Name_And_Status_Of_All_Suppliers";
            default: return null;
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirect GET requests to login page
        response.sendRedirect("authentication.html");
    }
} 