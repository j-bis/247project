import java.util.*;

import javax.xml.crypto.Data;

public class Application {
    private String id;
    private String jobListingID;
    private ArrayList<Student> applicants;
    private ArrayList<Resume> resumes;

    public Application(String id, String jobListingID, ArrayList<Student> applicants, ArrayList<Resume> resumes) {
        this.id = id;
        this.jobListingID = jobListingID;
        this.applicants = applicants;
        this.resumes = resumes;
    }

    /**
     * @return String
     */
    public String getID() {
        return this.id;
    }

    /**
     * @return String
     */
    public String getjobID() {
        return this.jobListingID;
    }

    /**
     * @return ArrayList<Student>
     */
    public ArrayList<Student> getApplicants() {
        return applicants;
    }

    /**
     * @return ArrayList<Resume>
     */
    public ArrayList<Resume> getResumes() {
        return resumes;
    }

    /**
     * @param index
     * @return String
     */
    public String getResumeId(int index) {
        return resumes.get(index).getID();
    }

    /**
     * @return String
     */
    public String toString() {
        // return this.id + " ;alsjfas;jf;sajf;slfjsladkf";
        return "";
    }

}
