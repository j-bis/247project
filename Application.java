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
     * @return String getID
     */
    public String getID() {
        return this.id;
    }

    /**
     * @return String getjobID
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
     * @return String getResumeId
     */
    public String getResumeId(int index) {
        return resumes.get(index).getID();
    }


    public void addApplicant(String studentID, String resumeID) {
        applicants.add(studentID);
        resumes.add(resumeID);
    }


    /**
     * @return String toString
     */
    public String toString() {
        return this.id + printResumes();

    }

    public String printResumes() {
        String ret = "";
        for (int i=0;i<applicants.size();i++) {
            ret += applicants.get(i) + "\n" + resumes.get(i) + "\n";
        }
        return ret;
    }

}
