import java.util.ArrayList;

public class ResumeEditor {

    private Resume resume;
    private ResumeList resumeList = ResumeList.getInstance();

    public ResumeEditor() {
    }

    /**
     * @param id
     * @param title
     * @param experience
     * @param education
     * @param skills
     */

    public void newResume(String id, String title, ArrayList<Experience> experience, ArrayList<Education> education,
            ArrayList<String> skills) {
        Resume newResume = new Resume(id, title, experience, education, skills);

        resumeList.addResume(newResume);
    }

    public void editResume() {

    }

    public void saveResume() {

    }

    public void deleteReume() {

    }
}
