package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Post {
    private String title;
    private String body;
    private final User author;
    private final OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private HashSet<String> tags;
    //Reaction.GREAT(0), reaction.SAD(1), Reaction.ANGRY(2), Reaction.FUN(3), Reaction.LOVE(4)
    //private HashMap<Reaction, HashSet<User>> reactions;
    private HashSet<User> reactionGreat;
    private HashSet<User> reactionSad;
    private HashSet<User> reactionAngry;
    private HashSet<User> reactionFun;
    private HashSet<User> reactionLove;
    private ArrayList<Comment> comments;


    public Post(User user, String title, String body) {

        this.title = title;
        this.body = body;
        this.author = user;
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = createdDateTime;
        this.comments = new ArrayList<>();

        tags = new HashSet<>();
        //reactions = new HashMap<>();
        reactionGreat = new HashSet<>();
        reactionSad = new HashSet<>();
        reactionAngry = new HashSet<>();
        reactionFun = new HashSet<>();
        reactionLove = new HashSet<>();
    }


    public String getTitle() {
        return this.title;
    }
    public String getBody() {
        return this.body;
    }
    public String getAuthorName() {
        return this.author.getUserName();
    }
    public User getAuthor() {
        return this.author;
    }
    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }
    public OffsetDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }
    public HashSet<String> getTags() {
        return tags;
    }
    public ArrayList<Comment> getComments() {
        sortByVoteComments();
        return this.comments;
    }
    public Comment getCommentOrNull(int at) {
        if (this.comments.isEmpty()) {
            return null;
        }
        sortByVoteComments();
        return this.comments.get(at);
    }

    public int getReactionGreatCount() {
        return this.reactionGreat.size();
    }
    public int getReactionSadCount() {
        return this.reactionSad.size();
    }
    public int getReactionAngryCount() {
        return this.reactionAngry.size();
    }
    public int getReactionFunCount() {
        return this.reactionFun.size();
    }
    public int getReactionLoveCount() {
        return this.reactionLove.size();
    }

    public void updateTitle(Post post, User user, String title) {

        if (post.getAuthor().equals(user) && !title.isEmpty()) {
            post.title = title;
            upDateModifiedTime();
        }
    }
    public void updateBody(Post post, User user, String body) {

        if (this.author.equals(user)) {
            post.body = body;
            upDateModifiedTime();
        }
    }




    public void addTag(String tag) {
        tags.add(tag);
    }
    public void resetTag() {
        tags.clear();
    }

    public void addComment(Comment comment) {
        this.comments.add(0, comment);
    }

    public void addReaction(User user, Reaction reaction) {
        switch (reaction) {
            case GREAT:
                reactionGreat.add(user);
                //reactions.put(Reaction.GREAT, reactionGreat);
                break;
            case SAD:
                reactionSad.add(user);
                //reactions.put(Reaction.SAD, reactionSad);
                break;
            case ANGRY:
                reactionAngry.add(user);
                //reactions.put(Reaction.ANGRY, reactionAngry);
                break;
            case FUN:
                reactionFun.add(user);
                //reactions.put(Reaction.FUN, reactionFun);
                break;
            case LOVE:
                reactionLove.add(user);
                //reactions.put(Reaction.LOVE, reactionLove);
                break;
            default:
                assert (false) : "Unknown reaction!";
                break;
        }
    }
    public void removeReaction(User user, Reaction reaction) {
        switch (reaction) {
            case GREAT:
                reactionGreat.remove(user);
                //reactions.put(Reaction.GREAT, reactionGreat);
                break;
            case SAD:
                reactionSad.remove(user);
                //reactions.put(Reaction.SAD, reactionSad);
                break;
            case ANGRY:
                reactionAngry.remove(user);
                //reactions.put(Reaction.ANGRY, reactionAngry);
                break;
            case FUN:
                reactionFun.remove(user);
                //reactions.put(Reaction.FUN, reactionFun);
                break;
            case LOVE:
                reactionLove.remove(user);
                //reactions.put(Reaction.LOVE, reactionLove);
                break;
            default:
                assert (false) : "Unknown reaction!";
                break;
        }
    }

    private void upDateModifiedTime() {
        this.modifiedDateTime = OffsetDateTime.now();
    }


    private void sortByVoteComments() {
        Collections.sort(comments, (c1, c2) -> {
            int upVoteDifference = Integer.compare(c2.getUpVoteCount(), c1.getUpVoteCount());
            if (upVoteDifference == 0) {
                return Integer.compare(c1.getDownVoteCount(), c2.getDownVoteCount());
            }
            return upVoteDifference;
        });
    }
}
