import java.util.ArrayList;

public class Job {
    private String id;
    private String title;
    private String employer;
    private String description;
    //private ArrayList<Reveiw> reviews;
    
    public Job(){

    }

    public Job(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getID() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public String getEmployer() {
        return employer;
    }

    public String getDescription() {
        return description;
    }

    public String getReveiws() {
        return "";
    }

    public String toString() {
        return "";
    }

    public void addReview() {}
}