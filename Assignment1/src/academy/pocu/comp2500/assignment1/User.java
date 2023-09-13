package academy.pocu.comp2500.assignment1;

public class User {

    private static final UserNumberFactory NUM_GENERATOR = new UserNumberFactory();

    private final String name;
    private final String emailAddress;
    private final int userId;

    public User(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
        NUM_GENERATOR.increaseNum();
        this.userId = NUM_GENERATOR.getNumber();
    }

    public String getUserName() {
        return name;
    }
    public int getUserId() {
        return this.userId;
    }
    public String getUserEmailAddress() {
        return emailAddress;
    }
}
