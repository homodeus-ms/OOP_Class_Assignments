package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Blog {
    private ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<Post> filteredPosts = new ArrayList<>();
    private String ownerName;

    private boolean tagFiltered;
    private boolean authorFiltered;
    private boolean sortFilter;

    public Blog(User user) {
        assert(user != null) : "User is null";

        ownerName = user.getNames();
    }

    public ArrayList<Post> getPosts() {
        if (tagFiltered || authorFiltered) {
            return new ArrayList<>(filteredPosts);
        }
        if (!sortFilter) {
            Collections.sort(posts, (p1, p2) -> p2.getCreatedDateTime().compareTo(p1.getCreatedDateTime()));
        }
        return new ArrayList<>(posts);
    }
    public Post getPost(int postId) {
        return this.posts.get(postId);
    }

    public void sortPosts(SortingMethod sortingType) {
        switch (sortingType) {
            case BY_CREATED_TIME:
                Collections.sort(posts, (p1, p2) -> p1.getCreatedDateTime().compareTo(p2.getCreatedDateTime()));
                break;
            case BY_CREATED_TIME_DESC:
                Collections.sort(posts, (p1, p2) -> p2.getCreatedDateTime().compareTo(p1.getCreatedDateTime()));
                break;
            case BY_MODIFIED_TIME:
                Collections.sort(posts, (p1, p2) -> p1.getModifiedDateTime().compareTo(p2.getModifiedDateTime()));
                break;
            case BY_MODIFIED_TIME_DESC:
                Collections.sort(posts, (p1, p2) -> p2.getModifiedDateTime().compareTo(p1.getModifiedDateTime()));
                break;
            case BY_TITLE:
                Collections.sort(posts, (p1, p2) -> p1.getTitle().compareTo(p2.getTitle()));
                break;
            case OFF:
                sortFilter = false;
                return;
            default:
                assert (false) : "Just 5 sortingType";
                break;
        }
        sortFilter = true;
    }

    public void setTagFilterOn(String tag) {
        filterByTag(tag);
    }
    public void setAuthorFilterOn(String name) {
        filterByAuthor(name);
    }

    public void removeFilter() {
        filteredPosts.clear();
        authorFiltered = false;
        tagFiltered = false;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    private void filterByTag(String tag) {
        assert (tag != null) : "input is null";

        if (this.authorFiltered) {
            for (int i = 0; i < filteredPosts.size(); ++i) {
                Post post = filteredPosts.get(i);
                HashSet<String> tags = post.getTagsOrNull();

                if (!tags.contains(tag)) {
                    filteredPosts.remove(i);
                    --i;
                }
            }
        } else if (this.tagFiltered) {
            for (Post post : posts) {
                HashSet<String> tags = post.getTagsOrNull();

                if (tags.contains(tag) && !(filteredPosts.contains(post))) {
                    filteredPosts.add(post);
                }
            }
        } else {
            for (Post post : posts) {
                HashSet<String> tags = post.getTagsOrNull();

                if (tags.contains(tag)) {
                    filteredPosts.add(post);
                }
            }
        }
        this.tagFiltered = true;
    }
    private void filterByAuthor(String name) {
        assert (name != null) : "input is Null";

        if (this.authorFiltered) {
            filteredPosts.clear();
            return;
        }

        if (this.tagFiltered) {

            for (int i = 0; i < filteredPosts.size(); ++i) {
                Post post = filteredPosts.get(i);
                if (!(post.getAuthor().equals(name))) {
                    filteredPosts.remove(i);
                    --i;
                }
            }
        } else {
            for (Post post : posts) {
                if (post.getAuthor().equals(name)) {
                    filteredPosts.add(post);
                }
            }
        }
        this.authorFiltered = true;
    }
}
