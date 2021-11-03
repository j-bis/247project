import java.util.ArrayList;

public class Admin extends User {
    private final String type;
    private String id;
    private String displayName;
    private String password;

    public Admin() {
        type = "2";
    }

    public Admin(String id, String displayName, String username, String password) {
        type = "2";
        this.id = id;
        this.displayName = displayName;
        this.username = username;
        this.password = password;
    }

    /**
     * @return String viewUsers
     */
    public String viewUsers() {
        return "";
    }

    /**
     * @return String getDisplayName
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * @return String whatType
     */
    public String whatType() {
        return "Admin";
    }

    /**
     * @return String getID
     */
    public String getID() {
        return this.id;
    }

    /**
     * @return String getUsername
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @return String getPass
     */
    public String getPass() {
        return this.password;
    }

    /**
     * @return String getType
     */
    public String getType() {
        return type;
    }

    /**
     * @return String toString
     */
    public String toString() {
        return getID() + "\n" + getDisplayName() + "\n" + getUsername() + "\n" + getPass();
    }

    /**
     * @return boolean delteUser
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
