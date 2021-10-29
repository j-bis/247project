import java.util.ArrayList;

public class ProgramFacade {
    //private ResumeList resumeList = ResumeList.getInstance();
    //private ApplicationList applicationList = ApplicationList.getInstance();
    private JobListings jobListings = JobListings.getInstance();
    //private UserList userList = UserList.getInstance();
    
    private ArrayList<Job> jobArrayList;
    private ArrayList<User> userArrayList;
    private ArrayList<Student> studentArrayList;
    private ArrayList<Application> applicationArrayList;
    private ArrayList<Resume> resumeArrayList;

    public static void main(String[] args) {
        ProgramFacade programFacade = new ProgramFacade();
    }


    public ProgramFacade() {
        // loadJobs();
        // loadUsers();
        // loadStudents();
        // loadApplications();
        // loadResumes();
    }


    public void loadJobs() {
        jobArrayList = DataLoader.loadJobs();
    }

    public void loadUsers() {
        userArrayList = DataLoader.loadUsers();
    }

    public void loadStudents() {
        studentArrayList = DataLoader.loadStudents();
    }
    
    public void loadApplications() {
        applicationArrayList = DataLoader.loadApplications();
    }

    public void loadResumes() {
        resumeArrayList = DataLoader.loadResumes();
    }


    public User findUser() {
        return new User();
    }

    public Job findJob() {
        return new Job();
    }

    public Employer findEmployer() {
        return new Employer();
    }
}
