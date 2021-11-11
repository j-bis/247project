import java.util.ArrayList;
import java.util.UUID;

import javax.xml.crypto.Data;

public class JobListings {
    private static JobListings jobListing;
    private static ArrayList<Job> jobsArrayList;
    //private ArrayList<Job> searchResults;

    private JobListings() {
        jobsArrayList = DataLoader.loadJobs();
    }

    /**
     * @return JobListings
     */
    public static JobListings getInstance() {
        if (jobListing == null) {
            jobListing = new JobListings();
        }

        return jobListing;
    }

    /**
     * @param job
     * @param resume
     * @param student
     */
    public void apply(Job job, Resume resume, Student student) {

    }


    /**
     * @param employer
     * @return ArrayList<Job>
     */
    public ArrayList<Job> search(String employer) {
        return new ArrayList<Job>();
    }

    public static ArrayList<Job> searchBySkills(String skill) {
        ArrayList<Job> searchResults = new ArrayList<Job>();
        for (Job jobs : jobsArrayList) {
            if (jobs.getDescription().contains(skill)) {
                searchResults.add(jobs);
            }
        }
        return searchResults;
    }

    public String displayJobs() {
        return "";
    }

    /**
     * @return ArrayList<Job>
     */
    public ArrayList<Job> getJobs() {
        return jobsArrayList;
    }

    /**
     * @return Job
     */
    public Job getUUID() {
        return new Job();
    }

    public void saveJobs() {
        DataWriter.saveJobs();
    }

    /**
     * @param id
     * @return Job
     */
    public static Job getJobByUUID(UUID id) {
        for (Job i : jobsArrayList) {
            if (i.getID().equals(id.toString())) {
                return i;
            }
        }
        return null;
    }
}
