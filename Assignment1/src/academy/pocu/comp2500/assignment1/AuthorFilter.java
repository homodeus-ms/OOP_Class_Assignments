package academy.pocu.comp2500.assignment1;

public class AuthorFilter {
    String authorFilter;

    public AuthorFilter(String authorNameOrNull) {
        if (authorNameOrNull == null) {
            authorFilter = "";
        } else {
            authorFilter = authorNameOrNull;
        }
    }
    public AuthorFilter() {
        authorFilter = "";
    }
    public AuthorFilter getAuthorFilter() {
        return this;
    }
    public String getName() {
        return this.authorFilter;
    }
    public boolean isEmpty() {
        if (this.authorFilter.isEmpty()) {
            return true;
        }
        return false;
    }
    public void setAuthorFilter(String authorNameOrNull) {
        if (authorNameOrNull == null) {
            authorFilter = "";
            return;
        }
        authorFilter = authorNameOrNull;
    }
}
