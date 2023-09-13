package academy.pocu.comp2500.assignment1;

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


}
