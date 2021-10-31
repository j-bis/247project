import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Employer extends User {
    private final String type;
    private String id;
    private String displayName;
    private String username;
    private String password;
    private boolean verified = false;
    private ArrayList<Job> myJobs;

    public Employer(String id, String displayName, String username, String password, ArrayList<Job> myJobs) {
        type = "1";
        this.id = id;
        this.displayName = displayName;
        this.username = username;
        this.password = password;
        this.myJobs = myJobs;
    }

    // source: https://www.geeksforgeeks.org/check-email-address-valid-not-java/
    public boolean verify(String emailAddress) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                        "[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                        "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(regex);

        if (emailAddress == null) {
            verified = false;
        } else if (pattern.matcher(emailAddress).matches()) {
            verified = true;
        }

        return verified;
    }

    public String viewApplicants() {
        return "";
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

    public ArrayList<Job> getJob() {
        return myJobs;
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
