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
            System.out.printf("%s %s\n", comment.getAuthor(), comment.getComment());

        }
        System.out.println();
    }

    public static void main(String[] args) {

	    Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        int[] reactions = new int[5];

        Reactions react1 = Reactions.SAD;

        



        System.out.println("??");

    }
}
