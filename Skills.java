import java.util.ArrayList;

public class Skills {
    private ArrayList<String> skills;

    public Skills(ArrayList<String> skills) {
        this.skills = skills;
    }

    /**
     * @return ArrayList<String>
     */
    public ArrayList<String> getSkills() {
        return skills;
    }

    /**
     * @param skill
     */
    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    /**
     * @return String toString
     */
    public String toString() {
        return "";
    }
}
