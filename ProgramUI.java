import java.util.Scanner;

public class ProgramUI {
    private Scanner scanner;
    private ProgramFacade programFacade;
    private static final String WELCOME_MESSAGE = "Welcome to the Program";
    private String[] mainMenuOptions = {"Student Login", "Employer Login", "Admin Login", "Logout"};

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
            if(userCommand == mainMenuOptions.length -1) break;

            
            switch(userCommand) {
                case(0):
                    studentLogin();
                    // System.out.println(findStudent());
                    break;
                case(1):
                    employerLogin();
                    break;
                case(2):
                    adminLogin();;
                    break;
                default:
                    break;
            }


            break;
        }
        //login loop

    }

    private void displayLogin() {
        System.out.println("\nEnter Username:\n");
    }

    private void displayMainMenu() {
        System.out.println("\n***** Main Menu*****\n");
        for(int i=0; i<mainMenuOptions.length; i++) {
            System.out.println((i+1) + ". " + mainMenuOptions[i]);
        }

    }

    private int getUserCommand(int numCommands) {
        System.out.println("What would you like to do: \n");

        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;
        if(command >= 0 && command <= numCommands -1) return command;

        return -1;
    }

    private void studentLogin() {
        String userName = getField("Username");

        if (programFacade.studentLogin(userName)) {
            User currentUser = programFacade.getCurrentUser();
            System.out.println(currentUser.whatType() + " User: " + currentUser.getDisplayName() + " found.\nPlease enter password");
        } else {
            System.out.println("Sorry, invalid username ");
        }
    }

    private void employerLogin() {
        String userName = getField("Username");

        if (programFacade.employerLogin(userName)) {
            User currentUser = programFacade.getCurrentUser();
            System.out.println(currentUser.whatType() + " User: " + currentUser.getDisplayName() + " found.\nPlease enter password");
        } else {
            System.out.println("Sorry, invalid username ");
        }
    }
     
    private void adminLogin() {
        String userName = getField("Username");

        if (programFacade.adminLogin(userName)) {
            User currentUser = programFacade.getCurrentUser();
            System.out.println(currentUser.whatType() + " User: " + currentUser.getDisplayName() + " found.\nPlease enter password");
        } else {
            System.out.println("Sorry, invalid username ");
        }
    }
    

    private String getField(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }


    /*
    private String findStudent() {
        return programFacade.findStudent(getUserUserName());
    }
    private void findEmployer() {
        programFacade.findEmployer(getUserUserName());
    }
    private void findAdmin() {
        programFacade.findAdmin(getUserUserName());
    }

    private String getUserUserName() {
        System.out.println("Enter Username");

        while(true) {
            String username = scanner.nextLine().trim();

            if(!username.contentEquals("")) return username;

            System.out.println("You may not leave this blank");
            System.out.println("Would you like to enter username again (y) or return to main menu (n): ");
            String command = scanner.nextLine().trim().toLowerCase();
            if(command == "n") return null;
        }
    }

    */

    public void displayResumes() {

    }

    public void displayJobListings() {

    }

    public void displayApplicants() {

    }

    public void displayUsers() {

    }

}