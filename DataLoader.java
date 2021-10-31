import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader {

    public static ArrayList<Job> loadJobs() {
        ArrayList<Job> jobList = new ArrayList<Job>();

        try {
            FileReader reader = new FileReader("jobListings.json");
            JSONParser parser = new JSONParser();
            JSONArray jobsJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < jobsJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)jobsJSON.get(i);
				String id = (String)personJSON.get("id");
				String title = (String)personJSON.get("title");
				String description = (String)personJSON.get("description");
				
				jobList.add(new Job(id, title, description));
            }

        return jobList;
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }

    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            FileReader reader = new FileReader("users.json");
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray)new JSONParser().parse(reader);
            
            for(int i=0; i < userJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)userJSON.get(i);
                if (Integer.parseInt((String)personJSON.get("type")) == 0) {
                    String id = (String)personJSON.get("id");
                    String displayName = (String)personJSON.get("displayName");
                    String username = (String)personJSON.get("username");
                    String password = (String)personJSON.get("password");
                    String contactInfo = (String)personJSON.get("contactInfo");

                    JSONArray resumeArray = (JSONArray)personJSON.get("resumes");
                    ArrayList<Resume> myResumes = new ArrayList<Resume>();

                    for (int j=0; j<resumeArray.size(); j++) {
                        myResumes.add(ResumeList.getResumeByUUID((UUID.fromString((String)resumeArray.get(j)))));
                    }
                    
                    students.add(new Student(id, displayName, username, password, contactInfo, myResumes));
                }
            }
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            }
    return null;
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader("users.json");
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < userJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)userJSON.get(i);
                //System.out.println(i);
                if (Integer.parseInt((String)personJSON.get("type")) == 0) {
                    String id = (String)personJSON.get("id");
                    String displayName = (String)personJSON.get("displayName");
                    String username = (String)personJSON.get("username");
                    String password = (String)personJSON.get("password");
                    String contactInfo = (String)personJSON.get("contactInfo");

                    JSONArray resumeArray = (JSONArray)personJSON.get("resumes");
                    ArrayList<Resume> myResumes = new ArrayList<Resume>();

                    for (int j=0; j<resumeArray.size(); j++) {
                        myResumes.add(ResumeList.getResumeByUUID((UUID.fromString((String)resumeArray.get(j)))));
                    }

                    users.add(new Student(id, displayName, username, password, contactInfo, myResumes));
                } else if (Integer.parseInt((String)personJSON.get("type")) == 1) {
                    String id = (String)personJSON.get("id");
                    String displayName = (String)personJSON.get("displayName");
                    String username = (String)personJSON.get("username");
                    String password = (String)personJSON.get("password");

                    JSONArray jobsArray = (JSONArray)personJSON.get("jobListings");
                    //ArrayList<UUID> jobIDs = new ArrayList<UUID>();
                    ArrayList<Job> MyJobs = new ArrayList<Job>();

                    //converts jsonobject at j to string then to uuid then gets job by uuid from jobListings and adds it to myJobs
                    for (int j=0;j<jobsArray.size();j++) {
                        //System.out.println((String)jobsArray.get(j));
                        MyJobs.add(JobListings.getJobByUUID((UUID.fromString((String)jobsArray.get(j)))));
                    }
                    users.add(new Employer(id, displayName, username, password, MyJobs));
                } else {
                    String id = (String)personJSON.get("id");
                    String displayName = (String)personJSON.get("displayName");
                    String username = (String)personJSON.get("username");
                    String password = (String)personJSON.get("password");

                    users.add(new Admin(id, displayName, username, password));
                }
				
            }

        return users;
        } catch (Exception e) {
            e.printStackTrace();
            }
    return null;
    }

    public static ArrayList<Resume> loadResumes() {
        ArrayList<Resume> resumes = new ArrayList<Resume>();

        try {
                    FileReader reader = new FileReader("resumes.json");
                    JSONParser parser = new JSONParser();
                    JSONArray jobsJSON = (JSONArray)new JSONParser().parse(reader);
        
                    for(int i=0; i < jobsJSON.size(); i++) {
            			JSONObject personJSON = (JSONObject)jobsJSON.get(i);
            			String id = (String)personJSON.get("itemId");
            			String title = (String)personJSON.get("title");
                        ArrayList<Education> educationArray = new ArrayList<Education>();
                        ArrayList<Experience> experienceArray = new ArrayList<Experience>();

                        JSONArray educations = (JSONArray)personJSON.get("education");
                        for (int j=0;j<educations.size();j++) {
                            JSONObject education = (JSONObject)educations.get(j);
                            String school = (String)education.get("school");
                            String degree = (String)education.get("degree");
                            String gpa = (String)education.get("gpa");
                            educationArray.add(new Education(school, degree, gpa));
                        }
                        JSONArray experiences = (JSONArray)personJSON.get("experience");
                        for (int j=0;j<experiences.size();j++) {
                            JSONObject experience = (JSONObject)experiences.get(j);
                            String ExperienceTitle = (String)experience.get("title");
                            String duties = (String)experience.get("duties");
                            String company = (String)experience.get("company");
                            experienceArray.add(new Experience(ExperienceTitle, duties, company));
                        }

                        JSONArray skills = (JSONArray)personJSON.get("skills");
                        ArrayList<String> skillsAL = new ArrayList<String>();
                        for (int j = 0; j< skills.size(); j++) {
                            skillsAL.add((String)skills.get(j));
                        } 

            			resumes.add(new Resume(id, title, experienceArray, educationArray, skillsAL));
                    }
        
                return resumes;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            return null;
    }

    public static ArrayList<Application> loadApplications() {
        ArrayList<Application> apps = new ArrayList<Application>();

        try {
            FileReader reader = new FileReader("applications.json");
            JSONParser parser = new JSONParser();
            JSONArray jobsJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < jobsJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)jobsJSON.get(i);
				String id = (String)personJSON.get("id");
				String jobListing = (String)personJSON.get("jobListing");
				JSONArray entries = (JSONArray)personJSON.get("applicants");

                ArrayList<UUID> applicantIDs = new ArrayList<UUID>();
                ArrayList<UUID> resumeIDs = new ArrayList<UUID>();
                
                ArrayList<Student> applicants = new ArrayList<Student>();
                ArrayList<Resume> resumes = new ArrayList<Resume>();

                for (int j=0;j<entries.size();j++) {
                    JSONObject IDs = (JSONObject)entries.get(j);
                    //String applicantID = (String)IDs.get("user");
                    //String resumeID = (String)IDs.get("resume");
                    applicantIDs.add(UUID.fromString((String)IDs.get("user")));
                    resumeIDs.add(UUID.fromString((String)IDs.get("resume")));
                }
                for (int j=0;j<applicantIDs.size();j++) {
                    //System.out.println(j);
                    applicants.add(UserList.getStudentById(applicantIDs.get(j)));
                    resumes.add(ResumeList.getResumeByUUID(resumeIDs.get(j)));
                }

                //ArrayList<User> users = loadUsers();
                
				apps.add(new Application(id, jobListing, applicants, resumes));
            }

        return apps;
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }

    public static void main(String[] args) {

        //in facade load jobs > resumes > users > applicants
        JobListings jobListings = JobListings.getInstance();
        ResumeList resumeList = ResumeList.getInstance();
        UserList userlist = UserList.getInstance();
        ApplicationList applicationList = ApplicationList.getInstance();

        ArrayList<Job> jobs = loadJobs();
        ArrayList<Resume> resumes = loadResumes();
        ArrayList<User> users = loadUsers();
        ArrayList<Student> students = loadStudents();
        ArrayList<Application> apps = loadApplications();
        
        for (int i = 0; i < jobs.size(); i++) {
            System.out.println(jobs.get(i));
        }

        System.out.println("\nUSERS\n");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i) + "\n");
        }

        System.out.println("\nstudents\n");
        for (Student i : students) {
            System.out.println(i.getContactInfo() + "\n");
        }

        System.out.println("\napplications\n");
        for (Application i : apps) {
            System.out.println(i + "\n");
        }

        System.out.println("\nRESUMES\n");
        for (Resume i : resumes) {
            System.out.println(i + "\n");
        }
    }
}