import java.util.ArrayList;
import java.util.UUID;

public class ResumeList {
    private static ResumeList resumeList;
    private static ArrayList<Resume> resume;

    private ResumeList() {
        resume = DataLoader.loadResumes();
    }

    public static ResumeList getInstance() {
        if (resumeList == null) {
            resumeList = new ResumeList();
        }

        return resumeList;
    }

    public static Resume getResumeByUUID(UUID id) {
        for (Resume i : resume) {
            if (i.getID().equals(id.toString())) {
                return i;
            }
        }
        return null;
    }

    public void addResume(Resume aresume) {
        resume.add(aresume);
        //DataWriter.saveResume();
    }
    
    public ArrayList<Resume> getResumes() {
        return resume;
    }
    
    public void saveResume() {
        DataWriter.saveResume();
    }
}
