
public class UserFactory {
    public static User createUser(String type) {
        if (type.equalsIgnoreCase("student")) {
            return new Student();
        } else if (type.equalsIgnoreCase("employer")) {
            return new Employer();
        } else if (type.equalsIgnoreCase("administrator")) {
            return new Administrator();
        }

        return null;
    }
}