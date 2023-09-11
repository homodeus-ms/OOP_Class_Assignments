package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Blog {
    private final ArrayList<Post> posts;
    private ArrayList<String> tagFilters;
    private final ArrayList<Post> filteredPosts;

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
        if (tagFilters.isEmpty() && authorFilter.isEmpty()) {
            sortBySotingType(posts);
            return new ArrayList<>(posts);

        } else if (!tagFilters.isEmpty() && !authorFilter.isEmpty()) {

            getAuthorFilteredPosts();
            getTaggedPosts(filteredPosts);

        } else if (!authorFilter.isEmpty()) {
            getAuthorFilteredPosts();

        } else {
            getTaggedPosts(posts);
        }

        sortBySotingType(filteredPosts);
        return new ArrayList<>(filteredPosts);
    }
    public Post getPostOrNull(int at) {
        if (this.posts.isEmpty()) {
            return null;
        }
        if (tagFilters.isEmpty() && authorFilter.isEmpty()) {
            return this.posts.get(at);
        } else {
            return this.filteredPosts.get(at);
        }
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
    public void setTagFilter(Tag tag) {
        this.tagFilters = tag.getTagFilters();
    }
    public void setAuthorFilter(AuthorFilter author) {
        this.authorFilter = author.getAuthorFilter();
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

    private void sortBySotingType(ArrayList<Post> target) {
        switch (this.sortingType) {
            case BY_CREATED_TIME_DESC:
                sortByCreatedTimeDesc(target);
                break;
            case BY_CREATED_TIME:
                sortByCreatedTime(target);
                break;
            case BY_MODIFIED_TIME_DESC:
                sortByModifiedTimeDesc(target);
                break;
            case BY_MODIFIED_TIME:
                sortByModifiedTime(target);
                break;
            case BY_TITLE:
                sortByTitle(target);
                break;
            default:
                assert (false) : "there are only 5 types";
                break;
        }
    }

    private void sortByCreatedTimeDesc(ArrayList<Post> target) {
        Collections.sort(target, (p1, p2) -> p2.getCreatedDateTime().compareTo(p1.getCreatedDateTime()));
    }
    private void sortByCreatedTime(ArrayList<Post> target) {
        Collections.sort(target, (p1, p2) -> p1.getCreatedDateTime().compareTo(p2.getCreatedDateTime()));
    }
    private void sortByModifiedTimeDesc(ArrayList<Post> target) {
        Collections.sort(target, (p1, p2) -> p2.getModifiedDateTime().compareTo(p1.getModifiedDateTime()));
    }
    private void sortByModifiedTime(ArrayList<Post> target) {
        Collections.sort(target, (p1, p2) -> p1.getModifiedDateTime().compareTo(p2.getModifiedDateTime()));
    }
    private void sortByTitle(ArrayList<Post> target) {
        Collections.sort(target, (p1, p2) -> p1.getTitle().compareTo(p2.getTitle()));
    }

}
