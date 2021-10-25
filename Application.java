import java.util.ArrayList;
public class Application {
    private String id;
    private String jobListingID;
    private ArrayList<String> applicants;
    private ArrayList<String> resumes;

    public Application(String id, String jobListingID, ArrayList<String> applicants, ArrayList<String> resumes) {
        this.id = id;
        this.jobListingID = jobListingID;
        this.applicants = applicants;
        this.resumes = resumes;
    }

    public String getID() {
        return this.id;
    }

    public String getjobID() {
        return this.jobListingID;
    }

    public String printAppsAndResumes() {
        return "";
    }
}
