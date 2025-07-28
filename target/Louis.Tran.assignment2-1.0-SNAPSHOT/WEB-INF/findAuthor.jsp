<%-- 
    Document   : findAuthor
    Created on : Jul 28, 2025, 12:23:54 a.m.
    Author     : Louis Tran 041072185
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Find Author to Update</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <header>
        <h1>Update Author</h1>
    </header>
    <main>
        <form method="get" class="author-form">
            <div class="form-group">
                <label for="id">Author ID to update:</label>
                <input type="text" name="id" id="id" placeholder="Enter Author ID">
            </div>
            <input type="submit" value="Find Author" class="btn">
        </form>
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

