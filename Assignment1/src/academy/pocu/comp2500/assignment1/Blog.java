package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Blog {
    private final ArrayList<Post> posts;
    private final ArrayList<Post> filteredPosts;
    private User owner;

    private boolean tagFiltered;
    private boolean authorFiltered;
    private boolean sortFilter;

    public Blog(User user) {
        this.owner = user;
        posts = new ArrayList<>();
        filteredPosts = new ArrayList<>();
    }

    public ArrayList<Post> getPosts() {
        if (tagFiltered || authorFiltered) {
            return new ArrayList<>(filteredPosts);
        }
        if (!sortFilter) {
            posts.sort(new CreatedTimeByDescComparator());
        }
        return new ArrayList<>(posts);
    }
    public Post getPost(int postId) {
        return this.posts.get(postId);
    }


    public class CreatedTimeByDescComparator implements Comparator<Post> {
        @Override
        public int compare(Post a1, Post a2) {
            return a2.getCreatedDateTime().compareTo(a1.getCreatedDateTime());
        }
    }
    public class CreatedTimeComparator implements Comparator<Post> {
        @Override
        public int compare(Post a1, Post a2) {
            return a1.getCreatedDateTime().compareTo(a2.getCreatedDateTime());
        }
    };
    public class ModifiedTimeByDescComparator implements Comparator<Post> {
        @Override
        public int compare(Post a1, Post a2) {
            return a2.getModifiedDateTime().compareTo(a1.getModifiedDateTime());
        }
    };
    public class ModifiedTimeComparator implements Comparator<Post> {
        @Override
        public int compare(Post a1, Post a2) {
            return a1.getModifiedDateTime().compareTo(a2.getModifiedDateTime());
        }
    };
    public class TitleComparator implements Comparator<Post> {
        @Override
        public int compare(Post a1, Post a2) {
            return a1.getTitle().compareTo(a2.getTitle());
        }
    };
    /*
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
    */

    public void sortPosts(SortingMethod sortingType) {
        switch (sortingType) {
            case BY_CREATED_TIME:
                posts.sort(new CreatedTimeComparator());
                break;
            case BY_CREATED_TIME_DESC:
                posts.sort(new CreatedTimeByDescComparator());
                break;
            case BY_MODIFIED_TIME:
                posts.sort(new ModifiedTimeComparator());
                break;
            case BY_MODIFIED_TIME_DESC:
                posts.sort(new ModifiedTimeByDescComparator());
                break;
            case BY_TITLE:
                posts.sort(new TitleComparator());
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
