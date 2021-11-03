import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employer extends User {
    private final String type;
    private String id;
    private String displayName;
    private String username;
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
     * Verify takes an emailaddress and uses regular expression to make sure the
     * user entered a valid email for contact purposes source:
     * https://www.geeksforgeeks.org/check-email-address-valid-not-java/
     * 
     * @param emailAddress the email to verify
     * @return Returns true if valid, false otherwise
     */
    public boolean verify(String emailAddress) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(regex);
        if (emailAddress == null) {
            verified = false;
        } else if (pattern.matcher(emailAddress).matches()) {
            verified = true;
        }

        return verified;

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
     * @return Job addJobListing
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
     * @return ArrayList<Job>
     */
    public ArrayList<Job> getJob() {
        return myJobs;
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
