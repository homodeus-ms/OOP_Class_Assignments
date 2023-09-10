package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Blog {
    private ArrayList<Post> posts;
    private ArrayList<String> tagFilters;
    private ArrayList<Post> filteredPosts;

    private String authorFilter;
    private SortingType sortingType;

    public Blog() {

        posts = new ArrayList<>();
        tagFilters = new ArrayList<>();
        filteredPosts = new ArrayList<>();
        authorFilter = "";
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

        if (tagFilters.isEmpty() && authorFilter.isEmpty()) {
            return posts;

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

    public ArrayList<String> getTags() {
        return new ArrayList<>(this.tagFilters);
    }
    public String getAuthorFilter() {
        return this.authorFilter;
    }
    public ArrayList<Post> getFilteredPosts() {
        return new ArrayList<>(this.filteredPosts);
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
    public void setTagFilter(String tag) {
        this.tagFilters.add(tag);
    }
    public void removeTagFilter() {
        this.tagFilters.clear();
    }
    public void setAuthorFilter(String authorName) {
        this.authorFilter = authorName;
    }
    public void removeAuthorFilter() {
        this.authorFilter = "";
    }

    public void addPost(Post post) {
        this.posts.add(0, post);
    }

    private void getAuthorFilteredPosts() {
        for (Post post : posts) {
            if (post.getAuthor().getUserName().equals(authorFilter)) {
                filteredPosts.add(post);
            }
        }
    }
    private void getTaggedPosts(ArrayList<Post> posts) {
        ArrayList<Post> temp = new ArrayList<>(posts);
        filteredPosts.clear();

        for (Post post : temp) {
            HashSet<String> tags = post.getTags();

            for (String tag : tagFilters) {
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
