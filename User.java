import java.util.*;

public abstract class User {
    private String id;

    public User() {
    }

    public void verify() {
    }

    /**
     * @return ArrayList<String>
     */
    public ArrayList<String> getResumeView() {
        return null;
    }

    /**
     * @param keyword
     * @return ArrayList<String>
     */
    public ArrayList<String> getResumeView(String keyword) {
        return null;
    }

    /**
     * @param getPass
     * @return String
     */
    public abstract String getID();

    /**
     * @param getPass
     * @return String
     */
    public abstract String getType();

    /**
     * @param getPass
     * @return String
     */
    public abstract String whatType();

    /**
     * @param getPass
     * @return boolean
     */
    public abstract boolean checkVerified();

    /**
     * @param getPass
     * @return String
     */
    public abstract String getUsername();

    /**
     * @param getPass
     * @return String
     */
    public abstract String getDisplayName();

    /**
     * @return String getPass
     */
    public abstract String getPass();

    public String getContactInfo() {
        return null;
    }

    /**
     * @return ArrayList<Resume>
     */
    public ArrayList<Resume> getResumes() {
        return null;
    }

    public ArrayList<Job> getJob() {
        return null;
    }

}
