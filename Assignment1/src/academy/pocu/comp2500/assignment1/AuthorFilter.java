package academy.pocu.comp2500.assignment1;

public class AuthorFilter {
    private String authorName;

    AuthorFilter(String nameOrNull) {
        if (nameOrNull == null || nameOrNull.isEmpty()) {
            authorName = "";
        } else {
            authorName = nameOrNull;
        }
    }
    public String getAuthorFilter() {
        return authorName;
    }
    public void setAuthorFilter(String nameOrNull) {
        if (nameOrNull == null || nameOrNull.isEmpty()) {
            authorName = "";
        } else {
            authorName = nameOrNull;
        }
    }
}
