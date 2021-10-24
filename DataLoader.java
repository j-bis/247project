import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader {

    public static ArrayList<Job> loadJobs() {
        ArrayList<Job> jobList = new ArrayList<Job>();

        try {
            FileReader reader = new FileReader("jobListings.json");
            JSONParser parser = new JSONParser();
            JSONArray jobsJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < jobsJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)jobsJSON.get(i);
				String id = (String)personJSON.get("id");
				String title = (String)personJSON.get("title");
				String description = (String)personJSON.get("description");
				
				jobList.add(new Job(id, title, description));
            }

        return jobList;
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader("users.json");
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < userJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)userJSON.get(i);
                //System.out.println(i);
                if (Integer.parseInt((String)personJSON.get("type")) == 0) {
                    String id = (String)personJSON.get("id");
                    String displayName = (String)personJSON.get("displayName");
                    String username = (String)personJSON.get("username");
                    String password = (String)personJSON.get("password");

                    users.add(new Student(id, displayName, username, password));
                } else if (Integer.parseInt((String)personJSON.get("type")) == 1) {
                    String id = (String)personJSON.get("id");
                    String displayName = (String)personJSON.get("displayName");
                    String username = (String)personJSON.get("username");
                    String password = (String)personJSON.get("password");

                    users.add(new Employer(id, displayName, username, password));
                } else {
                    String id = (String)personJSON.get("id");
                    String displayName = (String)personJSON.get("displayName");
                    String username = (String)personJSON.get("username");
                    String password = (String)personJSON.get("password");

                    users.add(new Admin(id, displayName, username, password));
                }
				
            }

        return users;
        } catch (Exception e) {
            e.printStackTrace();
            }
    return null;
    }

    public static void main(String[] args) {
        ArrayList<Job> jobs = loadJobs();
        ArrayList<User> users = loadUsers();
        
        for (int i = 0; i < jobs.size(); i++) {
            System.out.println(jobs.get(i));
        }

        System.out.println("\nUSERS\n");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i) + "\n");
        }
    }
}