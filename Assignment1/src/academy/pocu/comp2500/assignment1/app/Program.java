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
    public static void print2(ArrayList<Comment> comments) {

        for (Comment comment : comments) {
            System.out.printf("%s %s\n", comment.getAuthor().getUserName(), comment.getComment());

        }
        System.out.println();
    }
    public static void print3(ArrayList<Comment> subComments) {

        for (Comment comment : subComments) {
            System.out.printf("%s %s\n", comment.getAuthor().getUserName(), comment.getComment());

        }
        System.out.println();
    }

    public static void main(String[] args) {

	    Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        User pope = new User("Pope", "aaaa");
        User kiwi = new User("Kiwi", "bbbb");
        User pope2 = new User("Pope", "aaaa");
        User pope3 = new User("PPpe", "aaaa");


        Blog blog = new Blog();

        Post post0 = new Post(pope, "aaa", "111");
        Post post1 = new Post(pope, "bbb", "222");
        Post post2 = new Post(kiwi, "ccc", "333");
        Post post3 = new Post(kiwi, "ddd", "444");

        blog.addPost(post0);
        blog.addPost(post1);
        blog.addPost(post2);
        blog.addPost(post3);

        post0.addTag("t1");
        post0.addTag("t2");
        post1.addTag("t2");
        post1.addTag("t1");
        post2.addTag("t1");
        post3.addTag("t2");

        blog.setTagFilter("t1");
        ArrayList<String> tags = new ArrayList<>();
        tags.add("t1");
        tags.add("t2");


        blog.setAuthorFilter(null);

        //var list = blog.getPosts();

        blog.setTagFilter("t2");

        var list = blog.getPosts();

        print1(list);


        System.out.println("??");

    }
}
