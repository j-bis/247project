import java.util.ArrayList;

import javax.xml.crypto.Data;

public class JobListings {
    private static JobListings jobListing;
    private ArrayList<Job> jobs;
    private ArrayList<Job> searchResults;

    private JobListings() {
        jobs = DataLoader.loadJobs();
    }

    public static JobListings getInstance() {
        if (jobListing == null) {
            jobListing = new JobListings();
        }

        return jobListing;
    }

    public void apply(Job job, Resume resume, Student student) {

    }

    public ArrayList<Job> search(String employer) {
        return new ArrayList<Job>();
    }

    public String displayJobs() {
        return "";
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void saveJobs() {
        DataWriter.saveJobs();
    }
}
