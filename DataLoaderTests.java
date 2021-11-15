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

    @BeforeEach
    public void setup() {
        JobListings jobListings = JobListings.getInstance();
        ResumeList resumeList = ResumeList.getInstance();
        UserList userlist = UserList.getInstance();
        ApplicationList applicationList = ApplicationList.getInstance();

        ArrayList<Job> jobs = DataLoader.loadJobs();
        ArrayList<Resume> resumes = DataLoader.loadResumes();
        ArrayList<User> users = DataLoader.loadUsers();
        ArrayList<Student> students = DataLoader.loadStudents();
        ArrayList<Application> apps = DataLoader.loadApplications();
    }

    @Test
    public void getUserByUUIDtest() {
        assertEquals("Aaron Longshore", userlist.getStudentById(UUID.fromString("2d6159e1-46d9-4248-8356-c9576cacf5a1")).getDisplayName());
    }

    @Test
    public void 
    
}
