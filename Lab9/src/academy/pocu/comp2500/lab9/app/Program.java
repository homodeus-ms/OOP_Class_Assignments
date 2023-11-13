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


        Book b0 = new Book(UUID.randomUUID(), "A", 1, 1000);
        Book b1 = new Book(UUID.randomUUID(), "A", 0, 1000);
        Book b2 = new Book(UUID.randomUUID(), "A", 0, 1000);
        Book b3 = new Book(UUID.randomUUID(), "A", 0, 1000);
        Book b4 = new Book(UUID.randomUUID(), "A", 0, 1000);
        /*Book b5 = new Book(UUID.randomUUID(), "A", 10, 1000);
        Book b6 = new Book(UUID.randomUUID(), "A", 10, 1000);
        Book b7 = new Book(UUID.randomUUID(), "A", 10, 1000);
        Book b8 = new Book(UUID.randomUUID(), "A", 10, 1000);
        Book b9 = new Book(UUID.randomUUID(), "A", 11, 1000);*/

        ArrayList<Book> books = new ArrayList<>();
        books.add(b0);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        /*books.add(b5);
        books.add(b6);
        books.add(b7);
        books.add(b8);
        books.add(b9);*/

        SkyIsTheLimit model0 = new SkyIsTheLimit(5);

        System.out.println(model0.getTotalPrice(books));



        /*UUID sku0 = UUID.randomUUID();

        Book book0 = new Book(sku0, "Hello", 10, 1980);
        Book book1 = new Book(sku0, "Hello", 10, 1980);
        Book book2 = new Book(sku0, "Hello", 10, 1980);
        Book book3 = new Book(sku0, "Hello", 10, 1980);
        Book book4 = new Book(sku0, "Hello", 10, 1980);
        Book book5 = new Book(UUID.randomUUID(), "Millenium", 15, 2001);
        Book book6 = new Book(UUID.randomUUID(), "Halfway Millenium", 21, 2005);
        Book book7 = new Book(UUID.randomUUID(), "Decade almost over", 17, 2009);
        Book book8 = new Book(UUID.randomUUID(), "FIFA", 17, 2002);
        Book book9 = new Book(UUID.randomUUID(), "University", 5, 2008);

        ArrayList<Book> books = new ArrayList<>();

        books.add(book0);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);

        HashSet<UUID> skus = new HashSet<>();
        skus.add(sku0);

        BuyOneGetOneFree model0 = new BuyOneGetOneFree(skus);
        DecadeMadness model1 = new DecadeMadness();
        SkyIsTheLimit model2 = new SkyIsTheLimit(100);

        assert (model0.getTotalPrice(books) == 105);
        assert (model1.getTotalPrice(books) == 100);
        assert (model2.getTotalPrice(books) == 106);*/

        System.out.println("No assert");
    }
}