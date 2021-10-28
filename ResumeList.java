import java.util.ArrayList;

public class ResumeList {
    private static ResumeList resumeList;
    private ArrayList<Resume> resume;

    private ResumeList() {
        resume = DataLoader.loadResumes();
    }

    public static ResumeList getInstance() {
        if (resumeList == null) {
            resumeList = new ResumeList();
        }

        return resumeList;
    }

    public ArrayList<Resume> getResumes() {
        return resume;
    }
    
    public void saveResume() {
        DataWriter.saveResume();
    }
}
