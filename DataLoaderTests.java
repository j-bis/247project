import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTests {
    public UserList userlist;
    ArrayList<User> users;
    ArrayList<Resume> resumes;
    ArrayList<Student> students;
    ArrayList<Application> apps;
    ArrayList<Job> jobs;
    ApplicationList applicationList;
    JobListings jobListings;
    ResumeList resumeList;

    @BeforeEach
    public void setup() {
        jobListings = JobListings.getInstance();
        resumeList = ResumeList.getInstance();
        userlist = UserList.getInstance();
        applicationList = ApplicationList.getInstance();

        jobs = DataLoader.loadJobs();
        resumes = DataLoader.loadResumes();
        users = DataLoader.loadUsers();
        students = DataLoader.loadStudents();
        apps = DataLoader.loadApplications();
    }

    @Test
    public void testGetUserByUUID() {
        assertEquals("Aaron Longshore", userlist.getStudentById(UUID.fromString("2d6159e1-46d9-4248-8356-c9576cacf5a1")).getDisplayName());
    }

    @Test
    public void testGetUserSize() {
        assertEquals(6, users.size());
    }

    @Test
    public void testGetApplicationIDFromJobID() {
        assertEquals("44d5cd4b-de75-4261-a213-0c5afc537930", applicationList.getAppByJobID("d6383f24-c509-4ee3-84eb-8bda3946290b").getID());
    }

    @Test
    public void testGetJobTitle() {
        assertEquals("Internship: Graphic Design", jobListings.getJobByUUID(UUID.fromString("d6383f24-c509-4ee3-84eb-8bda3946290b")).getTitle());
    }

    @Test
    public void testGetJobsSizeThree() {
        DataWriter.save();
        assertEquals(3, jobs.size());
    }

    @Test
    public void testAddResume() {
        resumeList.addResume(new Resume());
        assertEquals(4, resumeList.getResumes().size());
    }
    
    @Test
    public void testLoadApplications() {
        assertEquals(3, applicationList.getApplicants().size());
    }

    @Test
    public void testLoadUsersAgain() {
        ArrayList<User> u2 = users;
        users = DataLoader.loadUsers();
        assertEquals(u2, users);
    }
}
