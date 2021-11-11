import java.util.ArrayList;
import java.util.UUID;

public class ResumeList {
    private static ResumeList resumeList;
    private static ArrayList<Resume> resume;

    private ResumeList() {
        resume = DataLoader.loadResumes();
    }

    /**
     * @return ResumeList
     */
    public static ResumeList getInstance() {
        if (resumeList == null) {
            resumeList = new ResumeList();
        }

        return resumeList;
    }

    /**
     * @param id
     * @return Resume
     */
    public static Resume getResumeByUUID(UUID id) {
        for (Resume i : resume) {
            if (i.getID().equals(id.toString())) {
                return i;
            }
        }
        return null;
    }

    /**
     * @param aresume
     */
    public void addResume(Resume aresume) {
        resume.add(aresume);
        // DataWriter.saveResume();
    }

    /**
     * @return ArrayList<Resume>
     */
    public ArrayList<Resume> getResumes() {
        return resume;
    }

    public void saveResume() {
        DataWriter.saveResume();
    }
}
