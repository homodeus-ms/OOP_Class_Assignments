package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.App;
import academy.pocu.comp2500.assignment1.Blog;
import academy.pocu.comp2500.assignment1.User;
import academy.pocu.comp2500.assignment1.registry.Registry;



public class Program {

    public static void main(String[] args) {

	    Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        User user0 = new User("smith");
        Blog blog0 = new Blog();


        System.out.println("??");

    }
}
