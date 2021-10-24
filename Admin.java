import java.util.ArrayList;

public class Admin extends User{
    private String id;
    private String displayName;
    private String username;
    private String password;

    public Admin(String id, String displayName, String username, String password) {
        this.id = id;
        this.displayName = displayName;
        this.username = username;
        this.password = password;
    }

    public String getDisplayName() {
        return this.displayName;
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

    public String toString() {
        return getID() + "\n" + getDisplayName() + "\n" + getUsername() + "\n"
        + getPass();
    }
    
}
