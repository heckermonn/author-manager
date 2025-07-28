<%-- 
    Document   : controller-menu
    Created on : Jul 27, 2025, 11:30:00 p.m.
    Author     : Louis Tran 041072185
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CST8288 Assignment 2</title>
    
    <%-- Link to the external CSS file --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    
    <%-- Modern font stack --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&family=JetBrains+Mono:wght@400;500&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <header>
            <h1>Author Management System</h1>
        </header>
        
        <main>
            <div class="menu-container">
                <nav class="menu-nav">
                    <ul class="menu-list">
                        <li class="menu-item">
                            <a href="getAll" class="menu-link">
                                <span class="menu-icon">📚</span>
                                <span class="menu-text">Get All Authors</span>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="getById" class="menu-link">
                                <span class="menu-icon">🔍</span>
                                <span class="menu-text">Get Author By ID</span>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="addAuthor" class="menu-link">
                                <span class="menu-icon">➕</span>
                                <span class="menu-text">Add Author</span>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="updateAuthor" class="menu-link">
                                <span class="menu-icon">✏️</span>
                                <span class="menu-text">Update Author</span>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="deleteAuthor" class="menu-link">
                                <span class="menu-icon">🗑️</span>
                                <span class="menu-text">Delete Author</span>
                            </a>
                        </li>
                    </ul>
                </nav>
                
                <div class="logout-section">
                    <a href="Logout" class="logout-link">
                        <span class="menu-icon">🚪</span>
                        <span class="menu-text">Logout</span>
                    </a>
                </div>
            </div>
        </main>
        
        <footer>
            <p>Program by Louis Tran 041072185</p>
            <p>25S CST8288 Section 013 Assignment 2</p>
        </footer>
    </div>
</body>
</html>