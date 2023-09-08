package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Post {
    private String title;
    private String body;
    private final String author;
    private final OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private final HashSet<String> tags = new HashSet<>();
    // Reaction.GREAT(0), reaction.SAD(1), Reaction.ANGRY(2), Reaction.FUN(3), Reaction.LOVE(4)
    private HashMap<Reaction, HashSet<User>> reactions = new HashMap<>();
    private final HashSet<User> reactionGreat = new HashSet<>();
    private final HashSet<User> reactionSad = new HashSet<>();
    private final HashSet<User> reactionAngry = new HashSet<>();
    private final HashSet<User> reactionFun = new HashSet<>();
    private final HashSet<User> reactionLove = new HashSet<>();

    private final ArrayList<Comment> comments = new ArrayList<>();

    public Post(User user, String title, String content) {
        this.title = title;
        this.body = content;
        this.author = user.getNames();
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = this.createdDateTime;
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
    public HashSet<String> getTagsOrNull() {
        return new HashSet<>(this.tags);
    }
    public ArrayList<Comment> getComments() {
        sortByVoteComments();
        return new ArrayList<>(this.comments);
    }
    public Comment getComment(int commentId) {
        return this.comments.get(commentId);
    }
    public int getReactionGreatCount() {
        return reactionGreat.size();
    }
    public int getReactionSadCount() {
        return reactionSad.size();
    }
    public int getReactionAngryCount() {
        return reactionAngry.size();
    }
    public int getReactionFunCount() {
        return reactionFun.size();
    }
    public int getReactionLoveCount() {
        return reactionLove.size();
    }

    public void updateTitle(User user, String title) {
        if (user.getNames().equals(this.author)) {
            this.title = title;
            upDateModifiedTime();
        }
    }
    public void updateBody(User user, String body) {
        if (user.getNames().equals(this.author)) {
            this.body = body;
            upDateModifiedTime();
        }
    }
    public void addTag(String tag) {
        tags.add(tag);
    }

    public void addComment(User user, String comment) {
        Comment newComment = new Comment(user, comment);
        this.comments.add(newComment);
    }

    public void addReaction(User user, Reaction reaction) {
        switch (reaction) {
            case GREAT:
                reactionGreat.add(user);
                reactions.put(Reaction.GREAT, reactionGreat);
                break;
            case SAD:
                reactionSad.add(user);
                reactions.put(Reaction.SAD, reactionSad);
                break;
            case ANGRY:
                reactionAngry.add(user);
                reactions.put(Reaction.ANGRY, reactionAngry);
                break;
            case FUN:
                reactionFun.add(user);
                reactions.put(Reaction.FUN, reactionFun);
                break;
            case LOVE:
                reactionLove.add(user);
                reactions.put(Reaction.LOVE, reactionLove);
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
                reactions.put(Reaction.GREAT, reactionGreat);
                break;
            case SAD:
                reactionSad.remove(user);
                reactions.put(Reaction.SAD, reactionSad);
                break;
            case ANGRY:
                reactionAngry.remove(user);
                reactions.put(Reaction.ANGRY, reactionAngry);
                break;
            case FUN:
                reactionFun.remove(user);
                reactions.put(Reaction.FUN, reactionFun);
                break;
            case LOVE:
                reactionLove.remove(user);
                reactions.put(Reaction.LOVE, reactionLove);
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
