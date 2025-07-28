<%-- 
    Document   : delete-author
    Created on : Jul 27, 2025, 11:30:00 p.m.
    Author     : Louis Tran 041072185
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="businesslayer.AuthorBusinessLogic" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Author - Author Management System</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>Delete Author</h1>
            <p class="subtitle">Remove an author from the system</p>
        </header>

        <main>
            <%
                String idParam = request.getParameter("id");
                String deleteResult = (String) request.getAttribute("deleteResult");
                String errorMessage = (String) request.getAttribute("errorMessage");
                Boolean authorNotFound = (Boolean) request.getAttribute("authorNotFound");
                
                // Display messages if present
                if (deleteResult != null) {
            %>
                <div class="message message-success">
                    <p><%= deleteResult %></p>
                </div>
            <%
                } else if (errorMessage != null) {
            %>
                <div class="message message-error">
                    <p><%= errorMessage %></p>
                </div>
            <%
                } else if (authorNotFound != null && authorNotFound) {
            %>
                <div class="message message-error">
                    <p>Author not found with ID: <%= request.getParameter("id") %></p>
                </div>
            <%
                }
            %>

            <!-- Delete Author Form -->
            <div class="author-form">
                <div class="form-header">
                    <h2>Delete Author</h2>
                    <p>Enter the Author ID you want to delete</p>
                </div>
                
                <form method="get" action="deleteAuthor">
                    <div class="form-group">
                        <label for="authorId">Author ID to DELETE:</label>
                        <input type="text" 
                               id="authorId" 
                               name="id" 
                               placeholder="Enter author ID..." 
                               value="<%= idParam != null ? idParam : "" %>"
                               required>
                    </div>
                    
                    <div class="form-group">
                        <input type="submit" value="Delete Author" class="btn">
                    </div>
                </form>
                
                <div class="login-info">
                    <p class="info-text">Warning: This action cannot be undone</p>
                    <p class="info-text">Please verify the Author ID before deletion</p>
                </div>
            </div>
        </main>

        <div class="nav-links">
            <a href="Controller">Back to Menu</a>
        </div>

        <footer>
            <p>Program by Louis Tran 041072185</p>
            <p>25S CST8288 Section 013 Assignment 2</p>
        </footer>
    </div>
</body>
</html>