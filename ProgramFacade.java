import java.util.ArrayList;

public class ProgramFacade {

    private JobListings jobListings = JobListings.getInstance();
    private ResumeList resumeList = ResumeList.getInstance();
    private UserList userList = UserList.getInstance();
    private ApplicationList applicationList = ApplicationList.getInstance();
    private User currentUser;

    private ArrayList<Job> jobArrayList;
    private ArrayList<User> userArrayList;
    private ArrayList<Student> studentArrayList;
    private ArrayList<Application> applicationArrayList;
    private ArrayList<Resume> resumeArrayList;

    /**
     * @param args
     */
    public static void main(String[] args) {
        ProgramFacade programFacade = new ProgramFacade();
        programFacade.addResume();
    }

    public ProgramFacade() {

    }

    /**
     * @return User
     */
    public User getCurrentUser() {
        return currentUser;
    }

    public void addResume() {
        //resumeArrayList.add(new Resume().addResume());
        resumeList.addResume(new Resume().addResume());
    }

    // loads

    /*
     * public void loadJobs() { jobArrayList = DataLoader.loadJobs(); }
     * 
     * public void loadUsers() { userArrayList = DataLoader.loadUsers(); }
     * 
     * public void loadStudents() { studentArrayList = DataLoader.loadStudents(); }
     * 
     * public void loadApplications() { applicationArrayList =
     * DataLoader.loadApplications(); }
     * 
     * public void loadResumes() { resumeArrayList = DataLoader.loadResumes(); }
     */

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

    /**
     * @param username
     * @return boolean studentLogin
     */
    // logins

    public boolean createAccount(String type) {
        return userList.addUser(type);
    }

    public boolean studentLogin(String username) {
        if (!userList.findStudent(username))
            return false;

        currentUser = userList.getUser(username);
        return true;
    }

    /**
     * @param username
     * @return boolean employerLogin
     */
    public boolean employerLogin(String username) {
        if (!userList.findEmployer(username))
            return false;

        currentUser = userList.getUser(username);
        return true;
    }

    /**
     * @param username
     * @return boolean adminLogin
     */
    public boolean adminLogin(String username) {
        if (!userList.findAdmin(username))
            return false;

        currentUser = userList.getUser(username);
        return true;
    }

    /**
     * @param password
     * @return boolean verifyPassword
     */
    public boolean verifyPassword(String password) {
        if (currentUser.getPass().equals(password))
            return true;
        return false;
    }

    public Job findJob() {
        return new Job();
    }

    public Employer findEmployer() {
        return new Employer();
    }
}
