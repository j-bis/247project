import java.util.*;

public class Resume {
    private Scanner scanner;//keep this
    private String id;
    private String title;
    private ArrayList<Experience> experienceArrayList;
    private ArrayList<Education> educationArrayList;
    private ArrayList<String> skillsArrayList;

    public Resume(String id, String title, ArrayList<Experience> experience, ArrayList<Education> education,
            ArrayList<String> skills) {
        this.id = id;
        this.title = title;
        this.educationArrayList = education;
        this.experienceArrayList = experience;
        this.skillsArrayList = skills;
    }

    public Resume(String title, ArrayList<Experience> experience, ArrayList<Education> education, ArrayList<String> skills) {
        id = UUID.randomUUID().toString();
        this.title = title;
        this.educationArrayList = education;
        this.experienceArrayList = experience;
        this.skillsArrayList = skills;
    }

    public Resume() {
        id = UUID.randomUUID().toString();
    }

    /**
     * @return Resume
     */
    public Resume addResume() {
        Resume thisResume = new Resume();
        thisResume.setTitle(getField("Resume Title"));
        thisResume.setEducation(new Education().addEducation());
        thisResume.setExperience(new Experience().addExperience());
        thisResume.setSkills(getField("Skills"));
        return thisResume;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //Resume res = new Resume();

    }

    /**
     * @return String
     */
    // Getters
    public String getTitle() {
        return this.title;
    }

    /**
     * @return String
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

    /*
     * public void addExperience(Experience experience) {
     * this.experienceArrayList.add(experience); }
     * 
     * public void addEducation(Education education) {
     * this.educationArrayList.add(education); }
     * 
     */

    /*
     * public void addExperience(String title, String duties, String company) {
     * Experience newExperience = new Experience(title, duties, company);
     * experience.add(newExperience); }
     */

    public void setEducation(Education education) {
        educationArrayList.add(new Education());
    } // new education to see if still Null

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
     * @return String
     */
    /*
     * public void addEducation(Education education) { this.education = new
     * Education(education); }
     */

    // helper methods

    private String getField(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }

    // printers
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
        return "\nEducation: \n" + printEducation() + "\nExperience: \n" + printExperience() + "Skills: \n"
                + printSkills();
    }
}