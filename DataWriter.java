import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter {
    
    public static void saveUsers() {
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < users.size(); ++i) {
            jsonUsers.add(getUserJSON(users.get(i)));
        }

        writeToFile("usersTest.json", jsonUsers);
    }

    public static void saveJobs() {
        JobListings jobListing = JobListings.getInstance();
        ArrayList<Job> jobs = jobListing.getJobs();
        JSONArray jsonJobs = new JSONArray();
        
        for (int i = 0; i < jobs.size(); i++) {
            jsonJobs.add(getJobJSON(jobs.get(i)));
        }

        writeToFile("jobListingsTest.json", jsonJobs);

    }

    public static void saveResume() {
        ResumeList resumeList = ResumeList.getInstance();
        ArrrayList<Resume> resumes = resumeList.getResumes();
        JSONArray jsonResume = new JSONArray();

        for (int i = 0; i < resumes.size(); i++) {
            jsonResume.add(getResumeJSON(resumes.get(i)));
        }

        writeToFile("resumeTest.json", jsonResume);
    }

    public static void saveApplications() {
        ApplicationList applist = ApplicationList.getInstance();
        ArrayList<Application> applicant = applist.getApplicants();
        JSONArray jsonApplicants = new JSONArray();

        for (int i = 0; i < applicant.size(); i++) {
            jsonApplicants.add(getApplicantsJSON(applicant.get(i)));
        }

        writeToFile("applicationTest.json", jsonApplicants);
    }

    public static JSONObject getApplicantsJSON(Application application) {
        JSONObject applicantDetails = new JSONObject();
        applicantDetails.put("id", application.getID());
        applicantDetails.put("jobListing", application.getjobID());
        applicantDetails.put("applicants", application.getApplicants());

        return applicantDetails;
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put("id", user.getID());
        userDetails.put("type", user.getType());
		userDetails.put("displayName", user.getDisplayName());
		userDetails.put("username", user.getUsername());
		userDetails.put("password", user.getPass());

        if (user.getType().equals("0")) {
            userDetails.put("contactInfo", user.getContactInfo());
            userDetails.put("resumes", user.getResumesID());
        } else if (user.getType().equals("1")) {
            userDetails.put("jobListings", user.getJobID());
        }

        return userDetails;
    }

    public static JSONObject getJobJSON(Job job) {
        JSONObject jobDetails = new JSONObject();
        jobDetails.put("id", job.getID());
        jobDetails.put("title", job.getTitle());
        jobDetails.put("description", job.getDescription());
        return jobDetails;
    }

    private static void writeToFile(String fileName, JSONArray jsonArray) {
        try (FileWriter file = new FileWriter(fileName)) {

            file.write(jsonArray.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        saveUsers();
        saveJobs();
        // saveApplications();
        // saveResume();
    }
}
