<%-- 
    Document   : getAuthorById
    Created on : Jul 27, 2025, 11:30:00 p.m.
    Author     : Louis Tran 041072185
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="transferobjects.AuthorDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Get Author By ID - Author Management System</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>Get Author by ID</h1>
            <p class="subtitle">Search for a specific author by their ID</p>
        </header>

        <main>
            <%
                String idParam = request.getParameter("id");
                AuthorDTO author = (AuthorDTO) request.getAttribute("author");
                String errorMessage = (String) request.getAttribute("errorMessage");
                Boolean authorNotFound = (Boolean) request.getAttribute("authorNotFound");
                
                // Display error messages if present
                if (errorMessage != null) {
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

            <!-- Search Form -->
            <div class="author-form">
                <div class="form-header">
                    <h2>Search Author</h2>
                    <p>Enter the Author ID to retrieve details</p>
                </div>
                
                <form method="get" action="getById">
                    <div class="form-group">
                        <label for="authorId">Author ID:</label>
                        <input type="text" 
                               id="authorId" 
                               name="id" 
                               placeholder="Enter author ID..." 
                               value="<%= idParam != null ? idParam : "" %>"
                               required>
                    </div>
                    
                    <div class="form-group">
                        <input type="submit" value="Get Author" class="btn">
                    </div>
                </form>
                
                <div class="login-info">
                    <p class="info-text">💡 Enter a numeric ID to search for an author</p>
                </div>
            </div>

            <!-- Author Details Display -->
            <% if (author != null) { %>
                <div class="author-details">
                    <div class="details-header">
                        <h2>Author Details</h2>
                        <p>Information for Author ID: <%= author.getAuthorID() %></p>
                    </div>
                    
                    <table class="author-table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="author-id"><%= author.getAuthorID() %></td>
                                <td class="author-name"><%= author.getFirstName() %></td>
                                <td class="author-name"><%= author.getLastName() %></td>
                            </tr>
                        </tbody>
                    </table>
                    
                    <div class="search-result-info">
                        <p>✓ Author found successfully</p>
                    </div>
                </div>
            <% } %>
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