package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Blog {
    private ArrayList<Post> posts;
    private ArrayList<String> tagFilters;
    private String authorFilter;
    private SortingMethod sortingType = SortingMethod.BY_CREATED_TIME_DESC;

    public Blog() {
        posts = new ArrayList<>();
        tagFilters = new ArrayList<>();
    }

    public ArrayList<Post> getPosts() {
        if (posts.isEmpty()) {
            System.out.println("Posts is empty");
            return posts;
        }

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

        ArrayList<Post> filtered = new ArrayList<>();

        if (tagFilters.isEmpty() && authorFilter == null) {
            return new ArrayList<>(posts);
        } else if (!tagFilters.isEmpty() && authorFilter != null) {

            getAuthorFilteredPost(filtered);
            ArrayList<Post> temp = new ArrayList<>(filtered);
            filtered.clear();
            getTaggedPost(temp, filtered);

        } else if (authorFilter != null) {
            getAuthorFilteredPost(filtered);

        } else {
            getTaggedPost(this.posts, filtered);
        }

        return new ArrayList<>(filtered);
    }
    public Post getPost(int postId) {
        return this.posts.get(postId);
    }

    public void setSortType(SortingMethod sortingType) {
        this.sortingType = sortingType;
    }

    public void setTagFilter(String tag) {
        this.tagFilters.add(tag);
    }
    public void setAuthorFilter(String name) {
        this.authorFilter = name;
    }

    public void removeFilter() {
        this.sortingType = SortingMethod.BY_CREATED_TIME_DESC;
        this.tagFilters.clear();
        this.authorFilter = null;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    private void getAuthorFilteredPost(ArrayList<Post> filtered) {
        for (Post post : posts) {
            if (post.getAuthor().equals(authorFilter)) {
                filtered.add(post);
            }
        }
    }

    private void getTaggedPost(ArrayList<Post> posts, ArrayList<Post> filtered) {
        for (Post post : posts) {
            HashSet<String> tags = post.getTagsOrNull();

            for (String tag : tagFilters) {
                if (tags.contains(tag)) {
                    filtered.add(post);
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
