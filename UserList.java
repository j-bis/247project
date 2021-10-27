import java.util.*;

public class UserList {
    private static UserList userList;
    private static ArrayList<User> users;
    private static ArrayList<Student> students;

    public UserList() {
        users = DataLoader.loadUsers();
        students = DataLoader.loadStudents();
    }
    
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }

        return userList;
    }

    public static Student getStudentById(UUID id) {
        String StringID = id.toString();
        for (Student student : students) {
            if (student.getID().equals(StringID)) {
                return student;
            }
        }

        return null;
    }
        //getStudentById(UUID id)
    public static User getUserById(String id) {
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

    public boolean addUser(String type) {
        if (type.equals("") || !type.equals("0") || 
            !type.equals("1") || !type.equals("2")) {
                return false;
            }

        users.add(UserFactory.createUser(type));
        return true;
    }

    public void saveUserList() {
        DataWriter.saveUsers();
    }
}
