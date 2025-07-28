package viewlayer;

import businesslayer.AuthorBusinessLogic;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.AuthorDTO;

/**
 * This Servlet allows for the searching of authors via ID in the database.
 * @author Louis Tran
 * Student Number: 041072185
 * Lab Section: 013 CST8288
 */
public class GetAuthorByIdServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idParam = request.getParameter("id");
        
        // If no ID parameter is provided, just show the search form
        if (idParam == null || idParam.trim().isEmpty()) {
            request.getRequestDispatcher("WEB-INF/getAuthorById.jsp").forward(request, response);
            return;
        }
        
        try {
            int id = Integer.parseInt(idParam.trim());
            AuthorBusinessLogic logic = new AuthorBusinessLogic();
            AuthorDTO author = logic.getAuthorById(id);
            
            if (author != null) {
                // Author found, set it as an attribute for the JSP
                request.setAttribute("author", author);
            } else {
                // Author not found
                request.setAttribute("authorNotFound", true);
            }
            
        } catch (NumberFormatException e) {
            // Invalid ID format
            request.setAttribute("errorMessage", 
                "Invalid ID format. Please enter a valid numeric ID.");
        } catch (Exception e) {
            // Handle any other exceptions that might occur
            request.setAttribute("errorMessage", 
                "An error occurred while searching for the author: " + e.getMessage());
        }
        
        // Forward to JSP with the results
        request.getRequestDispatcher("WEB-INF/getAuthorById.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Get Author By ID Servlet - Handles author search operations by ID";
    }
}