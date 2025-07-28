package viewlayer;

import businesslayer.AuthorBusinessLogic;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.AuthorDTO;

/**
 * Handles the logic for adding a new author. It processes form submissions
 * and delegates rendering to a JSP view.
 * @author Louis Tran
 * Student Number: 041072185
 * Lab Section: 013 CST8288
 */
public class AddAuthorServlet extends HttpServlet {

    /**
     * Handles the HTTP GET method by displaying the form to add a new author.
     * It forwards the request to the add-author.jsp page.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set a title for the page
        request.setAttribute("pageTitle", "Add New Author");
        // Forward to the JSP page to display the form
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/add-author.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP POST method by processing the submitted author data.
     * It validates the input and, if valid, calls the business logic to add the author.
     * It then forwards back to the JSP page to display a success or error message.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        
        request.setAttribute("pageTitle", "Add Author Result");

        try {
            if (fName == null || lName == null || fName.trim().isEmpty() || lName.trim().isEmpty()) {
                // Set an error message and forward back to the form
                request.setAttribute("errorMessage", "Both first name and last name are required.");
            } else {
                // Data is valid, proceed with business logic
                AuthorDTO author = new AuthorDTO();
                author.setFirstName(fName.trim());
                author.setLastName(lName.trim());

                AuthorBusinessLogic logic = new AuthorBusinessLogic();
                logic.addAuthor(author); // Assuming this can throw an exception on failure
                
                // Set a success message
                request.setAttribute("successMessage", "Author '" + fName + " " + lName + "' was added successfully!");
            }
        } catch (Exception e) {
            // Catch exceptions from the business layer (e.g., database errors)
            e.printStackTrace(); // Log the exception for debugging
            request.setAttribute("errorMessage", "An error occurred while adding the author. Please try again.");
        }
        
        // Forward to the JSP page to display the result
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/add-author.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for adding a new author and displaying results via a JSP view.";
    }
}