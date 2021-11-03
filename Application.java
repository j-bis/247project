import java.util.*;

import javax.xml.crypto.Data;

public class Application {
    private String id;
    private String jobListingID;
    private static ArrayList<Student> applicants;
    private static ArrayList<Resume> resumes;

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

    /**
     * @return String printAppsAndResumes
     */
    public String printAppsAndResumes() {
        String ret = "";
        ArrayList<Student> students = DataLoader.loadStudents();
        ArrayList<Resume> resumes = DataLoader.loadResumes();
        for (int i = 0; i < applicants.size(); i++) {
            for (Student j : students) {
                if (i.equals(j.getID())) {
                    ret += j.getContactInfo() + "\n";
                    for (Resume k : resumes) {
                        if ((i + 1).equals(k.getID())) {// ask about i+1 here
                            ret += k;
                        }
                    }
                }
            }
        }
        return ret;
    }

    /**
     * @return String toString
     */
    public String toString() {
        return this.id + " ;alsjfas;jf;sajf;slfjsladkf";

    }

}
