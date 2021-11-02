import java.util.ArrayList;

public class Admin extends User{
    private final String type;
    private String id;
    private String displayName;
   // private String username;
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
    public String viewUsers() {
        return "";
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String whatType() {
        return "Admin";
    }

    public String getID() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPass() {
        return this.password;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return getID() + "\n" + getDisplayName() + "\n" + getUsername() + "\n"
        + getPass();
    }

    public boolean deleteUser() {
        return false;
    }

    @Override
    public boolean checkVerified() {
       return true;
    }
    
}
