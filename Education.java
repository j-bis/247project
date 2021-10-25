public class Education {
    private String school;
    private String degree;
    private String gpa;

    public Education(String school, String degree, String gpa) {
        this.school = school;
        this.degree = degree;
        this.gpa = gpa;
    }

    public String toString() {
        return "School: " + this.school + "\nDegree: " + this.degree
        + "\nGPA: " + this.gpa;
    }
}