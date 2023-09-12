package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Blog {

    private ArrayList<Post> posts;
    private ArrayList<Post> filteredPosts;

    private TagFilter tagFilter;
    private HashSet<String> tags;
    private AuthorFilter authorFilter;
    private SortingType sortingType;

    public Blog() {

        posts = new ArrayList<>();
        tagFilter = new TagFilter();
        tags = tagFilter.getTags();
        filteredPosts = new ArrayList<>();

        authorFilter = new AuthorFilter();
        sortingType = SortingType.BY_CREATED_TIME_DESC;
    }

    public ArrayList<Post> getPosts() {
        switch (sortingType) {
            case BY_CREATED_TIME_DESC:
                sortByCreatedTimeDesc();
                break;
            case BY_CREATED_TIME:
                sortByCreatedTime();
                break;
            case BY_MODIFIED_TIME_DESC:
                sortByModifiedTimeDesc();
                break;
            case BY_MODIFIED_TIME:
                sortByModifiedTime();
                break;
            case BY_TITLE:
                sortByTitle();
                break;
            default:
                assert (false) : "there are only 5 types";
                break;
        }

        if (tags.isEmpty() && (!authorFilter.isFilterOn() || authorFilter.getName().isEmpty())) {
            return this.posts;

        } else if (!tags.isEmpty() && authorFilter.isFilterOn()) {

            getAuthorFilteredPosts();
            getTaggedPosts(filteredPosts);

        } else if (authorFilter.isFilterOn()) {
            getAuthorFilteredPosts();

        } else {
            getTaggedPosts(posts);
        }

        return filteredPosts;
    }
    public HashSet<String> getTags() {
        return this.tags;
    }
    public String getAuthorFilter() {
        return this.authorFilter.getName();
    }
    public ArrayList<Post> getFilteredPosts() {
        return this.filteredPosts;
    }
    public SortingType getSortingType() {
        return this.sortingType;
    }

    public void setSortType(SortingType sortingType) {
        this.sortingType = sortingType;
    }
    public void removeSortType() {
        this.sortingType = SortingType.BY_CREATED_TIME_DESC;
    }
    public void setTagFilter(TagFilter tag) {
        this.tagFilter = tag;
        this.tags = tag.getTags();
    }

    public void setAuthorFilter(AuthorFilter authorName) {
        this.authorFilter = authorName;
    }

    public void addPost(Post post) {

        this.posts.add(0, post);
    }

    private void getAuthorFilteredPosts() {

        for (Post post : posts) {
            if (post.getAuthor().getUserName().equals(authorFilter.getName())) {
                filteredPosts.add(post);
            }
        }
    }
    private void getTaggedPosts(ArrayList<Post> posts) {
        ArrayList<Post> temp = new ArrayList<>(posts);
        filteredPosts.clear();

        for (Post post : temp) {
            HashSet<String> tags = post.getTags();

            for (String tag : this.tags) {
                if (tags.contains(tag)) {
                    filteredPosts.add(post);
                    break;
                }
            }
        }
    }


    private void sortByCreatedTimeDesc() {
        Collections.sort(posts, (p1, p2) -> p2.getCreatedDateTime().compareTo(p1.getCreatedDateTime()));
    }
    private void sortByCreatedTime() {
        Collections.sort(posts, (p1, p2) -> p1.getCreatedDateTime().compareTo(p2.getCreatedDateTime()));
    }
    private void sortByModifiedTimeDesc() {
        Collections.sort(posts, (p1, p2) -> p2.getModifiedDateTime().compareTo(p1.getModifiedDateTime()));
    }
    private void sortByModifiedTime() {
        Collections.sort(posts, (p1, p2) -> p1.getModifiedDateTime().compareTo(p2.getModifiedDateTime()));
    }
    private void sortByTitle() {
        Collections.sort(posts, (p1, p2) -> p1.getTitle().compareTo(p2.getTitle()));
    }
}
