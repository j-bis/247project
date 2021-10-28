import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

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
        ArrayList<Resume> resumes = resumeList.getResumes();
        JSONArray jsonResume = new JSONArray();

        for (int i = 0; i < resumes.size(); i++) {
            jsonResume.add(getResumeJSON(resumes.get(i)));
        }

        writeToFile("resumeTest.json", jsonResume);
    }

    public static void saveApplications() {
        UserList userList = UserList.getInstance();
        ApplicationList applist = ApplicationList.getInstance();
        ArrayList<Application> applicant = applist.getApplicants();
        JSONArray jsonApplicants = new JSONArray();

        for (int i = 0; i < applicant.size(); i++) {
            jsonApplicants.add(getApplicantsJSON(applicant.get(i)));
        }

        writeToFile("applicationTest.json", jsonApplicants);
    }

    public static JSONObject getResumeJSON(Resume resume) {
        JSONObject resumeDetails = new JSONObject();
        resumeDetails.put("itemId", resume.getID());
        resumeDetails.put("title", resume.getTitle());
        
        JSONArray eduJSONArray = new JSONArray();
        ArrayList<Education> eduArray = resume.getEducation();
        for (int i = 0; i < eduArray.size(); i++) {
            Education edu = eduArray.get(i)
            JSONObject eduObject = new JSONObject();
            eduObject.put("school", edu.getSchool());
            eduObject.put("degree", edu.getDegree());
            eduObject.put("gpa", edu.getGpa());

            eduJSONArray.add(eduObject);
        }     
        resumeDetails.put("education", eduJSONArray);

        JSONArray expJSONArray = new JSONArray();
        ArrayList<Experience> expArray = resume.getExperience();
        for (int i = 0; i < expArray.size(); i++) {
            Experience exp = expArray.get(i);
            JSONObject expObject = new JSONObject();
            expObject.put("title", exp.getTitle());
            expObject.put("duties", exp.getDuties());
            expObject.put("company", exp.getCompany());

            expJSONArray.add(expObject);
        }
        resumeDetails.put("experience", expJSONArray);


        JSONArray skillsJsonArray = new JSONArray();
        ArrayList<String> skillsArray = resume.getSkills();
        expJSONArray.add(skillsArray);
        resumeDetails.put("skills", expJSONArray.toJSONString());

        return resumeDetails;    
    }

    public static JSONObject getApplicantsJSON(Application application) {
        JSONObject applicantDetails = new JSONObject();
        applicantDetails.put("id", application.getID());
        applicantDetails.put("jobListing", application.getjobID());
        
        JSONArray appJSONArray = new JSONArray();
        ArrayList<Student> applicant = application.getApplicants();
        for (int i = 0; i < applicant.size(); i++) {
            Student stu = applicant.get(i);
            JSONObject stuObject = new JSONObject();
            stuObject.put("user", stu.getID());
            stuObject.put("resume", stu.getResumesID());
            appJSONArray.add(stuObject);
        }

        applicantDetails.put("applicants", appJSONArray);

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
            userDetails.put("contactInfo", user.getContactInfo()); // Asks about saving display name in contact info

        } else if (user.getType().equals("1")) {
            userDetails.put("jobListings", user.getJobID()); // Ask about saving job listings under users
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
        // saveJobs();
        // saveApplications();
        // saveResume();
    }
}
