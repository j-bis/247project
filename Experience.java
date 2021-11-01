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
        return "  -Job title: " + this.title + "\n   Job description: " + this.duties
        + "\n   Previous Employer: " + this.company;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return String return the duties
     */
    public String getDuties() {
        return duties;
    }


    /**
     * @return String return the company
     */
    public String getCompany() {
        return company;
    }


}
