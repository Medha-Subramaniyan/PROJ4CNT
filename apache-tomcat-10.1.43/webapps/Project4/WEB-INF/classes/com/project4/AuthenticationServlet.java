/*
 * Project 4 - CNT 4714
 * AuthenticationServlet.java
 * 
 * This servlet handles user authentication by checking credentials
 * against the credentialsDB database and redirecting users to their
 * appropriate home pages based on their role.
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

public class AuthenticationServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try {
            // Load systemapp properties for credentialsDB connection
            Properties props = new Properties();
            props.load(getServletContext().getResourceAsStream("/WEB-INF/conf/systemapp.properties"));
            
            // Load JDBC driver
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new ServletException("MySQL Driver not found", e);
            }
            
            // Connect to credentialsDB
            try (Connection conn = DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("user"),
                    props.getProperty("password"))) {
                
                // Query usercredentials table
                String sql = "SELECT login_username, login_password FROM usercredentials WHERE login_username = ? AND login_password = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            // Valid credentials - redirect based on user type
                            if ("root".equals(username)) {
                                response.sendRedirect("rootHome.jsp");
                            } else if ("client".equals(username)) {
                                response.sendRedirect("clientHome.jsp");
                            } else if ("theaccountant".equals(username)) {
                                response.sendRedirect("accountantHome.jsp");
                            } else {
                                // Unknown user type
                                response.sendRedirect("errorpage.html");
                            }
                        } else {
                            // Invalid credentials
                            response.sendRedirect("errorpage.html");
                        }
                    }
                }
            }
            
        } catch (Exception e) {
            // Log error and redirect to error page
            e.printStackTrace();
            response.sendRedirect("errorpage.html");
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirect GET requests to login page
        response.sendRedirect("authentication.html");
    }
} 