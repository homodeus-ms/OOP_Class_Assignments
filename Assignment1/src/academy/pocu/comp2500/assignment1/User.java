package academy.pocu.comp2500.assignment1;

import java.util.UUID;

public class User {
    private final String name;
    private final String emailAddress;

    public User(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return name;
    }
    public String getUserEmailAddress() {
        return emailAddress;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + emailAddress.hashCode();
    }

    @Override
    public boolean equals(Object user) {
        if (this == user) {
            return true;
        }
        if (user == null) {
            return false;
        }

        User other = (User)user;

        return this.name.equals((other.name)) && this.emailAddress.equals(other.emailAddress);
    }


}
