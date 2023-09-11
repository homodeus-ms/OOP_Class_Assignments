package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Tag {
    private final ArrayList<String> tagFilters;

    public Tag() {
        tagFilters = new ArrayList<>();
    }
    public Tag(String tag) {
        tagFilters = new ArrayList<>();
        tagFilters.add(tag);
    }
    public ArrayList<String> getTagFilters() {
        return new ArrayList<>(tagFilters);
    }
    public void setTagFilter(String tag) {
        tagFilters.add(tag);
    }
}
