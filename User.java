import java.util.*;
public abstract class User {
    private String id;

    public User() {
    }

    public void verify() {
    }

    public ArrayList<String> getResumeView() {
        return null;
    }

    public ArrayList<String> getResumeView(String keyword) {
        return null;
    }

    public abstract String getID();
    
    public abstract String getType();

    public abstract boolean checkVerified();

    public abstract String getUsername();

    public abstract String getDisplayName();

    public abstract String getPass();

    public String getContactInfo() {
        return null;
    }

    public ArrayList<Resume> getResumes() {
        return null;
    }

    public ArrayList<Job> getJob() {
        return null;
    }

}
