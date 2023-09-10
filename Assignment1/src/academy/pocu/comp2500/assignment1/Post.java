package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Post {
    private String title;
    private String body;
    private User user;

    private String author;
    private final OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private HashSet<String> tags;
    // Reaction.GREAT(0), reaction.SAD(1), Reaction.ANGRY(2), Reaction.FUN(3), Reaction.LOVE(4)
    //private HashMap<Reaction, HashSet<User>> reactions;
    //private HashSet<User> reactionGreat;
    //private HashSet<User> reactionSad;
    //private HashSet<User> reactionAngry;
    //private HashSet<User> reactionFun;
    //private HashSet<User> reactionLove;

    private ArrayList<Comment> comments;

    public Post(User user, String title, String body) {
        assert (user != null) : "User is null";
        assert (title != null) : "Post title is null";
        assert (body != null) : "Post body is null";

        this.title = title;
        this.body = body;
        this.user = user;
        this.author = user.getName();

        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = this.createdDateTime;

        tags = new HashSet<>();
        //reactions = new HashMap<>();
        //reactionGreat = new HashSet<>();
        //reactionSad = new HashSet<>();
        //reactionAngry = new HashSet<>();
        //reactionFun = new HashSet<>();
        //reactionLove = new HashSet<>();

        comments = new ArrayList<>();
    }
    public User getUser() {
        return this.user;
    }
    public String getTitle() {
        return this.title;
    }
    public String getBody() {
        return this.body;
    }
    public String getAuthor() {
        return this.author;
    }
    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }
    public OffsetDateTime getModifiedDateTime() {
        return this.modifiedDateTime;
    }
    public HashSet<String> getTags() {
        return this.tags;
    }
    /*
    public HashMap<Reaction, HashSet<User>> getReactions() {
        return new HashMap<>(this.reactions);
    }

     */

    public ArrayList<Comment> getComments() {
        //sortByVoteComments();
        return this.comments;
    }



/*
    public Comment getComment(int commentId) {
        return this.comments.get(commentId);
    }

 */


    /*
    public int getReactionGreatCount() {
        return 0;
    }
    public int getReactionSadCount() {
        return 0;
    }
    public int getReactionAngryCount() {
        return 0;
    }
    public int getReactionFunCount() {
        return 0;
    }
    public int getReactionLoveCount() {
        return 0;
    }

     */

    public void updateTitle(User user, String title) {
        //if (user.getName().equals(this.author)) {
        //    this.title = title;
        //    upDateModifiedTime();
        //}
    }
    public void updateBody(User user, String body) {
        //if (user.getName().equals(this.author)) {
        //    this.body = body;
        //    upDateModifiedTime();
        //}
    }

    public void addTag(String tag) {
        tags.add(tag);
    }
    public void resetTag() {
        tags.clear();
    }

    public void addComment(User user, String comment) {
        Comment newComment = new Comment(user, comment);
        this.comments.add(newComment);
    }


    public void addReaction(User user, Reaction reaction) {

    }

    public void removeReaction(User user, Reaction reaction) {

    }

    private void upDateModifiedTime() {
        this.modifiedDateTime = OffsetDateTime.now();
    }

    /*
    private void sortByVoteComments() {
        Collections.sort(comments, (c1, c2) -> {
            int upVoteDifference = Integer.compare(c2.getUpVoteCount(), c1.getUpVoteCount());
            if (upVoteDifference == 0) {
                return Integer.compare(c1.getDownVoteCount(), c2.getDownVoteCount());
            }
            return upVoteDifference;
        });
    }
    */

}
