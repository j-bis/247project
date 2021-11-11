import java.util.ArrayList;

public class ResumeEditor {

    private Resume resume;
    private static ResumeList resumeList = ResumeList.getInstance();


    /**
     * @param id
     * @param title
     * @param experience
     * @param education
     * @param skills
     */

    public ResumeEditor() {}

    //Method to create new Resume.
    public static void newResume(String title, ArrayList<Experience> experience, ArrayList<Education> education, ArrayList<String> skills) {
        Resume newResume = new Resume(title, experience, education, skills);

        resumeList.addResume(newResume);
    }

    public void editResume() {

    }

    public void saveResume() {

    }

    public void deleteReume() {

    }
}
