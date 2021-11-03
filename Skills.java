import java.util.ArrayList;

public class Skills {
    private ArrayList<String> skills;

    public Skills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public String toString() {
        return "";
    }
}
