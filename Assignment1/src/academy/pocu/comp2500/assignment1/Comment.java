package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.HashMap;

public class Comment {
    private final String author;
    private String comment;
    private final HashMap<String, Vote> votes = new HashMap<>();
    private int upVoteCount;
    private int downVoteCount;
    private final ArrayList<Comment> subComments = new ArrayList<>();

    public Comment(User user, String comment) {
        this.author = user.getNames();
        this.comment = comment;
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
        sortByVote();
        return new ArrayList<>(subComments);
    }
    public Comment getSubComment(int subcommentId) {
        return subComments.get(subcommentId);
    }

    public void updateComment(User user, String comment) {
        if (this.author.equals(user.getNames())) {
            this.comment = comment;
        }
    }

    public void addSubComment(User user, String comment) {
        Comment newComment = new Comment(user, comment);
        subComments.add(newComment);
    }

    public void updateSubComment(User user, int subcommentId, String comment) {
        Comment subComment = this.subComments.get(subcommentId);
        if (subComment.getAuthor().equals(user.getNames())) {
            subComment.updateComment(user, comment);
        }
    }

    public void addUpVote(User user) {
        String userName = user.getNames();
        if (!votes.containsKey(userName)) {
            votes.put(userName, Vote.UP_VOTE);
            ++upVoteCount;
        } else if (votes.get(userName) == Vote.DOWN_VOTE) {
            votes.remove(userName);
            --downVoteCount;
        }
    }
    public void addDownVote(User user) {
        String userName = user.getNames();
        if (!votes.containsKey(userName)) {
            votes.put(userName, Vote.DOWN_VOTE);
            ++downVoteCount;
        } else if (votes.get(userName) == Vote.UP_VOTE) {
            votes.remove(userName);
            --upVoteCount;
        }
    }
    /*
    Comparator<Comment> byVote = new Comparator<Comment>() {
        @Override
        public int compare(Comment a1, Comment a2) {
            if (a1.getUpVoteCount() == a2.getUpVoteCount()) {
                return a1.getDownVoteCount() - a2.getDownVoteCount();
            }
            return a2.getUpVoteCount() - a1.getUpVoteCount();
        }
    };
    */
    private void sortByVote() {
        return;
    }
}
