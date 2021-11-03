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

    public String getID() {
        return this.id;
    }

    public String getjobID() {
        return this.jobListingID;
    }

    public ArrayList<Student> getApplicants() {
        return applicants;
    }

    public ArrayList<Resume> getResumes() {
        return resumes;
    }

    public String getResumeId(int index) {
        return resumes.get(index).getID();
    }

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

    public String toString() {
        return this.id + " ;alsjfas;jf;sajf;slfjsladkf";

    }

}
