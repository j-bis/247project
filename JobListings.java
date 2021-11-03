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

    public static ArrayList<Job> searchBySkills(String skill) {
        ArrayList<Job> searchResults = new ArrayList<Job>();
        for (Job jobs : jobsArrayList) {
            if (jobs.getSkillsArrayList().contains(skill.toLowerCase().trim())) {
                searchResults.add(jobs);
            }
        }
        return searchResults;
    }

    public String displayJobs() {
        return "";
    }

    public ArrayList<Job> getJobs() {
        return jobsArrayList;
    }

    public Job getUUID() {
        return new Job();
    }

    public void saveJobs() {
        DataWriter.saveJobs();
    }

    public static Job getJobByUUID(UUID id) {
        for (Job i : jobsArrayList) {
            if (i.getID().equals(id.toString())) {
                return i;
            }
        }
        return null;
    }
}
