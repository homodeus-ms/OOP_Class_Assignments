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

        User user0 = new User("Pope");
        User user1 = new User("Pope");

        Blog blog0 = new Blog();
        Blog blog1 = new Blog();
        Post post0 = new Post(user0, "aaa", "111");
        Post post1 = new Post(user0, "bbb", "222");
        Post post2 = new Post(user0, "aaa", "333");
        blog0.addPost(post0);
        blog0.addPost(post1);

        var list = blog0.getPosts();


        print1(list);
        //post.updateTitle(post, user0, "War");
        /*
        Post post0 = new Post(user0, "aaa", "aaa-1");
        Post post1 = new Post(user1, "bbb", "bbb-1");
        blog0.addPost(post0);
        blog0.addPost(post1);

        var posts = blog0.getPosts();
        print1(posts);

        Comment com0 = new Comment(user0, "aaa-2");
        post0.addComment(com0);

        Comment subCom0 = new Comment(user0, "aaa-3");
        com0.addSubComment(com0, subCom0);

        var comments = blog0.getPosts().get(1).getComments();

        print2(comments);

        var subComments = com0.getSubComments();

        print2(subComments);

        */


        System.out.println("??");

    }
}
