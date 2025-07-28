# Author Management System

A web-based Java application for managing authors in a MySQL database. Built using Jakarta EE (Servlets, JSP), JDBC, and Maven.

## Features

- **Login Authentication:** Secure login using database credentials.
- **CRUD Operations:** Add, view, update, and delete authors.
- **Modern UI:** Responsive interface styled with CSS.
- **Session Management:** Secure logout and session timeout.
- **MVC Architecture:** Separation of business, data access, and view layers.

## Project Structure

```
src/
  main/
    java/
      businesslayer/         # Business logic (AuthorBusinessLogic.java)
      dataaccesslayer/       # DAO and DB connection (AuthorDAO.java, AuthorDAOImpl.java, DataSource.java)
      transferobjects/       # DTOs (AuthorDTO.java)
      viewlayer/             # Servlets (LoginServlet.java, ControllerServlet.java, etc.)
      books-MySQL.sql        # SQL schema and sample data
      database.properties    # DB connection config
    resources/
      database.properties    # DB connection config (for build)
      META-INF/
        persistence.xml      # JPA config (not used in JDBC version)
    webapp/
      index.html             # Redirects to login
      style.css              # Main stylesheet
      META-INF/
        context.xml          # Tomcat context config
      WEB-INF/
        *.jsp                # JSP views (login, menu, add, update, delete, etc.)
        web.xml              # Servlet mappings
        beans.xml            # CDI config
pom.xml                      # Maven build config
```

## Database Setup

1. **Create Database & Tables:**
   - Use [`src/main/java/books-MySQL.sql`](src/main/java/books-MySQL.sql) to create the `books` database and required tables.

2. **Configure Connection:**
   - Edit [`src/main/resources/database.properties`](src/main/resources/database.properties) with your MySQL credentials.

## Build & Run

1. **Build with Maven:**
   ```sh
   mvn clean package
   ```

2. **Deploy WAR:**
   - Deploy `target/Louis.Tran.assignment2-1.0-SNAPSHOT.war` to a servlet container (e.g., Tomcat).

3. **Access Application:**
   - Open [http://localhost:8080/Louis.Tran.assignment2](http://localhost:8080/Louis.Tran.assignment2) in your browser.

## Main Components

- **Business Logic:** [`businesslayer.AuthorBusinessLogic`](src/main/java/businesslayer/AuthorBusinessLogic.java)
- **Data Access:** [`dataaccesslayer.AuthorDAOImpl`](src/main/java/dataaccesslayer/AuthorDAOImpl.java)
- **DTO:** [`transferobjects.AuthorDTO`](src/main/java/transferobjects/AuthorDTO.java)
- **Servlets:** [`viewlayer.LoginServlet`](src/main/java/viewlayer/LoginServlet.java), [`viewlayer.ControllerServlet`](src/main/java/viewlayer/ControllerServlet.java), etc.
- **JSP Views:** [`WEB-INF/login.jsp`](src/main/webapp/WEB-INF/login.jsp), [`WEB-INF/controller-menu.jsp`](src/main/webapp/WEB-INF/controller-menu.jsp), etc.

## Author

Louis Tran  
Student Number: 041072185  
CST8288 Section 013 Assignment 2

## License

This project is for educational purposes.
