import java.util.ArrayList;

public class ResumeEditor {
    //private ArrayList<Resume> resumeList1;
    private Resume resume;
    private static ResumeList resumeList = ResumeList.getInstance();



    public ResumeEditor() {}

    //Method to create new Resume.
    public static void newResume(String title, ArrayList<Experience> experience, ArrayList<Education> education, ArrayList<String> skills) {
        Resume newResume = new Resume(title, experience, education, skills);

        resumeList.addResume(newResume);
    } 

    //Method to edit Resume.
    public void editResume() {

    } 
    
    // Method to save Resume.
    public void saveResume() {

    } 
    // Method to delete Resume.
    public void deleteReume() {

    } 
}
