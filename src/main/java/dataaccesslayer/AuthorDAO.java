package dataaccesslayer;
import transferobjects.AuthorDTO;
import java.util.List;

/**
 * DAO interface for operations related to the Authors table.
 */
public interface AuthorDAO {
    List<AuthorDTO> getAllAuthors();
    AuthorDTO getAuthorById(int id);
    void addAuthor(AuthorDTO author);
    void updateAuthor(AuthorDTO author);
    void deleteAuthor(int id);
}
