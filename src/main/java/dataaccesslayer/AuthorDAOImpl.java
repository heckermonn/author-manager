package dataaccesslayer;
import transferobjects.AuthorDTO;
import java.sql.*;
import java.util.*;

/**
 * Implementation of AuthorDAO interface
 */
public class AuthorDAOImpl implements AuthorDAO {
        @Override
    public List<AuthorDTO> getAllAuthors() {
        List<AuthorDTO> authors = new ArrayList<>();
        String sql = "SELECT * FROM authors";
        try {
            Connection conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                AuthorDTO author = new AuthorDTO();
                author.setAuthorID(rs.getInt("AuthorID"));
                author.setFirstName(rs.getString("FirstName"));
                author.setLastName(rs.getString("LastName"));
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public AuthorDTO getAuthorById(int id) {
        AuthorDTO author = null;
        String sql = "SELECT * FROM authors WHERE authorID = ?";
        try (Connection conn = DataSource.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) {
                author = new AuthorDTO();
                author.setAuthorID(Integer.valueOf(rs.getInt("authorID")));
                author.setFirstName(rs.getString("firstName"));
                author.setLastName(rs.getString("lastName"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    @Override
    public void addAuthor(AuthorDTO author) {
        String sql = "INSERT INTO Authors (FirstName, LastName) VALUES (?, ?)";
        try (Connection conn = DataSource.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, author.getFirstName());
            pstmt.setString(2, author.getLastName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAuthor(AuthorDTO author) {
        String sql = "UPDATE authors SET FirstName = ?, LastName = ? WHERE AuthorID = ?";
        try (Connection conn = DataSource.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, author.getFirstName());
            pstmt.setString(2, author.getLastName());
            pstmt.setInt(3, author.getAuthorID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAuthor(int id) {
        String sql = "DELETE FROM authors WHERE AuthorID = ?";
        try (Connection conn = DataSource.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
