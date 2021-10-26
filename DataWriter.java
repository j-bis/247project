import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter {
    
    public static void saveUsers() {
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < users.size(); ++i) {
            jsonUsers.add(getUserJSON(users.get(i)));
        }

        try (FileWriter file = new FileWriter("users.json")) {

            file.write(jsonUsers.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public static void saveJobs() {
        
    }

    public static void saveResume() {

    }

    public static void saveApplications() {

    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put("id", user.getID().toString());
        userDetails.put("type", user.getType());
		userDetails.put("displayName", user.getDisplayName());
		userDetails.put("username", user.getUsername());
		userDetails.put("password", user.getPass());

        if (user.getType().equals("0")) {
            userDetails.put("contactInfo", user.getContactInfo());
            userDetails.put("resumes", user.getResumesID());
        } else if (user.getType().equals("1")) {
            userDetails.put("jobListings", user.getJobID());
        }

        return userDetails;
    }
}
