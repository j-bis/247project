import java.util.ArrayList;

public class Employer implements User {
    private String displayName;
    private String username;
    private String password;
    private boolean verified;
    private ArrayList<Job> myJobs;

    public Employer() {}

    public boolean verify() {
        return false;
    }

    public String viewApplicants() {
        return "";
    }

    public Job addJobListing() {
        return new Job();
    }
}
