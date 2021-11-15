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

        DataWriter.saveUsers();
    }

    @AfterEach
	public void tearDown() {
		UserList.getInstance().getUsers().clear();
        JobListings.getInstance().getJobs().clear();
		DataWriter.saveUsers();
        DataWriter.saveJobs();
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
        ArrayList<UUID> testIDs = getUuids(5);
        ArrayList<Resume> testResList = rList.getResumes();
        ArrayList<Job> testJobList = jList.getJobs();
        userList.add(new Student(testIDs.get(0).toString(), "Amy Smith", "asmith", "qwerty1234", "803-454-3344", testResList));
        userList.add(new Employer(testIDs.get(1).toString(), "Amy Smith", "bsmith", "qwerty1234", testJobList));
		userList.add(new Admin(testIDs.get(2).toString(), "Amy Smith", "csmith", "qwerty1234"));
        userList.add(new Student(testIDs.get(3).toString(), "Amy Smith", "dsmith", "qwerty1234", "803-454-3344", testResList));
        userList.add(new Employer(testIDs.get(4).toString(), "Amy Smith", "esmith", "qwerty1234", testJobList));
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
        userList.add(new Student(id, "", null, "", "", testList));
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
        ArrayList<UUID> testJobIds = getUuids(5);
        jobList.add(new Job(testJobIds.get(0).toString(), "Internship for Google", "make stuff"));
        jobList.add(new Job(testJobIds.get(1).toString(), "Internship for Microsoft", "make stuff"));
        jobList.add(new Job(testJobIds.get(2).toString(), "Internship for Amazon", "make stuff"));
        jobList.add(new Job(testJobIds.get(3).toString(), "Internship for UofSC", "make stuff"));
        jobList.add(new Job(testJobIds.get(4).toString(), "Internship for Tesla", "make other stuff"));
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

    private ArrayList<UUID> getUuids(int num) {
        ArrayList<UUID> ids = new ArrayList<UUID>();
        for (int i = 0; i < num; ++i) {
            UUID id = UUID.randomUUID();
            ids.add(id);
        }
        return ids;
    }

}
