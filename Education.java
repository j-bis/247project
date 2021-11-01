public class Education {
    private String school; //Creates String school
    private String degree; //Creates String degree
    private String gpa;//Creates String gpa

    public Education(String school, String degree, String gpa) {
        this.school = school; //Calls String school
        this.degree = degree; //Calls String degree
        this.gpa = gpa; //Calls String gpa
    }

    public String getSchool() { //Method to return school
        return school;            
    }

    public String getDegree() { //Method to return degree
        return degree;
    }

    public String getGpa() { //Method to return gpa
        return gpa;
    }

    public String toString() {
        return "School: " + this.school + "\n   Degree: " + this.degree
        + "\n   GPA: " + this.gpa;
    }
}