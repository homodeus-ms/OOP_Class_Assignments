package academy.pocu.comp2500.assignment1;

import java.util.HashSet;

public class TagFilter {
    private HashSet<String> tags;

    public TagFilter(String tag) {
        tags = new HashSet<>();
        tags.add(tag);
    }
    public TagFilter() {
        tags = new HashSet<>();
    }

    public TagFilter getTagFilter() {
        return this;
    }
    public HashSet<String> getTags() {
        return this.tags;
    }
    public void removeAllTags() {
        tags.clear();
    }
}
