package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Blog {
    private final ArrayList<Post> posts;
    private final ArrayList<Post> filteredPosts;

    private boolean tagFiltered;
    private boolean authorFiltered;
    private boolean sortFilter;

    public Blog(User user) {
        posts = new ArrayList<>();
        filteredPosts = new ArrayList<>();
    }

    public ArrayList<Post> getPosts() {
        if (tagFiltered || authorFiltered) {
            return new ArrayList<>(filteredPosts);
        }
        if (!sortFilter) {
            posts.sort(byCreatedTimeDesc);
        }
        return new ArrayList<>(posts);
    }
    public Post getPost(int postId) {
        return this.posts.get(postId);
    }


    Comparator<Post> byCreatedTimeDesc = new Comparator<Post>() {
        @Override
        public int compare(Post a1, Post a2) {
            return a2.getCreatedDateTime().compareTo(a1.getCreatedDateTime());
        }
    };
    Comparator<Post> byCreatedTime = new Comparator<Post>() {
        @Override
        public int compare(Post a1, Post a2) {
            return a1.getCreatedDateTime().compareTo(a2.getCreatedDateTime());
        }
    };
    Comparator<Post> byModifiedTimeDesc = new Comparator<Post>() {
        @Override
        public int compare(Post a1, Post a2) {
            return a2.getModifiedDateTime().compareTo(a1.getModifiedDateTime());
        }
    };
    Comparator<Post> byModifiedTime = new Comparator<Post>() {
        @Override
        public int compare(Post a1, Post a2) {
            return a1.getModifiedDateTime().compareTo(a2.getModifiedDateTime());
        }
    };
    Comparator<Post> byTitle = new Comparator<Post>() {
        @Override
        public int compare(Post a1, Post a2) {
            return a1.getTitle().compareTo(a2.getTitle());
        }
    };

    public void sortPosts(SortingMethod sortingType) {
        switch (sortingType) {
            case BY_CREATED_TIME:
                posts.sort(byCreatedTime);
                break;
            case BY_CREATED_TIME_DESC:
                posts.sort(byCreatedTimeDesc);
                break;
            case BY_MODIFIED_TIME:
                posts.sort(byModifiedTime);
                break;
            case BY_MODIFIED_TIME_DESC:
                posts.sort(byModifiedTimeDesc);
                break;
            case BY_TITLE:
                posts.sort(byTitle);
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
    /*
    public void addPost(String authorName, String title, String body) {
        Post newPost = new Post(authorName, title, body);
        posts.add(0, newPost);
    }
    */
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
