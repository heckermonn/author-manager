package viewlayer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * LogoutServlet handles user logout functionality for the Author Management System.
 * This servlet provides secure session termination by invalidating user sessions
 * and redirecting users back to the login page with appropriate confirmation messaging.
 *
 * @author Louis Tran
 * @version 1.0
 * @since 2025-07-27
 * @see javax.servlet.http.HttpServlet
 * @see javax.servlet.http.HttpSession
 * @see viewlayer.LoginServlet
 * 
 * Student Number: 041072185<br>
 * Course: CST8288 - Object Oriented Programming (Java)<br>
 * Section: 013<br>
 * Assignment 2
 */
public class LogoutServlet extends HttpServlet {
    
    /**
     * Handles HTTP GET requests to process user logout operations.
     * 
     * @param request  the HttpServletRequest object containing client request information
     * @param response the HttpServletResponse object for sending logout response to client
     * 
     * @throws ServletException if a servlet-specific error occurs during logout processing
     * @throws IOException      if an input/output error occurs during request handling
     * 
     * @see HttpSession#invalidate()
     * @see HttpServletResponse#setHeader(String, String)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set cache control headers to prevent cached page access
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        
        // Get current session without creating a new one
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // Log logout activity (debugging/auditing)
            String username = (String) session.getAttribute("username");
            if (username != null) {
                System.out.println("User logout: " + username + " at " + new java.util.Date());
            }
            
            // Completely invalidate the session
            // This removes all session attributes and makes the session invalid
            session.invalidate();
        }
        
        // Redirect to login page with logout confirmation message
        response.sendRedirect("Login?logout=true");
    }
    
    /**
     * Handles HTTP POST requests by delegating to the GET handler.
     * 
     * @param request  the HttpServletRequest object containing client request information
     * @param response the HttpServletResponse object for sending logout response to client
     * 
     * @throws ServletException if a servlet-specific error occurs during logout processing
     * @throws IOException      if an input/output error occurs during request handling
     * 
     * @see #doGet(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Delegate POST requests to GET handler for consistent logout behavior
        doGet(request, response);
    }
    
    /**
     * Provides comprehensive information about this servlet's logout functionality
     * and security features within the Author Management System.
     * 
     * @return a String containing detailed description of the servlet's logout
     *         functionality, security features, and implementation details
     * 
     * @see javax.servlet.GenericServlet#getServletInfo()
     */
    @Override
    public String getServletInfo() {
        return "LogoutServlet - Secure Session Termination Controller for Author Management System. ";
    }
}