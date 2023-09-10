package academy.pocu.comp2500.assignment1;

import java.util.HashSet;

public class User {
    private String name;
    private static final HashSet<String> USERS = new HashSet<>();
    public User(String name) {

        assert (name != null) : "User name is null";

        if (User.USERS.add(name)) {
            this.name = name;
        } else {
            assert (false) : "User Name already exist";
        }
    }

    public String getName() {
        return this.name;
    }
}
