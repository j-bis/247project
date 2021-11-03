import java.util.*;

public class UserList {
    private static UserList userList;
    private static ArrayList<User> users;
    private static ArrayList<Student> students;
    private static ArrayList<Employer> employers;
    private static ArrayList<Admin> admins;
    private static String check = "\n-----Checking for valid username-----\n";

    private UserList() {
        users = DataLoader.loadUsers();
        students = DataLoader.loadStudents();
        employers = DataLoader.loadEmployers();
        admins = DataLoader.loadAdmins();
    }

    /**
     * @return UserList
     */
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }

        return userList;
    }

    /**
     * @param id
     * @return Student
     */
    public static Student getStudentById(UUID id) {
        String StringID = id.toString();
        for (Student student : students) {
            if (student.getID().equals(StringID)) {
                return student;
            }
        }

        return null;
    }

    /**
     * @param id
     * @return User
     */
    // getStudentById(UUID id)
    public static User getUserById(String id) {
        for (User user : users) {
            if (user.getID().equals(id)) {
                return user;
            }
        }

        return null;
    }

    /**
     * @return ArrayList<User>
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean findStudent(String username) {
        System.out.println(check);
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getUsername().equals(username))
                return true;
        }
        return false;
    }

    /**
     * @param username
     * @return boolean findEmployer
     */
    public boolean findEmployer(String username) {
        System.out.println(check);
        for (int i = 0; i < employers.size(); i++) {
            if (employers.get(i).getUsername().equals(username))
                return true;
        }
        return false;
    }

    /**
     * @param username
     * @return boolean findAdmin
     */
    public boolean findAdmin(String username) {
        System.out.println(check);
        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).getUsername().equals(username))
                return true;
        }
        return false;
    }

    /**
     * @param username
     * @return User
     */
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * @param type
     * @return boolean addUser
     */
    public boolean addUser(String type) {
        if (type.equals("") || !type.equals("0") || !type.equals("1") || !type.equals("2")) {
            return false;
        }

        users.add(UserFactory.createUser(type));
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        UserList userlist = new UserList();

        userlist.addUser("2");
        userlist.saveUserList();

    }

    public void saveUserList() {
        DataWriter.saveUsers();
    }
}
