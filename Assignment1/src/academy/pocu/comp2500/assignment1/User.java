package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class User {
    private String name;
    private String userId;
    private static final ArrayList<String> USERS = new ArrayList<>();

    public User(String name) {
        USERS.add(name);
        this.userId = name + USERS.indexOf(name);
    }

    public String getName() {
        return this.name;
    }
    public String getUserId() {
        return userId;
    }
}
