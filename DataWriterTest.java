import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import javax.xml.crypto.Data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataWriterTest {
    private JobListings jList = JobListings.getInstance();
    private ResumeList rList = ResumeList.getInstance();
    private UserList uList = UserList.getInstance();
    private ApplicationList aList = ApplicationList.getInstance();
    private ArrayList<User> userList = uList.getUsers();
    private ArrayList<Job> jobList = jList.getJobs();
    private ArrayList<Resume> resumeList = rList.getResumes();
    private ArrayList<Application> appList = aList.getApplicants();

    @BeforeEach
    public void setup() {
        UserList.getInstance().getUsers().clear();
        JobListings.getInstance().getJobs().clear();
        ResumeList.getInstance().getResumes().clear();
        ApplicationList.getInstance().getApplicants().clear();
        DataWriter.saveUsers();
        DataWriter.saveJobs();
        DataWriter.saveResume();
        DataWriter.saveApplications();
    }

    @AfterEach
	public void tearDown() {
		UserList.getInstance().getUsers().clear();
        JobListings.getInstance().getJobs().clear();
        ResumeList.getInstance().getResumes().clear();
        ApplicationList.getInstance().getApplicants().clear();
		DataWriter.saveUsers();
        DataWriter.saveJobs();
        DataWriter.saveResume();
        DataWriter.saveApplications();
	}

    @Test
	void testWritingZeroUsers() {
		userList = DataLoader.loadUsers();
		assertEquals(0, userList.size());
	}

    @Test
	void testWritingOneStudent() {
        String id = UUID.randomUUID().toString();
        ArrayList<Resume> testList = rList.getResumes();
		userList.add(new Student(id, "Amy Smith", "asmith", "qwerty1234", "803-454-3344", testList));
		DataWriter.saveUsers();
		assertEquals("asmith", DataLoader.loadUsers().get(0).getUsername());
	}

    @Test
    void testWritingOneEmployer() {
        String id = UUID.randomUUID().toString();
        ArrayList<Job> testList = jList.getJobs();
		userList.add(new Employer(id, "Amy Smith", "asmith", "qwerty1234", testList));
		DataWriter.saveUsers();
		assertEquals("asmith", DataLoader.loadUsers().get(0).getUsername());
	}

    @Test
    void testWritingOneAdmin() {
        String id = UUID.randomUUID().toString();
		userList.add(new Admin(id, "Amy Smith", "asmith", "qwerty1234"));
		DataWriter.saveUsers();
		assertEquals("asmith", DataLoader.loadUsers().get(0).getUsername());
	}

    @Test
    void testWritingFiveUser() {
        ArrayList<String> testIDs = getUuids(5);
        ArrayList<Resume> testResList = rList.getResumes();
        ArrayList<Job> testJobList = jList.getJobs();
        userList.add(new Student(testIDs.get(0), "Amy Smith", "asmith", "qwerty1234", "803-454-3344", testResList));
        userList.add(new Employer(testIDs.get(1), "Amy Smith", "bsmith", "qwerty1234", testJobList));
		userList.add(new Admin(testIDs.get(2), "Amy Smith", "csmith", "qwerty1234"));
        userList.add(new Student(testIDs.get(3), "Amy Smith", "dsmith", "qwerty1234", "803-454-3344", testResList));
        userList.add(new Employer(testIDs.get(4), "Amy Smith", "esmith", "qwerty1234", testJobList));
        DataWriter.saveUsers();
        assertEquals("esmith", DataLoader.loadUsers().get(4).getUsername());
    }


    @Test
	void testWritingEmptyUser() {
		userList.add(new Admin("", "", "", ""));
		DataWriter.saveUsers();
		assertEquals("", DataLoader.loadUsers().get(0).getUsername());
	}

    @Test
	void testWritingNullUser() {
        String id = UUID.randomUUID().toString();
        ArrayList<Resume> testList = rList.getResumes();
        userList.add(new Student(null, null, null, null, null, null));
		DataWriter.saveUsers();
		assertEquals(null, DataLoader.loadUsers().get(0).getUsername());
	}

    @Test
    void testWritingZeroJobs() {
        jobList = DataLoader.loadJobs();
        assertEquals(0, jobList.size());
    }

    @Test
    void testWritingOneJob() {
        String id = UUID.randomUUID().toString();
        jobList.add(new Job(id, "Internship for Google", "make stuff"));
        DataWriter.saveJobs();
        assertEquals("Internship for Google", DataLoader.loadJobs().get(0).getTitle());
    }

    @Test
    void testWritingFiveJobs() {
        ArrayList<String> testJobIds = getUuids(5);
        jobList.add(new Job(testJobIds.get(0), "Internship for Google", "make stuff"));
        jobList.add(new Job(testJobIds.get(1), "Internship for Microsoft", "make stuff"));
        jobList.add(new Job(testJobIds.get(2), "Internship for Amazon", "make stuff"));
        jobList.add(new Job(testJobIds.get(3), "Internship for UofSC", "make stuff"));
        jobList.add(new Job(testJobIds.get(4), "Internship for Tesla", "make other stuff"));
        DataWriter.saveJobs();
        assertEquals("Internship for Tesla", DataLoader.loadJobs().get(4).getTitle());
    }

    @Test
    void testWritingEmptyJob() {
        jobList.add(new Job("", "", ""));
        DataWriter.saveJobs();
        assertEquals("", DataLoader.loadJobs().get(0).getTitle());
    }

    @Test
    void testWritingNullJob() {
        jobList.add(new Job(null, null, null));
        DataWriter.saveJobs();
        assertEquals(null, DataLoader.loadJobs().get(0).getTitle());
    }

    @Test
    void testWritingZeroResumes() {
        resumeList = DataLoader.loadResumes();
        assertEquals(0, resumeList.size());
    }

    @Test
    void testWritingOneResume() {
        ArrayList<Experience> expTest = new ArrayList<Experience>();
        ArrayList<Education> eduTest = new ArrayList<Education>();
        ArrayList<String> skillTest = new ArrayList<String>();
        ArrayList<String> duties = new ArrayList<String>();
        duties.add("Create a Python program to predict clients needs.");
        Experience experience1 = new Experience("Software Dev", duties, "J.P. Morgan", "Internship", "May 2019");
        expTest.add(experience1);
        Education education1 = new Education("UofSC", "Bachelors of Computer Science", "May 2023");
        eduTest.add(education1);
        skillTest.add("Java");
        skillTest.add("C++");
        skillTest.add("Python");
        resumeList.add(new Resume("test Resume", expTest, eduTest, skillTest));
        DataWriter.saveResume();
        assertEquals("test Resume", DataLoader.loadResumes().get(0).getTitle());   
    }

    @Test
    void testWritingFiveResumes() {
        ArrayList<Experience> expTest = new ArrayList<Experience>();
        ArrayList<Education> eduTest = new ArrayList<Education>();
        ArrayList<String> skillTest = new ArrayList<String>();
        ArrayList<String> duties = new ArrayList<String>();
        duties.add("Create a Python program to predict clients needs.");
        Experience experience1 = new Experience("Software Dev", duties, "J.P. Morgan", "Internship", "May 2019");
        expTest.add(experience1);
        Education education1 = new Education("UofSC", "Bachelors of Computer Science", "May 2023");
        eduTest.add(education1);
        skillTest.add("Java");
        skillTest.add("C++");
        skillTest.add("Python");
        resumeList.add(new Resume("test Resume1", expTest, eduTest, skillTest));
        resumeList.add(new Resume("test Resume2", expTest, eduTest, skillTest));
        resumeList.add(new Resume("test Resume3", expTest, eduTest, skillTest));
        resumeList.add(new Resume("test Resume4", expTest, eduTest, skillTest));
        resumeList.add(new Resume("test Resume5", expTest, eduTest, skillTest));
        DataWriter.saveResume();
        assertEquals("test Resume5", DataLoader.loadResumes().get(4).getTitle());
    }

    @Test
    void testWritingEmptyResume() {
        ArrayList<Experience> expTest = new ArrayList<Experience>();
        ArrayList<Education> eduTest = new ArrayList<Education>();
        ArrayList<String> skillTest = new ArrayList<String>();
        resumeList.add(new Resume("", expTest, eduTest, skillTest));
        DataWriter.saveResume();
        assertEquals("", DataLoader.loadResumes().get(0).getTitle());
    }

    @Test
    void testWritingNullResumes() {
        resumeList.add(new Resume(null, null, null, null));
        DataWriter.saveResume();
        assertEquals(null, DataLoader.loadResumes().get(0).getTitle());
    }

    @Test
    void testWritingZeroApplications() {
        appList = DataLoader.loadApplications();
        assertEquals(0, appList.size());
    }

    @Test
    void testWritingOneApplication() {
        String id = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        ArrayList<Student> applicants = new ArrayList<Student>();
        ArrayList<Resume> resumes = new ArrayList<Resume>();
        ArrayList<Experience> expTest = new ArrayList<Experience>();
        ArrayList<Education> eduTest = new ArrayList<Education>();
        ArrayList<String> skillTest = new ArrayList<String>();
        ArrayList<String> duties = new ArrayList<String>();
        duties.add("Create a Python program to predict clients needs.");
        Experience experience1 = new Experience("Software Dev", duties, "J.P. Morgan", "Internship", "May 2019");
        expTest.add(experience1);
        Education education1 = new Education("UofSC", "Bachelors of Computer Science", "May 2023");
        eduTest.add(education1);
        skillTest.add("Java");
        skillTest.add("C++");
        skillTest.add("Python");
        applicants.add(new Student(id, "Amy Smith", "asmith", "qwerty1234", "803-454-3344", resumes));
        resumes.add(new Resume("Resume1", expTest, eduTest, skillTest));
        appList.add(new Application(id2, id2, applicants, resumes));
        DataWriter.save();
        assertEquals(id2, DataLoader.loadApplications().get(0).getID());
    }

    @Test
    void testWritingFiveApplications() {
        String id = UUID.randomUUID().toString();
        ArrayList<String> applicationID = getUuids(5);
        ArrayList<Student> applicants = new ArrayList<Student>();
        ArrayList<Resume> resumes = new ArrayList<Resume>();
        ArrayList<Experience> expTest = new ArrayList<Experience>();
        ArrayList<Education> eduTest = new ArrayList<Education>();
        ArrayList<String> skillTest = new ArrayList<String>();
        ArrayList<String> duties = new ArrayList<String>();
        duties.add("Create a Python program to predict clients needs.");
        Experience experience1 = new Experience("Software Dev", duties, "J.P. Morgan", "Internship", "May 2019");
        expTest.add(experience1);
        Education education1 = new Education("UofSC", "Bachelors of Computer Science", "May 2023");
        eduTest.add(education1);
        skillTest.add("Java");
        skillTest.add("C++");
        skillTest.add("Python");
        applicants.add(new Student(id, "Amy Smith", "asmith", "qwerty1234", "803-454-3344", resumes));
        resumes.add(new Resume("Resume1", expTest, eduTest, skillTest));
        appList.add(new Application(applicationID.get(0), applicationID.get(0), applicants, resumes));
        appList.add(new Application(applicationID.get(1), applicationID.get(1), applicants, resumes));
        appList.add(new Application(applicationID.get(2), applicationID.get(2), applicants, resumes));
        appList.add(new Application(applicationID.get(3), applicationID.get(3), applicants, resumes));
        appList.add(new Application(applicationID.get(4), applicationID.get(4), applicants, resumes));

        DataWriter.saveApplications();
        assertEquals(applicationID.get(4), DataLoader.loadApplications().get(4).getID());
    }

    @Test
    void testWritingEmptyApplication() {
        // String id = UUID.randomUUID().toString();
        String applicationID = UUID.randomUUID().toString();
        ArrayList<Student> applicants = new ArrayList<Student>();
        ArrayList<Resume> resumes = new ArrayList<Resume>();
        ArrayList<Experience> expTest = new ArrayList<Experience>();
        ArrayList<Education> eduTest = new ArrayList<Education>();
        ArrayList<String> skillTest = new ArrayList<String>();
        ArrayList<String> duties = new ArrayList<String>();
        appList.add(new Application("", "", applicants, resumes));
        DataWriter.saveApplications();
        assertEquals("", DataLoader.loadApplications().get(0).getID());
    }

    @Test
    void testWritingNullApplications() {
        appList.add(new Application(null, null, null, null));
        DataWriter.saveApplications();
        assertEquals(null, DataLoader.loadApplications().get(0).getID());
    }

    private ArrayList<String> getUuids(int num) {
        ArrayList<String> ids = new ArrayList<String>();
        for (int i = 0; i < num; ++i) {
            String id = UUID.randomUUID().toString();
            ids.add(id);
        }
        return ids;
    }

}
