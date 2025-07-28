<%-- 
    Document   : add-author
    Created on : Jul 27, 2025, 11:00:00 p.m.
    Author     : Louis Tran 041072185
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${pageTitle}</title>
    
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
            <h1>${pageTitle}</h1>
        </header>
        
        <main>
            <%-- Display error message if it exists --%>
            <% if (request.getAttribute("errorMessage") != null) { %>
                <div class="message message-error">
                    <p><%= request.getAttribute("errorMessage") %></p>
                </div>
            <% } %>
            
            <%-- Display success message if it exists --%>
            <% if (request.getAttribute("successMessage") != null) { %>
                <div class="message message-success">
                    <p><%= request.getAttribute("successMessage") %></p>
                </div>
            <% } %>
            
            <%-- The form is always available for another entry --%>
            <form class="author-form" method="post" action="addAuthor">
                <div class="form-group">
                    <label for="fName">First Name:</label>
                    <input type="text" id="fName" name="fName" value="<%= request.getParameter("fName") != null ? request.getParameter("fName") : "" %>" placeholder="Enter first name" required>
                </div>
                
                <div class="form-group">
                    <label for="lName">Last Name:</label>
                    <input type="text" id="lName" name="lName" value="<%= request.getParameter("lName") != null ? request.getParameter("lName") : "" %>" placeholder="Enter last name" required>
                </div>
                
                <div class="form-group">
                    <input type="submit" class="btn" value="Add Author">
                </div>
            </form>
            
            <nav class="nav-links">
                <a href="Controller">Back to Menu</a>
            </nav>
        </main>
        
        <footer>
            <p>Program by Louis Tran 041072185</p>
            <p>25S CST8288 Section 013 Assignment 2</p>
        </footer>
    </div>
</body>
</html>