package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Blog {

    private ArrayList<Post> posts;
    private ArrayList<Post> filteredPosts;

    private HashSet<String> tagFilters;
    private String authorFilter;
    private SortingType sortingType;

    public Blog() {
        posts = new ArrayList<>();
        filteredPosts = new ArrayList<>();
        tagFilters = new HashSet<>();
        authorFilter = "";
        sortingType = SortingType.BY_CREATED_TIME_DESC;
    }

    public ArrayList<Post> getPosts() {

        sortPosts();

        filteredPosts.clear();

        if (tagFilters.isEmpty() && authorFilter.isEmpty()) {
            return this.posts;

        } else if (!tagFilters.isEmpty() && !authorFilter.isEmpty()) {

            getAuthorFilteredPosts();
            getTaggedPosts(filteredPosts);

        } else if (!authorFilter.isEmpty()) {
            getAuthorFilteredPosts();

        } else {
            getTaggedPosts(posts);
        }

        return filteredPosts;
    }
    public HashSet<String> getTagFilters() {
        return this.tagFilters;
    }
    public String getAuthorFilter() {
        return this.authorFilter;
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
    /*
    public void removeSortType() {
        this.sortingType = SortingType.BY_CREATED_TIME_DESC;
    }
    */

    public void setTagFilter(String tag) {
        if (!tagFilters.isEmpty()) {
            this.tagFilters.clear();
        }
        this.tagFilters.add(tag);
    }
    public void setTagFilter(ArrayList<String> tags) {
        this.tagFilters.clear();
        tagFilters.addAll(tags);
    }
    public void setAuthorFilter(User userOrNull) {
        if (userOrNull == null) {
            authorFilter = "";
            return;
        }
        this.authorFilter = userOrNull.getUserName();
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    private void getAuthorFilteredPosts() {
        for (Post post : posts) {
            if (post.getAuthor().getUserName().equals(authorFilter)) {
                filteredPosts.add(post);
            }
        }
    }
    private void getTaggedPosts(ArrayList<Post> posts) {
        ArrayList<Post> firstFiltered = new ArrayList<>(posts);
        filteredPosts.clear();

        for (Post post : firstFiltered) {
            HashSet<String> tags = post.getTags();

            assert (!tagFilters.isEmpty()) : "Error of filters condition";

            for (String tag : this.tagFilters) {
                if (tags.contains(tag)) {
                    filteredPosts.add(post);
                    break;
                }
            }
        }
    }

    private void sortPosts() {
        switch (this.sortingType) {
            case BY_CREATED_TIME_DESC:
                Collections.sort(posts, (p1, p2) -> p2.getCreatedDateTime().compareTo(p1.getCreatedDateTime()));
                break;
            case BY_CREATED_TIME:
                Collections.sort(posts, (p1, p2) -> p1.getCreatedDateTime().compareTo(p2.getCreatedDateTime()));
                break;
            case BY_MODIFIED_TIME_DESC:
                Collections.sort(posts, (p1, p2) -> p2.getModifiedDateTime().compareTo(p1.getModifiedDateTime()));
                break;
            case BY_MODIFIED_TIME:
                Collections.sort(posts, (p1, p2) -> p1.getModifiedDateTime().compareTo(p2.getModifiedDateTime()));
                break;
            case BY_TITLE:
                Collections.sort(posts, (p1, p2) -> p1.getTitle().compareTo(p2.getTitle()));
                break;
            default:
                assert (false) : "there are only 5 types";
                break;
        }
    }
    /*
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
    */

}
