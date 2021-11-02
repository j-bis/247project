import java.util.ArrayList;

public class Employer extends User {
    private final String type;
    private String id;
    private String displayName;
    //private String username;
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

    // public boolean verify() {
    //     return false;
    // }

    public String viewApplicants() {
        return "";
    }

    public String whatType() {
        return "Employer";
    }

    public Job addJobListing() {
        return new Job();
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

    public String getType() {
        return type;
    }

    public String toString() {
        return getID() + "\n" + getDisplayName() + "\n" + getUsername() + "\n"
        + getPass();
    }

    @Override
    public boolean checkVerified() {
        return verified;
    }
}
