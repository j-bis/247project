import java.util.*;

public class Resume {
    private Scanner scanner;
    private String id;
    private String title;
    private ArrayList<Experience> experienceArrayList;
    private ArrayList<Education> educationArrayList;
    private ArrayList<String> skillsArrayList;
    private ResumeList resumeList = ResumeList.getInstance();

    public Resume(String id, String title, ArrayList<Experience> experience, ArrayList<Education> education,
            ArrayList<String> skills) {
        this.id = id;
        this.title = title;
        this.educationArrayList = education;
        this.experienceArrayList = experience;
        this.skillsArrayList = skills;
    }

    public Resume() {
        scanner = new Scanner(System.in);
    }

    /**
     * @return Resume
     */
    public Resume addResume() {
        Resume thisResume = new Resume();
        this.setTitle(getField("Resume ID"));
        this.setEducation(new Education().addEducation());
        this.setExperience(new Experience().addExperience());
        this.setSkills(getField("Skills"));
        return thisResume;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Resume res = new Resume();

    }

    /**
     * @return String getTitle
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return String getId
     */
    public String getID() {
        return this.id;
    }

    /**
     * @return ArrayList<Experience>
     */
    public ArrayList<Experience> getExperience() {
        return experienceArrayList;
    }

    /**
     * @return ArrayList<Education>
     */
    public ArrayList<Education> getEducation() {
        return educationArrayList;
    }

    /**
     * @return ArrayList<String>
     */
    public ArrayList<String> getSkills() {
        return skillsArrayList;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param education
     */
    public void setEducation(Education education) {
        educationArrayList.add(new Education());
    }

    /**
     * @param experience
     */
    public void setExperience(Experience experience) {
        experienceArrayList.add(experience);

    }

    /**
     * @param skills
     */
    public void setSkills(String skills) {
        skillsArrayList.add(skills);
    }

    /**
     * @param prompt
     * @return String getField
     */
    private String getField(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }

    public String printEducation() {
        String ret = "";
        for (Education i : educationArrayList) {
            ret += "  -" + i + "\n";
        }
        return ret;
    }

    public String printExperience() {
        String ret = "";
        for (Experience i : experienceArrayList) {
            ret += i + "\n";
        }
        return ret;
    }

    public String printSkills() {
        String ret = "";
        for (String i : skillsArrayList) {
            ret += "  -" + i + "\n";
        }
        return ret;
    }

    public String toString() {
        return "\nEducation: \n" + printEducation() + "\nExperience: \n" + printExperience() + "\nSkills: \n"
                + printSkills();
    }
}