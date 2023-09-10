package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Comment {
    private String author;
    private String comment;
    private HashMap<String, Vote> votes;
    private int upVoteCount;
    private int downVoteCount;
    private final ArrayList<Comment> subComments;

    public Comment(User user, String comment) {
        this.author = user.getUserId();
        this.comment = comment;
        this.votes = new HashMap<>();
        this.upVoteCount = 0;
        this.downVoteCount = 0;
        this.subComments = new ArrayList<>();
    }

    public String getAuthor() {
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
    public ArrayList<Comment> getSubComments() {
        sortByVoteSubComments();
        return this.subComments;
    }


    public void updateComment(User user, String comment) {
        if (this.author.equals(user.getUserId())) {
            this.comment = comment;
        }
    }

    public void addSubComment(User user, String comment) {
        Comment newComment = new Comment(user, comment);
        subComments.add(newComment);
    }

    public void updateSubComment(User user, int subcommentId, String comment) {
        Comment subComment = this.subComments.get(subcommentId);
        if (subComment.getAuthor().equals(user.getUserId())) {
            subComment.updateComment(user, comment);
        }
    }

    public void addUpVote(User user) {
        String userId = user.getUserId();
        if (!votes.containsKey(userId)) {
            votes.put(userId, Vote.UP_VOTE);
            ++upVoteCount;
        } else if (votes.get(userId) == Vote.DOWN_VOTE) {
            votes.remove(userId);
            --downVoteCount;
        }
    }
    public void addDownVote(User user) {
        String userId = user.getUserId();
        if (!votes.containsKey(userId)) {
            votes.put(userId, Vote.DOWN_VOTE);
            ++downVoteCount;
        } else if (votes.get(userId) == Vote.UP_VOTE) {
            votes.remove(userId);
            --upVoteCount;
        }
    }

    private void sortByVoteSubComments() {
        Collections.sort(subComments, (c1, c2) -> {
            int upVoteDifference = Integer.compare(c2.getUpVoteCount(), c1.getUpVoteCount());
            if (upVoteDifference == 0) {
                return Integer.compare(c1.getDownVoteCount(), c2.getDownVoteCount());
            }
            return upVoteDifference;
        });
    }
}
