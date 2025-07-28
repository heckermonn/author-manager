package viewlayer;

import businesslayer.AuthorBusinessLogic;
import transferobjects.AuthorDTO;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * Servlet that handles retrieval and display of all authors from the database.
 * This servlet uses the AuthorBusinessLogic class to obtain a list of all authors
 * and forwards the request to a JSP page for rendering.
 * 
 * Author: Louis Tran  
 * Student Number: 041072185  
 * Lab Section: 013 CST8288  
 */
public class getAllAuthors extends HttpServlet {

    /**
     * Processes HTTP GET and POST requests to retrieve all authors and forward them to a JSP view.
     *
     * @param request  the {@link HttpServletRequest} object that contains the request the client made
     * @param response the {@link HttpServletResponse} object that contains the response the servlet returns
     * @throws ServletException if the request could not be handled
     * @throws IOException      if an I/O error occurs while handling the request
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AuthorBusinessLogic logic = new AuthorBusinessLogic();
        List<AuthorDTO> authors = logic.getAllAuthors();
        request.setAttribute("authors", authors);
        request.getRequestDispatcher("WEB-INF/allAuthors.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP GET method by delegating to {@link #processRequest(HttpServletRequest, HttpServletResponse)}.
     *
     * @param request  the client request
     * @param response the response to the client
     * @throws ServletException if the request cannot be handled
     * @throws IOException      if an input or output error is detected
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP POST method by delegating to {@link #processRequest(HttpServletRequest, HttpServletResponse)}.
     *
     * @param request  the client request
     * @param response the response to the client
     * @throws ServletException if the request cannot be handled
     * @throws IOException      if an input or output error is detected
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of this servlet.
     *
     * @return a string describing the servlet
     */
    @Override
    public String getServletInfo() {
        return "Servlet for displaying all authors using a JSP";
    }
}
