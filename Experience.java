public class Experience {
    private String title; //Creates String title
    private String duties; //Creates String duties
    private String company; //Creates String company

    public Experience(String title, String duties, String company) {
        this.title = title; //Calls String title
        this.duties = duties; //Calls String duties
        this.company = company; //Calls String company
    }

    

    public String toString() {
        return "Job title: " + this.title + "\nJob description: " + this.duties
        + "\nPrevious Employer: " + this.company;
    }

    /**
     * @return String return the title
     */
    public String getTitle() { //Method to return title
        return title;
    }

    /**
     * @return String return the duties
     */
    public String getDuties() { //Method to return duties
        return duties;
    }


    /**
     * @return String return the company
     */
    public String getCompany() { //Method to return company
        return company;
    }


}
