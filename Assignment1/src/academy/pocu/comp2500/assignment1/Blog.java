package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Blog {
    private ArrayList<Post> posts;
    private ArrayList<String> tagFilters;
    private ArrayList<Post> filteredPosts;

    private String authorFilter;
    private SortingMethod sortingType;

    public Blog() {
        posts = new ArrayList<>();
        tagFilters = new ArrayList<>();
        filteredPosts = new ArrayList<>();
        authorFilter = "";
        sortingType = SortingMethod.BY_CREATED_TIME_DESC;
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

        if (tagFilters.isEmpty() && authorFilter.equals("")) {
            return posts;

        } else if (!tagFilters.isEmpty() && !authorFilter.equals("")) {

            getAuthorFilteredPost();
            getTaggedPost(filteredPosts);

        } else if (!authorFilter.equals("")) {
            getAuthorFilteredPost();

        } else {
            getTaggedPost(posts);
        }

        return filteredPosts;
    }

    public ArrayList<String> getTags() {
        return new ArrayList<>(this.tagFilters);
    }

    public String getAuthorFilter() {
        return this.authorFilter;
    }

    public SortingMethod getSortingType() {
        return this.sortingType;
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

    public void removeAllFilter() {
        this.sortingType = SortingMethod.BY_CREATED_TIME_DESC;
        this.tagFilters.clear();
        this.authorFilter = null;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    private void getAuthorFilteredPost() {
        for (Post post : posts) {
            if (post.getAuthor().equals(authorFilter)) {
                filteredPosts.add(post);
            }
        }
    }
    private void getTaggedPost(ArrayList<Post> posts) {

        //ArrayList<Post> temp = new ArrayList<>(posts);
        //filteredPosts.clear();

        for (Post post : this.posts) {
            HashSet<String> tags = post.getTagsOrNull();

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
