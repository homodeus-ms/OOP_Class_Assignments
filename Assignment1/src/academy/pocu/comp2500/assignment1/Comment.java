package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Comment {
    private final User author;
    private String comment;
    private final HashMap<User, Vote> votes;
    private int upVoteCount;
    private int downVoteCount;
    private final ArrayList<Comment> comments;

    public Comment(User author, String comment) {
        this.author = author;
        this.comment = comment;
        this.votes = new HashMap<>();
        this.comments = new ArrayList<>();
    }
    public String getAuthorName() {
        return this.author.getUserName();
    }
    public User getAuthor() {
        return this.author;
    }
    public String getComment() {
        return this.comment;
    }
    public int getUpVoteCount() {
        return upVoteCount;
    }
    public int getDownVoteCount() {
        return downVoteCount;
    }
    public ArrayList<Comment> getComments() {
        sortByVoteComments();
        return this.comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void updateComment(User user, String comment) {
        if (this.author.isSameUser(user)) {
            this.comment = comment;
        }
    }

    public void addUpVote(User user) {

        if (!votes.containsKey(user)) {
            votes.put(user, Vote.UP_VOTE);
            ++upVoteCount;
        } else if (votes.get(user) == Vote.DOWN_VOTE) {
            votes.remove(user);
            --downVoteCount;
        }
    }
    public void addDownVote(User user) {

        if (!votes.containsKey(user)) {
            votes.put(user, Vote.DOWN_VOTE);
            ++downVoteCount;
        } else if (votes.get(user) == Vote.UP_VOTE) {
            votes.remove(user);
            --upVoteCount;
        }
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
