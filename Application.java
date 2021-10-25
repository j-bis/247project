import java.util.ArrayList;

import javax.xml.crypto.Data;
public class Application {
    private String id;
    private String jobListingID;
    private ArrayList<String> applicants;
    private ArrayList<String> resumes;

    public Application(String id, String jobListingID, ArrayList<String> applicants, ArrayList<String> resumes) {
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

    public String printAppsAndResumes() {
        String ret = "";
        ArrayList<Student> students = DataLoader.loadStudents();
        ArrayList<Resume> resumes = DataLoader.loadResumes();
        for (String i : applicants) {
            for (Student j : students) {
                if (i.equals(j.getID())) {
                    ret += j.getContactInfo() + "\n";
                    for (Resume k : resumes) {
                        if ((i+1).equals(k.getID())) {//ask about i+1 here
                            ret += k;
                        }
                    }
                }
            }
        }
        return ret;
    }
}
