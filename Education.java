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

    public Education addEducation() {
        Education thisEducation = new Education();
        System.out.println("Education Field: ");
        thisEducation.setSchool(getField("School"));
        thisEducation.setDegree(getField("Degree"));
        thisEducation.setgpa(getField("gpa"));
        return thisEducation;
    }

    //setters
    public void setSchool(String school) {
        this.school = school;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setgpa(String gpa) {
        this.gpa = gpa;
    }



    // getters
    public String getSchool() { //Method to return school
        return school;            
    }

    public String getDegree() { 
        return degree;
    }

    public String getGpa() {
        return gpa;
    }

    //HELPER METHODS
    private String getField(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }

    public String toString() {
        return "School: " + this.school + "\n   Degree: " + this.degree
        + "\n   GPA: " + this.gpa;
    }
}