/*
 * Name: Medha Subramaniyan
 * Course: CNT 4714 – Summer 2025 – Project Four
 * Assignment title: A Three-Tier Distributed Web-Based Application
 * Date: July 31, 2025
 * Class: TestDriverServlet
 */

package com.project4;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestDriverServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head><title>Driver Test</title></head><body>");
        out.println("<h1>MySQL Driver Test</h1>");
        
        // Test drivers using DBConnectionUtil
        out.println("<h2>Driver Tests:</h2>");
        
        if (DBConnectionUtil.testDriver("com.mysql.cj.jdbc.Driver")) {
            out.println("<p style='color: green;'>✓ com.mysql.cj.jdbc.Driver loaded successfully!</p>");
        } else {
            out.println("<p style='color: red;'>✗ com.mysql.cj.jdbc.Driver not found</p>");
        }
        
        if (DBConnectionUtil.testDriver("com.mysql.jdbc.Driver")) {
            out.println("<p style='color: green;'>✓ com.mysql.jdbc.Driver loaded successfully!</p>");
        } else {
            out.println("<p style='color: red;'>✗ com.mysql.jdbc.Driver not found</p>");
        }
        
        out.println("<h2>Connection Tests:</h2>");
        
        // Test connections to different databases
        try {
            DBConnectionUtil.getConnection(getServletContext(), "/WEB-INF/conf/client.properties");
            out.println("<p style='color: green;'>✓ Client connection successful!</p>");
        } catch (Exception e) {
            out.println("<p style='color: red;'>✗ Client connection failed: " + e.getMessage() + "</p>");
            out.println("<p style='color: red;'>Full error: " + e.toString() + "</p>");
        }
        
        try {
            DBConnectionUtil.getConnection(getServletContext(), "/WEB-INF/conf/root.properties");
            out.println("<p style='color: green;'>✓ Root connection successful!</p>");
        } catch (Exception e) {
            out.println("<p style='color: red;'>✗ Root connection failed: " + e.getMessage() + "</p>");
            out.println("<p style='color: red;'>Full error: " + e.toString() + "</p>");
        }
        
        try {
            DBConnectionUtil.getConnection(getServletContext(), "/WEB-INF/conf/accountant.properties");
            out.println("<p style='color: green;'>✓ Accountant connection successful!</p>");
        } catch (Exception e) {
            out.println("<p style='color: red;'>✗ Accountant connection failed: " + e.getMessage() + "</p>");
            out.println("<p style='color: red;'>Full error: " + e.toString() + "</p>");
        }
        
        out.println("</body></html>");
    }
} 