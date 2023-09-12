package academy.pocu.comp2500.assignment1;

import java.util.UUID;

public class User {
    private final String name;
    private final UUID userId;

    public User(String name) {
        this.name = name;
        this.userId = UUID.randomUUID();
    }

    public String getUserName() {
        return name;
    }
    public UUID getUserId() {
        return userId;
    }
}
