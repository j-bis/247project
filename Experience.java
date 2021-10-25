public class Experience {
    private String title;
    private String duties;
    private String company;

    public Experience(String title, String duties, String company) {
        this.title = title;
        this.duties = duties;
        this.company = company;
    }

    public String toString() {
        return "Job title: " + this.title + "\nJob description: " + this.duties
        + "\nPrevious Employer: " + this.company;
    }
}
