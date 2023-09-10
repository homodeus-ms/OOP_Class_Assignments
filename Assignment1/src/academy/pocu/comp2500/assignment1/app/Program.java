package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.App;
import academy.pocu.comp2500.assignment1.Blog;
import academy.pocu.comp2500.assignment1.Post;
import academy.pocu.comp2500.assignment1.User;
import academy.pocu.comp2500.assignment1.registry.Registry;

import java.util.HashSet;


public class Program {

    public static void main(String[] args) {

	    Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();



        System.out.println("??");

    }
}
