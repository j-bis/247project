import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * The datawriter class handles writing the users, resumes, joblistings and
 * applications to a json file to be loaded during next program launch. It also
 * has a file out operation that prints the resume to a text file.
 */
public class DataWriter {

    /**
     * The saveUsers method loops through the userlist and stores the users and the
     * data in a jsonArray that is then saved to a json file.
     */
    public static void saveUsers() {
        ResumeList resumeList = ResumeList.getInstance();
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < users.size(); ++i) {
            jsonUsers.add(getUserJSON(users.get(i)));
        }

        writeJsonToFile("usersTest.json", jsonUsers);
    }

    /**
     * The savejobs method loops through the job listings and stores the jobs in a
     * jsonarray that is then passed to the writejsonfile method to be saved as a
     * json file.
     */
    public static void saveJobs() {
        JobListings jobListing = JobListings.getInstance();
        ArrayList<Job> jobs = jobListing.getJobs();
        JSONArray jsonJobs = new JSONArray();

        for (int i = 0; i < jobs.size(); i++) {
            jsonJobs.add(getJobJSON(jobs.get(i)));
        }

        writeJsonToFile("jobListingsTest.json", jsonJobs);

    }

    /**
     * The saveResume method loops through the resumes and stores the resumes in a
     * jsonarray that is then passed to the writejsonfile method to be saved as a
     * json file.
     */
    public static void saveResume() {
        ResumeList resumeList = ResumeList.getInstance();
        ArrayList<Resume> resumes = resumeList.getResumes();
        JSONArray jsonResume = new JSONArray();

        for (int i = 0; i < resumes.size(); i++) {
            jsonResume.add(getResumeJSON(resumes.get(i)));
        }

        writeJsonToFile("resumeTest.json", jsonResume);
    }

    /**
     * The saveApplications method loops through the applicants and stores the
     * applicants in a jsonarray that is then passed to the writejsonfile method to
     * be saved as a json file.
     */
    public static void saveApplications() {
        UserList userList = UserList.getInstance();
        ResumeList resumeList = ResumeList.getInstance();
        ApplicationList applist = ApplicationList.getInstance();
        ArrayList<Application> applicant = applist.getApplicants();
        JSONArray jsonApplicants = new JSONArray();

        for (int i = 0; i < applicant.size(); i++) {
            jsonApplicants.add(getApplicantsJSON(applicant.get(i)));
        }

        writeJsonToFile("applicationTest.json", jsonApplicants);
    }

    /**
     * The getResumeJson is a helper method for saveResumes that takes in a a resume
     * and loops through the resume to get each section and put it in a jsonobject.
     * 
     * @param resume the student resume to loop through
     * @return a json json object
     */
    public static JSONObject getResumeJSON(Resume resume) {
        JSONObject resumeDetails = new JSONObject();
        resumeDetails.put("itemId", resume.getID());
        resumeDetails.put("title", resume.getTitle());

        JSONArray eduJSONArray = new JSONArray();
        ArrayList<Education> eduArray = resume.getEducation();
        for (int i = 0; i < eduArray.size(); i++) {
            Education edu = eduArray.get(i);
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
        for (int i = 0; i < skillsArray.size(); i++) {
            skillsJsonArray.add(skillsArray.get(i));
        }
        resumeDetails.put("skills", skillsJsonArray);

        return resumeDetails;
    }

    /**
     * 
     * @param application
     * @return
     */
    public static JSONObject getApplicantsJSON(Application application) {
        JSONObject applicantDetails = new JSONObject();
        applicantDetails.put("id", application.getID());
        applicantDetails.put("jobListing", application.getjobID());

        JSONArray appJSONArray = new JSONArray();
        ArrayList<Student> applicant = application.getApplicants();
        ArrayList<Resume> appResume = application.getResumes();
        for (int i = 0; i < applicant.size(); i++) {
            JSONObject stuObject = new JSONObject();
            stuObject.put("user", applicant.get(i).getID());
            stuObject.put("resume", appResume.get(i).getID());
            appJSONArray.add(stuObject);
        }

        applicantDetails.put("applicants", appJSONArray);

        return applicantDetails;
    }

    /**
     * 
     * @param user
     * @return
     */
    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put("id", user.getID());
        userDetails.put("type", user.getType());
        userDetails.put("displayName", user.getDisplayName());
        userDetails.put("username", user.getUsername());
        userDetails.put("password", user.getPass());

        if (user.getType().equals("0")) {
            userDetails.put("contactInfo", user.getContactInfo());

            JSONArray userResArray = new JSONArray();
            ArrayList<Resume> resume = user.getResumes();
            for (int i = 0; i < resume.size(); i++) {
                userResArray.add(resume.get(i).getID());
            }

            userDetails.put("resume", userResArray);

        } else if (user.getType().equals("1")) {
            JSONArray userJsonArray = new JSONArray();
            ArrayList<Job> job = user.getJob();
            for (int i = 0; i < job.size(); i++) {
                userJsonArray.add(job.get(i).getID());
            }

            userDetails.put("jobListings", userJsonArray);
        }

        return userDetails;
    }

    /**
     * 
     * @param job
     * @return
     */
    public static JSONObject getJobJSON(Job job) {
        JSONObject jobDetails = new JSONObject();
        jobDetails.put("id", job.getID());
        jobDetails.put("title", job.getTitle());
        jobDetails.put("description", job.getDescription());
        return jobDetails;
    }

    /**
     * 
     * @param student
     * @param idxResume
     */
    public static void writeResumeToTxtFile(User student, int idxResume) {
        ArrayList<Resume> stuResumes = student.getResumes();
        try (FileWriter file = new FileWriter("Resume.txt")) {
            file.write(student.getContactInfo());
            file.write("\n**********************************\n");
            file.write(stuResumes.get(idxResume).toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void save() {
        saveApplications();
        saveJobs();
        saveUsers();
        saveResume();
    }

    /**
     * 
     * @param fileName
     * @param jsonArray
     */
    private static void writeJsonToFile(String fileName, JSONArray jsonArray) {
        try (FileWriter file = new FileWriter(fileName)) {

            file.write(jsonArray.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        saveJobs();
        saveUsers();
        saveResume();
        saveApplications();

        ArrayList<Student> student = DataLoader.loadStudents();
        Student stu1 = student.get(0);
        writeResumeToTxtFile(stu1, 0);
    }
}
