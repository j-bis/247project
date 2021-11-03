import java.util.ArrayList;

public class Job {
    private String id;
    private String title;
    private String employer;
    private String description;

    public Job() {

    }

    public Job(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    /**
     * @return String getID
     */
    public String getID() {
        return this.id;
    }

    /**
     * @return String getTitle
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return String getEmployer
     */
    public String getEmployer() {
        return employer;
    }

    /**
     * @return String getDescription
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return String getReveiws
     */
    public String getReveiws() {
        return "";
    }

    /**
     * @return String toString
     */
    public String toString() {
        return "ID: " + getID() + "\n" + getTitle() + "\nDescription: " + getDescription();
    }

    public void addReview() {
    }
}