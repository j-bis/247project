import java.util.ArrayList;

public class ApplicationList {
    private static ApplicationList appList;
    private ArrayList<Application> applicants;

    private ApplicationList() {
        applicants = DataLoader.loadApplications();
    }

    public static ApplicationList getInstance() {
        if (appList == null) {
            appList = new ApplicationList();
        }

        return appList;
    }

    public ArrayList<Application> getApplicants() {
        return applicants;
    }

    public boolean addApplication(String id, String jobListingID, ArrayList<String> applicant, ArrayList<String> resumes) {
        if (id.equals("") || jobListingID.equals("") || applicant.isEmpty() || resumes.isEmpty()) {
            return false;
        }
        
        applicants.add(new Application(id, jobListingID, applicant, resumes));
        return true;
    }

    public void saveApplicants() {
        DataWriter.saveApplications();
    }
}
