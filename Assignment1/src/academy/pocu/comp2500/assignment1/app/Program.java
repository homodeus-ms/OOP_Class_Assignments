package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.*;
import academy.pocu.comp2500.assignment1.registry.Registry;

import java.util.ArrayList;
import java.util.HashSet;


public class Program {

    public static void print1(ArrayList<Post> posts) {

        for (Post post : posts) {
            System.out.printf("%s %s %s %s %s\n", post.getAuthor().getUserName(), post.getTitle(),
                    post.getBody(), post.getCreatedDateTime(), post.getModifiedDateTime());
        }
        System.out.println();
    }

    public static void main(String[] args) {

	    Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        User user0 = new User("Pope");
        User user1 = new User("Pope");

        Blog blog0 = new Blog();

        Post post0 = new Post(user0, "aaa", "aaa-1");
        Post post1 = new Post(user1, "bbb", "bbb-1");
        blog0.addPost(post0);
        blog0.addPost(post1);

        var posts = blog0.getPosts();
        print1(posts);

        blog0.setSortType(SortingType.BY_TITLE);
        posts = blog0.getPosts();

        print1(posts);

        posts.get(0).updateTitle(user1, "aaaaaaaaa");

        posts = blog0.getPosts();
        print1(posts);



        System.out.println("??");

    }
}
