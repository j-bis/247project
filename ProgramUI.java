import java.util.Scanner;
import java.util.ArrayList;

public class ProgramUI {
    private Scanner scanner;
    private ProgramFacade programFacade;
    private static final String WELCOME_MESSAGE = "Welcome to the Program";
    private String[] mainMenuOptions = {"Create Account", "Student Login", "Employer Login", "Admin Login", "Logout"};
    private String[] studentOptions = {"Create Resume", "Display/Print Resumes", "View/Apply to Job Listings", "Logout"};
    private static String check = "\n-----Checking for valid username-----\n";
    private static String[] userType = {"student", "employer"};
    private User currentUser;
    private ArrayList<Resume> resumes;
    private ArrayList<Job> jobs;
    private JobListings jobListings = JobListings.getInstance();


    public ProgramUI() {
        scanner = new Scanner(System.in);
        programFacade = new ProgramFacade();
    }

    public static void main(String[] args) {
        ProgramUI programUI = new ProgramUI();
        programUI.run();
    }


    public void run() {
        System.out.println(WELCOME_MESSAGE);
        
        while(true) {
            displayMainMenu();


            int userCommand = getUserCommand(mainMenuOptions.length);

            if(userCommand == -1) {
                System.out.println("Not a valid command");
                continue;
            }

            //check to logout
            if(userCommand == mainMenuOptions.length - 1) break;

            
            switch(userCommand) {
                case(0):
                    createAccount();
                    break;
                case(1):
                    studentLogin();
                    // System.out.println(findStudent());
                    break;
                case(2):
                    employerLogin();
                    break;
                case(3):
                    adminLogin();;
                    break;
                default:
                    break;
            }


            break;
        }
        //login loop

    }

    private void displayMainMenu() {
        System.out.println("\n***** Main Menu*****\n");
        for(int i=0; i<mainMenuOptions.length; i++) {
            System.out.println((i+1) + ". " + mainMenuOptions[i]);
        }

    }

    private int getUserCommand(int numCommands) {
        System.out.println("\nWhat would you like to do: \n");

        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;
        if(command >= 0 && command <= numCommands -1) return command;

        return -1;
    }

    private void createAccount() {
        System.out.println("\n***** Create Account *****");

        for (int i = 0; i < userType.length; i++) {
            System.out.println((i+1) + ". " + userType[i]);
        }

        int newUser = getUserCommand(userType.length);
        if (!programFacade.createAccount(userType[newUser])) {
            
        }

        

    }

    // LOGINS
    private void studentLogin() {
        String userName = getField("Username" );

        if (programFacade.studentLogin(userName)) {
            currentUser = programFacade.getCurrentUser();
            System.out.println(currentUser.whatType() + " User: " + currentUser.getDisplayName() + " found.");
            verifyPassword(currentUser);
            resumes = currentUser.getResumes();
            jobs = jobListings.getJobs();
            studentMenu();
        } else {
            System.out.println("Sorry, invalid username ");
        }
    }

    private void studentMenu() {
        boolean loggedin = true;
        while (loggedin) {
            System.out.println("\nStudent options:");
            for (int i=0;i<studentOptions.length;i++) {
                System.out.println((i+1) + ". " + studentOptions[i]);
            }
            switch(getUserCommand(4)) {
                case(0): //"Create Resume
                    createResume();

                    break;
                case(1): //"Display/Print Resumes"
                System.out.println("Which Resume?");
                for (int i=0;i<resumes.size();i++) {
                    System.out.println((i+1) + ". " + resumes.get(i).getTitle());
                }
                int choice = getUserCommand(resumes.size());
                System.out.println(resumes.get(choice));
                System.out.println("\nWould you like to print this resume to a txt file?");
                System.out.println("1. Yes\n2. No");
                if (getUserCommand(2) == 0) {
                    System.out.println("TEST");
                    DataWriter.writeResumeToTxtFile(currentUser, choice);
                    System.out.println("Printed to Resume.txt");
                }
                    break;
                case(2): //View/Apply to Job Listings
                    System.out.println("\nJob Listings:");
                    for (int i=0;i<jobs.size();i++) {
                        System.out.println((i+1) + ". " + jobs.get(i).getTitle());
                    }
                    boolean jobView = true;
                    while (jobView) {
                        System.out.println("1. Search by a skill\n2. Apply to a job");
                        if (getUserCommand(2) == 0) {
                            System.out.println("Enter a skill to search by:");
                            jobs = JobListings.searchBySkills(scanner.nextLine());
                            for (int i=0;i<jobs.size();i++) {
                                System.out.println((i+1) + ". " + jobs.get(i).getTitle());
                            }
                        } else {
                            System.out.println("Which job did you want to apply for?");
                            int apply = getUserCommand(jobs.size());
                            System.out.println("Which resume do you want to send?");
                            int send = getUserCommand(resumes.size());
                            // ApplicationList.addApplicant(jobs.get(apply).getID(),currentUser.getID(),resumes.get(send).getID());
                            System.out.println("sent!");
                        }
                    }    
                    break;
                case(3): //logout
                    DataWriter.save();
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
            thisExperience.setTitle(getField("Title"));
            thisExperience.setDuties(getField("Duties"));
            thisExperience.setCompany(getField("Company"));
            experiences.add(thisExperience);
            String moreExp = getField("Do you have more experience");
            if (moreExp.equalsIgnoreCase("no")) break;
        }

        while (true) {
            Education thisEducation = new Education();
            System.out.println("Education Field: ");
            thisEducation.setSchool(getField("School"));
            thisEducation.setDegree(getField("Degree"));
            thisEducation.setgpa(getField("gpa"));
            educations.add(thisEducation);
            String moreEdu = getField("Do you have more education");
            if (moreEdu.equalsIgnoreCase("no")) break;
        }

    
        while (true) {
            String skill = getField("Enter Skills");
            skills.add(skill);
            String moreSkill = getField("Do you have more skills");
            if (moreSkill.equalsIgnoreCase("no")) break;
        }

        ResumeEditor.newResume(resumeTitle, experiences, educations, skills);

        
    }

    private void employerLogin() {
        String userName = getField("Username");

        if (programFacade.employerLogin(userName)) {
            currentUser = programFacade.getCurrentUser();
            System.out.println(currentUser.whatType() + " User: " + currentUser.getDisplayName() + " found.");
            verifyPassword(currentUser);
        } else {
            System.out.println("Sorry, invalid username ");
        }
    }
     
    private void adminLogin() {
        String userName = getField("Username");

        if (programFacade.adminLogin(userName)) {
            currentUser = programFacade.getCurrentUser();
            System.out.println(currentUser.whatType() + " User: " + currentUser.getDisplayName() + " found.");
            verifyPassword(currentUser);
        } else {
            System.out.println("Sorry, invalid username ");
        }
    }
    

    // HELPER METHODS
    private void verifyPassword(User currentUser) {
        
        String password = getField("Password");
        if (programFacade.verifyPassword(password)) {
            System.out.println("Welcome " + currentUser.getDisplayName());
        } else {
            System.out.println("Sorry, invalid password ");
            }
    }

    
    private String getField(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }
    


    public void displayResumes() {

    }

    public void displayJobListings() {

    }

    public void displayApplicants() {

    }

    public void displayUsers() {

    }

}