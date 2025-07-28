<%-- 
    Document   : updateResult
    Created on : Jul 28, 2025, 12:25:52 a.m.
    Author     : Louis Tran 041072185
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String message = (String) request.getAttribute("message");
    boolean success = Boolean.parseBoolean(request.getAttribute("success").toString());
%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Result</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <header>
        <h1>Update Result</h1>
    </header>
    <main>
        <div class="message <%= success ? "message-success" : "message-error" %>">
            <p><%= message %></p>
        </div>
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

