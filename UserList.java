import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    private UserList() {
        users = DataLoader.loadUsers();
    }
    
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }

        return userList;
    }

    public User getUserByID(String id) {
        for (User user : users) {
            if (user.getID().equals(id)) {
                return user;
            }
        }

        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean addUser() {
        users.add(new User());
        return true;
    }

    public void saveUserList() {
        DataWriter.saveUsers();
    }
}
