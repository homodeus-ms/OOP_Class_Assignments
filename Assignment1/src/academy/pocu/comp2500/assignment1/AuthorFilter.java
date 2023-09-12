package academy.pocu.comp2500.assignment1;

public class AuthorFilter {
    private String authorFilter;
    private boolean filterOn;

    public AuthorFilter(String authorNameOrNull) {
        if (authorNameOrNull == null || authorNameOrNull.isEmpty()) {
            authorFilter = "";
            filterOn = false;
        } else {
            authorFilter = authorNameOrNull;
            filterOn = true;
        }
    }
    public AuthorFilter() {
        authorFilter = "";
        filterOn = false;
    }
    public AuthorFilter getAuthorFilter() {
        return this;
    }
    public String getName() {
        return this.authorFilter;
    }
    public boolean isFilterOn() {
        return this.filterOn;
    }

    public void setAuthorFilter(String authorNameOrNull) {
        if (authorNameOrNull == null || authorNameOrNull.isEmpty()) {
            authorFilter = "";
            filterOn = false;
            return;
        }
        authorFilter = authorNameOrNull;
        filterOn = true;
    }
    public void setFilterOn() {
        this.filterOn = true;
    }
    public void setFilterOff() {
        this.filterOn = false;
    }
}
