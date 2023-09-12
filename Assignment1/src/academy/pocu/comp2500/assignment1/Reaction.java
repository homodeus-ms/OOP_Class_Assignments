package academy.pocu.comp2500.assignment1;

public class Reaction {

    private User user;
    private Reactions reactionType;

    public Reaction(User user, Reactions reactionType) {
        this.user = user;
        this.reactionType = reactionType;
    }
    public User getUser() {
        return this.user;
    }
    public Reactions getReaction() {
        return this.reactionType;
    }

    @Override
    public int hashCode() {
        return user.hashCode() + reactionType.hashCode();
    }

    @Override
    public boolean equals(Object reaction) {

        Reaction other = (Reaction)reaction;

        return this.getUser().equals(other.getUser()) &&
                this.reactionType == other.reactionType;

    }
}
