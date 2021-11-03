import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends User {
    private final String type;
    private String id;
    private String displayName;
    private String username;
    private String password;
    private boolean verified = false;
    private String contactInfo;
    private ArrayList<Resume> myResumes;


    public Student() {
        type = "0";
        id = UUID.randomUUID().toString();
    }

    public Student(String id, String displayName, String username, String password, String contactInfo, ArrayList<Resume> myResumes) {
        type = "0";
        this.id = id;
        this.displayName = displayName;
        this.username = username;
        this.password = password;
        this.contactInfo = contactInfo;
        this.myResumes = myResumes;
    }

    /**
     * Verify takes an emailaddress and uses regular expression 
     * to make sure the user entered a valid email for contact purposes
     * source: https://www.geeksforgeeks.org/check-email-address-valid-not-java/
     * @param emailAddress the email to verify
     * @return Returns true if valid, false otherwise
     */
    public boolean verify(String emailAddress) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                        "[a-zA-Z0-9_+&*-]+)*@email.sc.edu";
        
        Pattern pattern = Pattern.compile(regex);
        if (emailAddress == null) {
            verified = false;
        } else if (pattern.matcher(emailAddress).matches()) {
            verified = true;
        }
        
        return verified;
    }

    public String whatType() {
        return "Student";
    }

    public ResumeEditor addResume() {
        return new ResumeEditor();
    }

    public boolean deleteResume() {
        return false;
    }

    public ResumeEditor editResume() {
        return new ResumeEditor();
    }

    public String submitResume() {
        return "";
    }

    public String searchEmployers() {
        return "";
    }

    public String viewJobs() {
        return "";
    }

    public ArrayList<Resume> getResumes() {
        return myResumes;
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

    public String getContactInfo() {
        return getDisplayName() + "\n" + this.contactInfo;
    }

    public String getType() {
        return type;
    }
    
    public String toString() {
        return getID() + "\n" + getContactInfo() + "\n" + getUsername() + "\n"
        + getPass();
    }

    @Override
    public boolean checkVerified() {
        return verified;
    }

    /**
     * @param displayName the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return boolean return the verified
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * @param verified the verified to set
     */
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    /**
     * @param contactInfo the contactInfo to set
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }


}
