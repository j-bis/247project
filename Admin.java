import java.util.ArrayList;
import java.util.UUID;

public class Admin extends User {
    private final String TYPE;
    private String id;
    private String displayName;
    private String username;
    private String password;

    public Admin() {
        TYPE = "2";
        id = UUID.randomUUID().toString();
    }

    public Admin(String id, String displayName, String username, String password) {
        TYPE = "2";
        this.id = id;
        this.displayName = displayName;
        this.username = username;
        this.password = password;
    }

    /**
     * @return String
     */
    public String viewUsers() {
        return "";
    }

    /**
     * @return String
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * @return String
     */
    public String whatType() {
        return "Admin";
    }

    /**
     * @return String
     */
    public String getID() {
        return this.id;
    }

    /**
     * @return String
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @return String
     */
    public String getPass() {
        return this.password;
    }

    /**
     * @return String
     */
    public String getType() {
        return TYPE;
    }

    /**
     * @return String
     */
    public String toString() {
        return getID() + "\n" + getDisplayName() + "\n" + getUsername() + "\n" + getPass();
    }

    /**
     * @return boolean deleteUser
     */
    public boolean deleteUser() {
        return false;
    }

    /**
     * @return boolean checkVerified
     */
    @Override
    public boolean checkVerified() {
        return true;
    }

}
