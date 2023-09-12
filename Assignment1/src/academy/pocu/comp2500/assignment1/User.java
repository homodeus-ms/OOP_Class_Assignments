package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class User {
    private final String name;
    private final String userId;
    private static final ArrayList<String> USERS = new ArrayList<>();

    public User(String name) {
        this.name = name;
        USERS.add(name);
        this.userId = name + USERS.lastIndexOf(name);
    }

    public String getUserName() {
        return name;
    }
    public String getUserId() {
        return userId;
    }

    public boolean isSameUser(User user) {
        if (this.userId.equals(user.userId) && this.name.equals(user.name)) {
            return true;
        }
        return false;
    }
}
