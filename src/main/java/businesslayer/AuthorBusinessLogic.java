package businesslayer;

import dataaccesslayer.AuthorDAOImpl;
import transferobjects.AuthorDTO;
import java.util.List;

/**
 * The {@code AuthorBusinessLogic} class serves as the business logic layer for operations
 * related to authors. It acts as an intermediary between the view layer (e.g., Servlets or JSP)
 * and the data access layer ({@link AuthorDAOImpl}).
 * <p>Each method delegates its operation to the corresponding method in {@code AuthorDAOImpl}.</p>
 * 
 * @author 
 *     Louis Tran
 * @version 
 *     1.0
 */
public class AuthorBusinessLogic {

    /** Data access object for author-related database operations. */
    private AuthorDAOImpl authorDAO = new AuthorDAOImpl();

    /**
     * Retrieves a list of all authors from the database.
     *
     * @return a {@code List<AuthorDTO>} containing all authors
     */
    public List<AuthorDTO> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }

    /**
     * Retrieves a specific author based on the provided ID.
     *
     * @param id the ID of the author to retrieve
     * @return an {@code AuthorDTO} object representing the author, or {@code null} if not found
     */
    public AuthorDTO getAuthorById(int id) {
        return authorDAO.getAuthorById(id);
    }

    /**
     * Adds a new author to the database.
     *
     * @param author an {@code AuthorDTO} object containing the author's information
     */
    public void addAuthor(AuthorDTO author) {
        authorDAO.addAuthor(author);
    }

    /**
     * Updates the information of an existing author in the database.
     *
     * @param author an {@code AuthorDTO} object containing the updated author details
     */
    public void updateAuthor(AuthorDTO author) {
        authorDAO.updateAuthor(author);
    }

    /**
     * Deletes an author from the database by ID.
     *
     * @param id the ID of the author to be deleted
     */
    public void deleteAuthor(int id) {
        authorDAO.deleteAuthor(id);
    }
}
