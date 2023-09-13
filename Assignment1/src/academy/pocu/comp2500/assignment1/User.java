package academy.pocu.comp2500.assignment1;

import java.util.UUID;

public class User {

    private static final UserNumberFactory numGenerator = new UserNumberFactory();

    private final String name;
    private final String emailAddress;
    private final int userId;

    public User(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
        numGenerator.increaseNum();
        this.userId = numGenerator.getNumber();
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
