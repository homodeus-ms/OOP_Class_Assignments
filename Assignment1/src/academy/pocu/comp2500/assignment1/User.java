package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class User {

    //private static final UserNumberFactory NUM_GENERATOR = new UserNumberFactory();

    private final String name;
    private final ArrayList<Post> wrotePosts;
    private final ArrayList<Comment> wroteComments;
    private final String emailAddress;
    //private final int userId;

    public User(String name, String emailAddress) {
        this.name = name;
        wrotePosts = new ArrayList<>();
        wroteComments = new ArrayList<>();
        this.emailAddress = emailAddress;
        //NUM_GENERATOR.increaseNum();
        //this.userId = NUM_GENERATOR.getNumber();
    }

    public String getUserName() {
        return name;
    }
    public void addPost(Post post) {
        wrotePosts.add(post);
    }
    public void addComment(Comment comment) {
        wroteComments.add(comment);
    }
    public boolean isUsersPost(Post post) {
        for (Post p : this.wrotePosts) {
            if (p == post) {
                return true;
            }
        }
        return false;
    }
    public boolean isUsersComment(Comment comment) {
        for (Comment c : this.wroteComments) {
            if (c == comment) {
                return true;
            }
        }
        return false;
    }

    public String getUserEmailAddress() {
        return emailAddress;
    }


}
