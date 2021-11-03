import java.util.ArrayList;
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
}
