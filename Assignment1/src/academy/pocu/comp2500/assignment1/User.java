package academy.pocu.comp2500.assignment1;

import java.util.HashSet;

public class User {
    private String name;
    private static final HashSet<String> USERS = new HashSet<>();
    public User(String name) {
        if (User.USERS.add(name)) {
            this.name = name;
        }
    }
    public String getNames() {
        return this.name;
    }
}
