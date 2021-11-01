import java.util.ArrayList;

public class ProgramFacade {
    
    private JobListings jobListings = JobListings.getInstance();
    private ResumeList resumeList = ResumeList.getInstance();
    private UserList userList = UserList.getInstance();
    private ApplicationList applicationList = ApplicationList.getInstance();

    private ArrayList<Job> jobArrayList;
    private ArrayList<User> userArrayList;
    private ArrayList<Student> studentArrayList;
    private ArrayList<Application> applicationArrayList;
    private ArrayList<Resume> resumeArrayList;

    /*
    ArrayList<Job> jobs = loadJobs();
    ArrayList<Resume> resumes = loadResumes();
    ArrayList<User> users = loadUsers();
    ArrayList<Student> students = loadStudents();
    ArrayList<Application> apps = loadApplications();  
    */

    public static void main(String[] args) {
        ProgramFacade programFacade = new ProgramFacade();
    }


    public ProgramFacade() {
        /*
        loadJobs();
        loadUsers();
        loadStudents();
        loadApplications();
        loadResumes();

        printJobs();
        printUsers();
        printStudents();
        printApplications();
        printResumes();
        */
    }


    // loads
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

    // prints
    public void printJobs() {
        System.out.println("\nJOBS\n");
        for (int i = 0; i < jobArrayList.size(); i++) {
            System.out.println(jobArrayList.get(i));
        }
    }

    public void printUsers() {
        System.out.println("\nUSERS\n");
        for (int i = 0; i < userArrayList.size(); i++) {
            System.out.println(userArrayList.get(i) + "\n");
        }
    }

    public void printStudents() {
        System.out.println("\nSTUDENTS\n");
        for (Student i : studentArrayList) {
            System.out.println(i.getContactInfo() + "\n");
        }
    }

    public void printApplications() {
        System.out.println("\nAPPLICATIONS\n");
        for (Application i : applicationArrayList) {
            System.out.println(i + "\n");
        }
    }

    public void printResumes() {
        System.out.println("\nRESUMES\n");
        for (Resume i : resumeArrayList) {
            System.out.println(i + "\n");
        }
    }


    // finds
    public void findStudent(String username) {

        if(username == null) return;

        if(!userList.findStudent(username)) {
            System.out.println("This user does not exist");
            return;
        }
        System.out.println("User Found");
    }

    // find student
    //find empl
    // find admin


    public Job findJob() {
        return new Job();
    }

    public Employer findEmployer() {
        return new Employer();
    }
}
