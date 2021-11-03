import java.util.ArrayList;

public class ApplicationList {
    private static ApplicationList appList;
    private static ArrayList<Application> applicants;

    private ApplicationList() {
        applicants = DataLoader.loadApplications();
    }

    public static ApplicationList getInstance() {
        if (appList == null) {
            appList = new ApplicationList();
        }

        return appList;
    }

    public static ArrayList<Application> getApplicants() {
        return applicants;
    }

    public boolean addApplication(String id, String jobListingID, ArrayList<Student> applicant, ArrayList<Resume> resumes) {
        if (id.equals("") || jobListingID.equals("") || applicant.isEmpty() || resumes.isEmpty()) {
            return false;
        }
        
        applicants.add(new Application(id, jobListingID, applicant, resumes));
        return true;
    }

    public void saveApplicants() {
        DataWriter.saveApplications();
    }

    public static void addApplicant(String jobID, String studentID, String resumeID) {
        for (Application a : applicants) {
            if (jobID.equals(a.getID())) {
                a.applicants.add(studentID);
                a.resumes.add(resumeID);
            }
        }
    } 
}
