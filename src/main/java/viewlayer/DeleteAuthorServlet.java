package viewlayer;

import businesslayer.AuthorBusinessLogic;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to handle the Deletion of records from the Authors database.
 * @author Louis Tran
 * Student Number: 041072185
 * Lab Section: 013 CST8288
 */
public class DeleteAuthorServlet extends HttpServlet {

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
        
        // If no ID parameter is provided, just show the form
        if (idParam == null || idParam.trim().isEmpty()) {
            request.getRequestDispatcher("WEB-INF/delete-author.jsp").forward(request, response);
            return;
        }
        
        try {
            int id = Integer.parseInt(idParam.trim());
            AuthorBusinessLogic logic = new AuthorBusinessLogic();
            
            // Check if author exists before attempting deletion
            if (logic.getAuthorById(id) != null) {
                // Author exists, proceed with deletion
                logic.deleteAuthor(id);
                request.setAttribute("deleteResult", 
                    "Author with ID " + id + " deleted successfully");
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
                "An error occurred while processing your request: " + e.getMessage());
        }
        
        // Forward to JSP with the results
        request.getRequestDispatcher("WEB-INF/delete-author.jsp").forward(request, response);
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
        return "Delete Author Servlet - Handles author deletion operations";
    }
}