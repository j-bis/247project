import java.util.*;
public class Education {
    private Scanner scanner;
    private String school; //Creates String school
    private String degree; //Creates String degree
    private String gpa;//Creates String gpa

    public Education(String school, String degree, String gpa) {
        this.school = school; //Calls String school
        this.degree = degree; //Calls String degree
        this.gpa = gpa; //Calls String gpa
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

    public String getDegree() { //Method to return degree
        return degree;
    }

    public String getGpa() { //Method to return gpa
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