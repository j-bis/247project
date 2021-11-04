import java.util.Scanner;
import java.util.ArrayList;

public class ProgramUI {
    private Scanner scanner;
    private ProgramFacade programFacade;
    private static final String WELCOME_MESSAGE = "Welcome to the Program";
    private String[] mainMenuOptions = { "Create Account", "Student Login", "Employer Login", "Admin Login", "Logout" };
    private String[] studentOptions = { "Create Resume", "Display/Print Resumes", "View/Apply to Job Listings",
            "Logout" };
    private String[] employerOptions = { "Create Job Listing", "View Job Listings", "Logout" };
    private static String check = "\n-----Checking for valid username-----\n";
    private static String[] userType = { "student", "employer" };
    private User currentUser;
    private static ArrayList<Resume> resumes;
    private ArrayList<Job> jobs;
    private JobListings jobListings = JobListings.getInstance();
    private ArrayList<Job> myJobs;

    public ProgramUI() {
        scanner = new Scanner(System.in);
        programFacade = new ProgramFacade();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ProgramUI programUI = new ProgramUI();
        programUI.run();
    }

    public void run() {
        System.out.println(WELCOME_MESSAGE);

        while (true) {
            displayMainMenu();

            int userCommand = getUserCommand(mainMenuOptions.length);

            if (userCommand == -1) {
                System.out.println("Not a valid command");
                continue;
            }

            // check to logout
            if (userCommand == mainMenuOptions.length - 1) {
                DataWriter.save();
                break;
            }

            switch (userCommand) {
            case (0):
                createAccount();
                break;
            case (1):
                studentLogin();
                // System.out.println(findStudent());
                break;
            case (2):
                employerLogin();
                break;
            case (3):
                adminLogin();
                ;
                break;
            default:
                break;
            }
            DataWriter.save();
            break;
        }

    }

    private void displayMainMenu() {
        System.out.println("\n***** Main Menu*****\n");
        for (int i = 0; i < mainMenuOptions.length; i++) {
            System.out.println((i + 1) + ". " + mainMenuOptions[i]);
        }

    }

    /**
     * @param numCommands
     * @return int
     */
    private int getUserCommand(int numCommands) {
        System.out.println("\nWhat would you like to do: \n");

        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;
        if (command >= 0 && command <= numCommands - 1)
            return command;

        return -1;
    }

    private void createAccount() {
        System.out.println("\n***** Create Account *****");

        for (int i = 0; i < userType.length; i++) {
            System.out.println((i + 1) + ". " + userType[i]);
        }

        int newUser = getUserCommand(userType.length);
        if (!programFacade.createAccount(userType[newUser])) {

        }

    }

    // LOGINS
    private void studentLogin() {
        String userName = getField("Username");

        System.out.println(check);
        if (programFacade.studentLogin(userName)) {
            currentUser = programFacade.getCurrentUser();
            System.out.println(currentUser.whatType() + " User: " + currentUser.getDisplayName() + " found.");

            resumes = currentUser.getResumes();
            jobs = jobListings.getJobs();
            if (verifyPassword(currentUser)) {
                studentMenu();
            }

        } else {
            System.out.println("Sorry, invalid username ");
            // while (true) {}
        }
    }

    private void employerLogin() {
        String userName = getField("Username");

        System.out.println(check);
        if (programFacade.employerLogin(userName)) {
            currentUser = programFacade.getCurrentUser();
            System.out.println(currentUser.whatType() + " User: " + currentUser.getDisplayName() + " found.");

            myJobs = currentUser.getJob();
            if (verifyPassword(currentUser)) {
                employerMenu();
            }
        } else {
            System.out.println("Sorry, invalid username ");
        }
    }

    private void adminLogin() {
        String userName = getField("Username");

        System.out.println(check);
        if (programFacade.adminLogin(userName)) {
            currentUser = programFacade.getCurrentUser();
            System.out.println(currentUser.whatType() + " User: " + currentUser.getDisplayName() + " found.");
            verifyPassword(currentUser);
        } else {
            System.out.println("Sorry, invalid username ");
        }
    }

    /**
     * @param currentUser
     */

    private boolean verifyPassword(User currentUser) {

        String password = getField("Password");
        if (!programFacade.verifyPassword(password)) {
            System.out.println("Sorry, invalid password ");
            return false;
        }

        System.out.println("Welcome " + currentUser.getDisplayName());
        return true;
    }

    public void displayResumes(User currentUser) {
    }

    /**
     * @param prompt
     * @return String getField
     */
    private String getField(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }

    public void displayJobListings() {

    }

    public void displayApplicants() {

    }

    public void displayUsers() {

    }

    // MENUS

    private void studentMenu() {
        boolean loggedin = true;
        while (loggedin) {
            System.out.println("\nStudent options:");
            for (int i = 0; i < studentOptions.length; i++) {
                System.out.println((i + 1) + ". " + studentOptions[i]);
            }
            switch (getUserCommand(4)) {
            case (0): // "Create Resume
                createResume();

                break;
            case (1): // "Display/Print Resumes"
                System.out.println("Which Resume?");
                for (int i = 0; i < resumes.size(); i++) {
                    System.out.println((i + 1) + ". " + resumes.get(i).getTitle());
                }
                int choice = getUserCommand(resumes.size());
                System.out.println(currentUser.getContactInfo());
                System.out.println(resumes.get(choice));
                System.out.println("\nWould you like to print this resume to a txt file?");
                System.out.println("1. Yes\n2. No");
                if (getUserCommand(2) == 0) {
                    DataWriter.writeResumeToTxtFile(currentUser, choice);
                    System.out.println("Printed to Resume.txt");
                }
                break;
            case (2): // View/Apply to Job Listings

                boolean jobView = true;
                while (jobView) {
                    System.out.println("\nJob Listings:");
                    for (int i = 0; i < jobs.size(); i++) {
                        System.out.println((i + 1) + ". " + jobs.get(i));
                    }
                    System.out.println("\n1. Search by a skill\n2. Apply to a job\n3. Quit");
                    switch (getUserCommand(3)) {
                    case (0):
                        String jobSearch = getField("Enter a skill to search by");
                        jobs = JobListings.searchBySkills(jobSearch);
                        for (int i = 0; i < jobs.size(); i++) {
                            System.out.println((i + 1) + ". " + jobs.get(i).getTitle());
                        }
                        break;
                    case (1):
                        System.out.println("Which job did you want to apply for?");
                        int apply = getUserCommand(jobs.size());
                        System.out.println(jobs.get(apply));
                        System.out.println("Applying to this job.\nWhich resume do you want to send?");
                        for (int i = 0; i < resumes.size(); i++) {
                            System.out.println((i + 1) + ". " + resumes.get(i).getTitle());
                        }
                        int send = getUserCommand(resumes.size());
                        ApplicationList.addApplicant(jobs.get(apply).getID(), currentUser.getID(),
                                resumes.get(send).getID());
                        System.out.println("sent!");
                        break;
                    case (2):
                        jobView = false;
                        break;
                    }
                }
                break;
            case (3): // logout
                DataWriter.save();
                loggedin = false;
                break;
            }
        }
    }

    private void employerMenu() {
        boolean loggedin = true;
        while (loggedin) {
            System.out.println("\nEmployer options:");
            for (int i = 0; i < employerOptions.length; i++) {
                System.out.println((i + 1) + ". " + employerOptions[i]);
            }
            switch (getUserCommand(3)) {
            case (0):// create job listing
                break;
            case (1):// view job listings
                boolean jobListingsView = true;
                while (jobListingsView) {
                    for (int i = 0; i < myJobs.size(); i++) {
                        System.out.println((i + 1) + ". " + myJobs.get(i).getTitle());
                    }
                    System.out.println("\n1. View Applicants for a job\n2. Quit");
                    if (getUserCommand(2) == 0) {
                        System.out.println("Which job?");
                        for (int i = 0; i < myJobs.size(); i++) {
                            System.out.println((i + 1) + ". " + myJobs.get(i).getTitle());
                        }
                        int choice = getUserCommand(myJobs.size());
                        Application app = ApplicationList.getAppByJobID(myJobs.get(choice).getID());
                        System.out.println(app);
                        // for (int i = 0; i < app.getApplicants().size(); i++) {
                        //     System.out.println(app.getApplicants().size());
                        //     System.out.println(app.getApplicants().get(i).getContactInfo());
                        //     System.out.println(app.getResumes().get(i));
                        // }

                        // System.out.println(myJobs.get(getUserCommand(myJobs.size()).printApplicants()));
                    }
                }
                break;
            case (2):// logout
                loggedin = false;
                break;
            }
        }
    }

    private void createResume() {
        String resumeTitle = getField("Enter Resume title");
        ArrayList<Experience> experiences = new ArrayList<Experience>();
        ArrayList<Education> educations = new ArrayList<Education>();
        ArrayList<String> skills = new ArrayList<String>();

        while (true) {
            Experience thisExperience = new Experience();
            System.out.println("Input your past Experience: ");
            thisExperience.setTitle(getField("Experience Title"));
            thisExperience.setCompany(getField("Company"));
            thisExperience.setType(getField("Job Type"));
            String start = getField("Month and Year you started work");
            String end = getField("Month and Year you stopped work");
            thisExperience.setDate(start, end);
            while (true) {
                thisExperience.addDuties(getField("Duties"));
                String moreD = getField("Do you have any more duties? (Y/N)");
                if (moreD.equalsIgnoreCase("n"))
                    break;
            }

            experiences.add(thisExperience);
            String moreExp = getField("Do you have more experience (Y/N)");
            if (moreExp.equalsIgnoreCase("n"))
                break;
        }

        while (true) {
            Education thisEducation = new Education();
            System.out.println("Education Field: ");
            thisEducation.setSchool(getField("School"));
            thisEducation.setDegree(getField("Degree"));
            thisEducation.setgpa(getField("Expected Graduation"));
            educations.add(thisEducation);
            String moreEdu = getField("Do you have more education (Y/N)");
            if (moreEdu.equalsIgnoreCase("n"))
                break;
        }

        while (true) {
            String skill = getField("Enter Skills");
            skills.add(skill);
            String moreSkill = getField("Do you have more skills (Y/N)");
            if (moreSkill.equalsIgnoreCase("n"))
                break;
        }

        ResumeEditor.newResume(resumeTitle, experiences, educations, skills);
        resumes.add(new Resume(resumeTitle, experiences, educations, skills));
        for (int i = 0; i < educations.size(); i++) {
            System.out.println(educations.get(i));
        }
        System.out.println(new Resume(resumeTitle, experiences, educations, skills));

    }

    public User getCurrentUser() {
        return currentUser;
    }

}