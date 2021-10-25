import java.util.*;
public class Resume {
    private String id;
    private String title;
    private ArrayList<Experience> experience;
    private ArrayList<Education> education;
    private ArrayList<String> skills;

    public Resume(String id, String title, ArrayList<Experience> experience, ArrayList<Education> education, ArrayList<String> skills) {
        this.id = id;
        this.title = title;
        this.education = education;
        this.experience = experience;
        this.skills = skills;
    }

    public String getTitle() {
        return this.title;
    }

    public String getID() {
        return this.id;
    }

    public String printEducation() {
        String ret = "";
        for (Education i : education) {
            ret += i + "\n";
        }
        return ret;
    }

    public String printExperience() {
        String ret = "";
        for (Experience i : experience) {
            ret += i + "\n";
        }
        return ret;
    }

    public String printSkills() {
        String ret = "";
        for (String i : skills) {
            ret += i + "\n";
        }
        return ret;
    }

    public String toString() {
        return "Education: \n" + printEducation()
        + "Experience: \n" + printExperience()
        + "Skills: \n" + printSkills();
    }
}