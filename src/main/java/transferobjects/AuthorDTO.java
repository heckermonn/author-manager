package transferobjects;

/**
 * Lab Section: 013 CST8288
 * @author Louis Tran 041072185
 * 
 * Data Transfer Object
 */
public class AuthorDTO {  
    private int authorID;
    private String firstName;
    private String lastName;
   
     /**
     * @return the author ID
     */
    public int getAuthorID() { 
        return authorID; 
    }
    
    /**
     * @param authorID the author ID to set
     */
    public void setAuthorID(int authorID) { 
        this.authorID = authorID; 
    }
    
    /**
     * @return the first name
     */
    public String getFirstName() { 
        return firstName; 
    }
    
    /**
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    }
    
    /**
     * @return the last name
     */
    public String getLastName() { return lastName; }
    
    /**
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }
    

}
