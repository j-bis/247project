import java.util.*;

 class Experience {
    private Scanner scanner;
    private String title;
    private String duties; 
    private String company;

    public Experience(String title, String duties, String company) {
        this.title = title;
        this.duties = duties;
        this.company = company;
    }
    public Experience() {
        scanner = new Scanner(System.in);
    }

    public Experience addExperience() {
        Experience thisExperience = new Experience();
        thisExperience.setTitle(getField("Title"));
        thisExperience.setDuties(getField("Duties"));
        thisExperience.setCompany(getField("Company"));
        return thisExperience;
    }

    // SETTERS
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public void setCompany(String company) {
        this.company = company;
    }




    // HELPERS
    private String getField(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }




    public String toString() {
        return "  -Job title: " + this.title + "\n   Job description: " + this.duties
        + "\n   Previous Employer: " + this.company;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return String return the duties
     */
    public String getDuties() {
        return duties;
    }


    /**
     * @return String return the company
     */
    public String getCompany() {
        return company;
    }


}
