import java.util.*;

public class Education {
    private String school;
    private String degree;
    private String gpa;
    private Scanner scanner;

    public Education(String school, String degree, String gpa) {
        this.school = school;
        this.degree = degree;
        this.gpa = gpa;
    }

    public Education() {
        scanner = new Scanner(System.in);
    }

    /**
     * @return Education
     */
    public Education addEducation() {
        Education thisEducation = new Education();
        System.out.println("Education Field: ");
        thisEducation.setSchool(getField("School"));
        thisEducation.setDegree(getField("Degree"));
        thisEducation.setgpa(getField("gpa"));
        return thisEducation;
    }

    /**
     * @param school
     */

    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @param degree
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * @param gpa
     */
    public void setgpa(String gpa) {
        this.gpa = gpa;
    }

    /**
     * @param getDegree
     * @return String
     */

    public String getSchool() {
        return school;
    }

    /**
     * @return String getDegree
     */
    public String getDegree() {
        return degree;
    }

    /**
     * @return String
     */
    public String getGpa() {
        return gpa;
    }

    /**
     * @param prompt
     * @return String getField
     */

    private String getField(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }

    /**
     * @return String toString
     */
    public String toString() {
        return "School: " + this.school + "\n  -Degree: " + this.degree + "\n  -Expected Graduation Date: " + this.gpa;
    }
}