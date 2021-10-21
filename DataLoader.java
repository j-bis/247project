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
				String id = (String)personJSON.get(PEOPLE_FIRST_NAME);
				String title = (String)personJSON.get(PEOPLE_LAST_NAME);
				String description = (String)personJSON.get(PEOPLE_PHONE_NUMBER);
				
				jobList.add(new Job(id, title, description));
        }

        return jobList;
    }

}