/*
 * Name: Medha Subramaniyan
 * Course: CNT 4714 – Summer 2025 – Project Four
 * Assignment title: A Three-Tier Distributed Web-Based Application
 * Date: July 31, 2025
 * Class: AuthenticationServlet
 */

package com.project4;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticationServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Temporary hardcoded authentication for testing
        if (username != null && password != null) {
            if (username.equals("root") && password.equals("rootMAC1$")) {
                // Root user - redirect to root home
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("userType", "root");
                response.sendRedirect("rootHome.jsp");
                return;
            } else if (username.equals("client") && password.equals("client")) {
                // Client user - redirect to client home
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("userType", "client");
                response.sendRedirect("clientHome.jsp");
                return;
            } else if (username.equals("theaccountant") && password.equals("theaccountant")) {
                // Accountant user - redirect to accountant home
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("userType", "accountant");
                response.sendRedirect("accountantHome.jsp");
                return;
            }
        }
        
        // Authentication failed
        response.sendRedirect("errorpage.html");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirect GET requests to login page
        response.sendRedirect("authentication.html");
    }
} 