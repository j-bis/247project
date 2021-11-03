import java.util.ArrayList;

public class Employer extends User {
    private final String type;
    private String id;
    private String displayName;
    private String password;
    private boolean verified;
    private ArrayList<Job> myJobs;

    public Employer() {
        type = "1";
    }

    public Employer(String id, String displayName, String username, String password, ArrayList<Job> myJobs) {
        type = "1";
        this.id = id;
        this.displayName = displayName;
        this.username = username;
        this.password = password;
        this.myJobs = myJobs;
    }

    /**
     * @return String viewApplicants
     */
    public String viewApplicants() {
        return "";
    }

    /**
     * @return String whatType
     */
    public String whatType() {
        return "Employer";
    }

    /**
     * @return Job
     */
    public Job addJobListing() {
        return new Job();
    }

    /**
     * @return String getDisplayName
     */
    public String getDisplayName() {
        return this.displayName;
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
     * @return boolean checkVerified
     */
    @Override
    public boolean checkVerified() {
        return verified;
    }
}
