package academy.pocu.comp2500.assignment1;

import java.util.HashSet;

public class User {
    private String name;
    private static final HashSet<String> users = new HashSet<>();

    public User(String name) {
        if (this.users.add(name)) {
            this.name = name;

        } else {
            assert(false);
        }
    }
    public String getNames() {
        return this.name;
    }


}
