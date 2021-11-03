import java.util.Scanner;

public class ProgramUI {
    private Scanner scanner;
    private ProgramFacade programFacade;
    private static final String WELCOME_MESSAGE = "Welcome to the Program";
    private String[] mainMenuOptions = { "Student Login", "Employer Login", "Admin Login", "Logout" };

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

            if (userCommand == mainMenuOptions.length - 1)
                break;

            switch (userCommand) {
            case (0):
                studentLogin();

                break;
            case (1):
                employerLogin();
                break;
            case (2):
                adminLogin();
                ;
                break;
            default:
                break;
            }

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
     * @return int getUserCommand
     */
    private int getUserCommand(int numCommands) {
        System.out.println("What would you like to do: \n");

        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;
        if (command >= 0 && command <= numCommands - 1)
            return command;

        return -1;
    }

    private void studentLogin() {
        String userName = getField("Username");

        if (programFacade.studentLogin(userName)) {
            User currentUser = programFacade.getCurrentUser();
            System.out.println(currentUser.whatType() + " User: " + currentUser.getDisplayName() + " found.");
            verifyPassword(currentUser);
        } else {
            System.out.println("Sorry, invalid username ");
        }
    }

    private void employerLogin() {
        String userName = getField("Username");

        if (programFacade.employerLogin(userName)) {
            User currentUser = programFacade.getCurrentUser();
            System.out.println(currentUser.whatType() + " User: " + currentUser.getDisplayName() + " found.");
            verifyPassword(currentUser);
        } else {
            System.out.println("Sorry, invalid username ");
        }
    }

    private void adminLogin() {
        String userName = getField("Username");

        if (programFacade.adminLogin(userName)) {
            User currentUser = programFacade.getCurrentUser();
            System.out.println(currentUser.whatType() + " User: " + currentUser.getDisplayName() + " found.");
            verifyPassword(currentUser);
        } else {
            System.out.println("Sorry, invalid username ");
        }
    }

    /**
     * @param currentUser
     */
    private void verifyPassword(User currentUser) {

        String password = getField("Password");
        if (programFacade.verifyPassword(password)) {
            System.out.println("Welcome " + currentUser.getDisplayName());
        } else {
            System.out.println("Sorry, invalid password ");
        }
    }

    /**
     * @param prompt
     * @return String getField
     */
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