package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Post> posts;
    //private ArrayList<String> tagFilters;
    //private ArrayList<Post> filteredPosts;

    //private String authorFilter;
    //private SortingMethod sortingType;

    public Blog() {
        posts = new ArrayList<>();
        //tagFilters = new ArrayList<>();
        //filteredPosts = new ArrayList<>();
        //authorFilter = "";
        //sortingType = SortingMethod.BY_CREATED_TIME_DESC;
    }

    public ArrayList<Post> getPosts() {
        return new ArrayList<>(posts);
    }
    /*
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
    */

    public void setSortType(SortingMethod sortingType) {
        //this.sortingType = sortingType;
    }
    public void setTagFilter(String tag) {
        //this.tagFilters.add(tag);
    }
    public void setAuthorFilter(String name) {
        //this.authorFilter = name;
    }

    public void addPost(Post post) {
        this.posts.add(0, post);
    }

    private void getAuthorFilteredPost() {

    }
    private void getTaggedPost(ArrayList<Post> posts) {


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
