<%-- 
    Document   : allAuthors
    Created on : Jul 28, 2025, 12:09:15 a.m.
    Author     : Louis Tran 041072185
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="transferobjects.AuthorDTO" %>
<%
    List<AuthorDTO> authors = (List<AuthorDTO>) request.getAttribute("authors");
%>
<!DOCTYPE html>
<html>
<head>
    <title>CST8288 Assignment 2 - All Authors</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <header>
        <h1>All Authors</h1>
    </header>
    <main>
        <% if (authors == null || authors.isEmpty()) { %>
            <div class="message message-error">
                <p>No authors found.</p>
            </div>
        <% } else { %>
            <table border="1" class="author-form">
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>
                <% for (AuthorDTO author : authors) { %>
                    <tr>
                        <td><%= author.getAuthorID() %></td>
                        <td><%= author.getFirstName() %></td>
                        <td><%= author.getLastName() %></td>
                    </tr>
                <% } %>
            </table>
        <% } %>
        <div class="nav-links">
            <a href="Controller?action=menu">Back to Menu</a>
            <a href="index.html">Back to Login</a>
        </div>
    </main>
        <footer>
            <p>Program by Louis Tran 041072185</p>
            <p>25S CST8288 Section 013 Assignment 2</p>
        </footer>
</div>
</body>
</html>
