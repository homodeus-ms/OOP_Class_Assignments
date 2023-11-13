package academy.pocu.comp2500.lab9.app;

import academy.pocu.comp2500.lab9.Book;
import academy.pocu.comp2500.lab9.BuyOneGetOneFree;
import academy.pocu.comp2500.lab9.DecadeMadness;
import academy.pocu.comp2500.lab9.SkyIsTheLimit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        Book b0 = new Book(UUID.randomUUID(), "A", 7, 1000);
        Book b1 = new Book(UUID.randomUUID(), "A", 1, 1000);
        Book b2 = new Book(UUID.randomUUID(), "A", 1, 1000);
        Book b3 = new Book(UUID.randomUUID(), "A", 1, 1000);
        Book b4 = new Book(UUID.randomUUID(), "A", 100, 1000);

        ArrayList<Book> books = new ArrayList<>();
        books.add(b0);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);

        SkyIsTheLimit model0 = new SkyIsTheLimit(100);

        System.out.println(model0.getTotalPrice(books));
        SkyIsTheLimit model1 = new SkyIsTheLimit(110);
        System.out.println(model1.getTotalPrice(books));

        System.out.println("No assert");
    }
}