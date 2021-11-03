import java.util.*;

class Experience {
    private Scanner scanner;
    private String title;
    private ArrayList<String> duties;
    private String company;
    private String type;
    private String date;

    public Experience(String title, ArrayList<String> duties, String company, String type, String date) {
        this.title = title;
        this.duties = duties;
        this.company = company;
        this.date = date;
        this.type = type;
    }

    public Experience() {
        duties = new ArrayList<String>();
    }

    /**
     * @return Experience
     */
    public Experience addExperience() {
        Experience thisExperience = new Experience();
        thisExperience.setTitle(getField("Title"));
        thisExperience.setType(getField("Job Type"));
        // thisExperience.setDuties(getField("Duties"));
        thisExperience.setCompany(getField("Company"));
        
        return thisExperience;
    }

    /**
     * @param title
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param duties
     */
    public void setDuties(String duty) {
        this.duties.add(duty);
    }

    /**
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String start, String end) {
        this.date = start + " - " + end;
    }

    /**
     * @param prompt
     * @return String getField
     */

    private String getField(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }

    /**
     * @return String toString
     */
    public String toString() {
        return "  -Job title: " + this.title +"\n  -Previous Employer: "
                + this.company + "\n  -Job type: " + this.type 
                + "\n  -Date of Employment: " + this.date 
                + "\n  -Job description: " + getDuties() + "\n";
    }

    /**
     * @return String getTitle
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return String getDuties
     */
    public String getDuties() {
        String ret = "";
        for (String i : duties) {
            ret += "\n    -" + i;
        }
        return ret;
    }

    public ArrayList<String> getDutiesList() {
        return duties;
    }

    /**
     * @return String getCompany
     */
    public String getCompany() {
        return company;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

}
