package viewlayer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Properties;

/**
 * LoginServlet handles database authentication for the Author Management System.
 * This servlet provides secure login functionality by validating user credentials
 * against database connection properties and managing user authentication sessions.
 * 
 * @author Louis Tran
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * @see javax.servlet.http.HttpSession
 * Student Number: 041072185<br>
 * Course: CST8288 - Object Oriented Programming (Java)<br>
 * Section: 013<br>
 * Assignment: 2
 */
public class LoginServlet extends HttpServlet {
    
    /**
     * Handles HTTP GET requests to display the database login form.
     * 
     * If the request includes an "error=true" parameter (typically from failed
     * authentication attempts), the JSP will display a user-friendly error
     * message indicating incorrect credentials.
     * 
     * @param request  the HttpServletRequest object containing client request data
     * @param response the HttpServletResponse object for sending responses to client
     * 
     * @throws ServletException if a servlet-specific error occurs during processing
     * @throws IOException      if an input/output error occurs during request handling
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Forward to the modern login JSP page
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
    
    /**
     * Handles HTTP POST requests to validate database authentication credentials.
     * 
     * This method processes login form submissions by validating the provided
     * username and password against the database configuration properties. Upon
     * successful validation, it establishes an authenticated session and redirects
     * the user to the main application controller.
     * 
     * @param request  the HttpServletRequest containing form data and client information
     * @param response the HttpServletResponse for sending authentication results
     * 
     * @throws ServletException if a servlet-specific error occurs during authentication
     * @throws IOException      if an input/output error occurs during processing
     * 
     * @see java.util.Properties#load(InputStream)
     * @see HttpSession#setAttribute(String, Object)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Extract credentials from form submission
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Load database configuration properties
        Properties props = new Properties();
        try (InputStream in = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("database.properties")) {
            
            if (in == null) {
                // Handle missing properties file
                throw new IOException("database.properties file not found in classpath");
            }
            
            props.load(in);
            
        } catch (IOException e) {
            // Log error and redirect to login with error message
            System.err.println("Error loading database properties: " + e.getMessage());
            e.printStackTrace();
            response.sendRedirect("Login?error=true");
            return;
        }
        
        // Retrieve expected credentials from properties
        String expectedUsername = props.getProperty("jdbc.username");
        String expectedPassword = props.getProperty("jdbc.password");
        
        // Validate credentials with null safety checks
        if (expectedUsername != null && expectedPassword != null && 
            expectedUsername.equals(username) && expectedPassword.equals(password)) {
            
            // Successful authentication - create authenticated session
            HttpSession session = request.getSession();
            session.setAttribute("authenticated", true);
            session.setAttribute("username", username);
            
            // Redirect to main application controller
            response.sendRedirect("Controller");
            
        } else {
            // Failed authentication - redirect with error parameter
            response.sendRedirect("Login?error=true");
        }
    }
    
    /**
     * Provides comprehensive information about this servlet's functionality
     * and purpose within the Author Management System.
     * 
     * @return a String containing detailed description of the servlet's
     *         authentication functionality, security features, and technical specifications
     * 
     * @see javax.servlet.GenericServlet#getServletInfo()
     */
    @Override
    public String getServletInfo() {
        return "LoginServlet - Database Authentication Controller for Author Management System. ";
    }
}