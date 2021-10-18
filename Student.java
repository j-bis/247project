import java.util.ArrayList;
public class Student {
    private String displayName;
    private String username;
    private String password;
    private boolean verified;
    private ArrayList<Resume> myResumes;

    public Student() {

    }

    public boolean verify() {
        return false;
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
        return '';
    }

    public String viewJobs() {
        return "";
    }

    public String getDisplayName() {
        return "";
    }
    
}
