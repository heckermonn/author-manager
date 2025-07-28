<%-- 
    Document   : login
    Created on : Jul 27, 2025, 11:45:00 p.m.
    Author     : Louis Tran 041072185
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Database Login - Author Management System</title>
    
    <%-- Link to the external CSS file --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    
    <%-- Font stack --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&family=JetBrains+Mono:wght@400;500&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <header>
            <h1>Database Authentication</h1>
            <p class="subtitle">Enter your DBMS credentials to access the Author Management System</p>
        </header>
        
        <main>
            <%-- Display logout success message --%>
            <% if ("true".equals(request.getParameter("logout"))) { %>
                <div class="message message-success">
                    <p>Successfully Logged Out</p>
                    <p class="success-details">You have been securely disconnected from the database. Please login again to continue.</p>
                </div>
            <% } %>
            
            <%-- Display error message if login failed --%>
            <% if ("true".equals(request.getParameter("error"))) { %>
                <div class="message message-error">
                    <p>Incorrect Username or Password</p>
                    <p class="error-details">Please verify your database credentials and try again.</p>
                </div>
            <% } %>
            
            <%-- Login Form --%>
            <form class="author-form login-form" method="post" action="Login">
                <div class="form-header">
                    <h2>Database Login</h2>
                    <p>Please enter your database connection credentials</p>
                </div>
                
                <div class="form-group">
                    <label for="username">Database Username:</label>
                    <input type="text" 
                           id="username" 
                           name="username" 
                           placeholder="Enter database username" 
                           value="<%= request.getParameter("username") != null ? request.getParameter("username") : "" %>"
                           required 
                           autocomplete="username">
                </div>
                
                <div class="form-group">
                    <label for="password">Database Password:</label>
                    <input type="password" 
                           id="password" 
                           name="password" 
                           placeholder="Enter database password" 
                           required 
                           autocomplete="current-password">
                </div>
                
                <div class="form-group">
                    <input type="submit" class="btn login-btn" value="Connect to Database">
                </div>
                
                <div class="login-info">
                    <p class="info-text">
                        Your credentials are used to establish a secure connection to the database server.
                    </p>
                    <p class="info-text">
                        Upon successful authentication, you'll have access to all author management features.
                    </p>
                </div>
            </form>
        </main>
        
        <footer>
            <p>Program by Louis Tran 041072185</p>
            <p>25S CST8288 Section 013 Assignment 2</p>
        </footer>
    </div>
</body>
</html>