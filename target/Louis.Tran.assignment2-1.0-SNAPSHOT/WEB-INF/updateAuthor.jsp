<%-- 
    Document   : updateAuthor
    Created on : Jul 28, 2025, 12:24:40 a.m.
    Author     : Louis Tran 041072185
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="transferobjects.AuthorDTO" %>
<%
    AuthorDTO author = (AuthorDTO) request.getAttribute("author");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Author</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <header>
        <h1>Update Author</h1>
    </header>
    <main>
        <% if (author == null) { %>
            <div class="message message-error">
                <p>Author not found.</p>
            </div>
        <% } else { %>
            <form method="post" class="author-form">
                <input type="hidden" name="authorID" value="<%= author.getAuthorID() %>">
                <div class="form-group">
                    <label for="fName">First Name:</label>
                    <input type="text" name="fName" id="fName" value="<%= author.getFirstName() %>">
                </div>
                <div class="form-group">
                    <label for="lName">Last Name:</label>
                    <input type="text" name="lName" id="lName" value="<%= author.getLastName() %>">
                </div>
                <input type="submit" value="Update Author" class="btn">
            </form>
        <% } %>
        <div class="nav-links">
            <a href="Controller">Back to Menu</a>
        </div>
    </main>
    <footer>
        <p>Program by: Louis Tran (041072185)</p>
        <p>25S CST8288 Section 013 Assignment 2</p>
    </footer>
</div>
</body>
</html>

