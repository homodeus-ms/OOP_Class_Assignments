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
    private final HashSet<String> tags;

    //Reaction.GREAT(0), reaction.SAD(1), Reaction.ANGRY(2), Reaction.FUN(3), Reaction.LOVE(4)
    private final HashMap<Reactions, ArrayList<User>> reactions;
    private final ArrayList<User> reactionGreat;
    private final ArrayList<User> reactionSad;
    private final ArrayList<User> reactionAngry;
    private final ArrayList<User> reactionFun;
    private final ArrayList<User> reactionLove;

    private final ArrayList<Comment> comments;

    public Post(User user, String title, String body) {

        this.title = title;
        this.body = body;
        this.author = user;
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = createdDateTime;
        this.comments = new ArrayList<>();

        tags = new HashSet<>();
        reactions = new HashMap<>();
        reactionGreat = new ArrayList<>();
        reactionSad = new ArrayList<>();
        reactionAngry = new ArrayList<>();
        reactionFun = new ArrayList<>();
        reactionLove = new ArrayList<>();

        reactions.put(Reactions.GREAT, reactionGreat);
        reactions.put(Reactions.SAD, reactionSad);
        reactions.put(Reactions.ANGRY, reactionAngry);
        reactions.put(Reactions.FUN, reactionFun);
        reactions.put(Reactions.LOVE, reactionLove);
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
    public int getReactions(Reactions reaction) {
        return this.reactions.get(reaction).size();
    }

    public void updateTitle(User user, String title) {

        if (this.author.isSameUser(user)) {
            this.title = title;
            updateModifiedTime();
        }
    }
    public void updateBody(User user, String body) {
        if (this.author.isSameUser(user)) {
            this.body = body;
            updateModifiedTime();
        }
    }

    public void addTag(String tag) {
        tags.add(tag);
    }
    public void resetTag() {
        tags.clear();
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void addReaction(User user, Reactions reaction) {
        ArrayList<User> reactedUserList = this.reactions.get(reaction);
        for (User u : reactedUserList) {
            if (this.author.isSameUser(user)) {
                return;
            }
        }
        this.reactions.get(reaction).add(user);
    }
    public void removeReaction(User user, Reactions reaction) {
        ArrayList<User> reactedUserList = this.reactions.get(reaction);
        for (User u : reactedUserList) {
            if (this.author.isSameUser(user)) {
                reactedUserList.remove(u);
                return;
            }
        }
    }

    private void updateModifiedTime() {
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
