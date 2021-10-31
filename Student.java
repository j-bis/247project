import java.util.ArrayList;
public class Student extends User {
    private final String type;
    private String id;
    private String displayName;
    private String username;
    private String password;
    //private boolean verified;
    private String contactInfo;
    private ArrayList<Resume> myResumes;

    public Student(String id, String displayName, String username, String password, String contactInfo, ArrayList<Resume> myResumes) {
        type = "0";
        this.id = id;
        this.displayName = displayName;
        this.username = username;
        this.password = password;
        this.contactInfo = contactInfo;
        this.myResumes = myResumes;
    }

    public void verify() {

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

    public ArrayList<Resume> getResumesID() {
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
}
