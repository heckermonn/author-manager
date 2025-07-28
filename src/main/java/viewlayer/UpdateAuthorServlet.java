package viewlayer;

import businesslayer.AuthorBusinessLogic;
import transferobjects.AuthorDTO;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet responsible for updating an author.
 *
 * GET: Prompts for an author ID or fetches author info if ID is provided.<br>
 * POST: Updates the author based on submitted form fields.
 *
 * @author Louis Tran  
 * Student Number: 041072185  
 * Lab Section: 013 CST8288
 */
public class UpdateAuthorServlet extends HttpServlet {

    /**
     * Handles GET requests. Prompts user to enter author ID or fetches the author if ID is supplied.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");

        if (idParam == null) {
            // No ID provided, show search form
            request.getRequestDispatcher("/WEB-INF/findAuthor.jsp").forward(request, response);
        } else {
            try {
                int id = Integer.parseInt(idParam);
                AuthorBusinessLogic logic = new AuthorBusinessLogic();
                AuthorDTO author = logic.getAuthorById(id);
                request.setAttribute("author", author);
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Invalid ID format.");
            }
            request.getRequestDispatcher("/WEB-INF/updateAuthor.jsp").forward(request, response);
        }
    }

    /**
     * Handles POST requests to update an author's first and last name.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String authorID = request.getParameter("authorID");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");

        boolean success = false;
        String message;

        try {
            int id = Integer.parseInt(authorID);
            if (fName == null || lName == null || fName.isEmpty() || lName.isEmpty()) {
                message = "Both fields must not be empty.";
            } else {
                AuthorDTO author = new AuthorDTO();
                author.setAuthorID(id);
                author.setFirstName(fName);
                author.setLastName(lName);
                new AuthorBusinessLogic().updateAuthor(author);
                success = true;
                message = "Author updated successfully.";
            }
        } catch (NumberFormatException e) {
            message = "Invalid ID format.";
        }

        request.setAttribute("message", message);
        request.setAttribute("success", success);
        request.getRequestDispatcher("/WEB-INF/updateResult.jsp").forward(request, response);
    }

    /**
     * Provides a short description of this servlet.
     */
    @Override
    public String getServletInfo() {
        return "Servlet for updating an author's information.";
    }
}
