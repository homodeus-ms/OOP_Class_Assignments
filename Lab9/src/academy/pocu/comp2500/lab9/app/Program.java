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
        UUID sku0 = UUID.randomUUID();
        UUID sku1 = UUID.randomUUID();
        Book b0 = new Book(sku0, "a", 10, 1000);
        Book b1 = new Book(sku0, "a", 10, 1000);
        Book b2 = new Book(sku0, "a", 10, 1000);
        Book b3 = new Book(sku1, "a", 20, 1000);
        Book b4 = new Book(sku1, "a", 20, 1000);

        ArrayList<Book> books = new ArrayList<>();

        books.add(b0);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);


        HashSet<UUID> skus = new HashSet<>();
        skus.add(sku0);
        skus.add(sku1);

        BuyOneGetOneFree model0 = new BuyOneGetOneFree(skus);
        System.out.println(model0.getTotalPrice(books));

        skus.clear();
        skus.add(sku0);
        System.out.println(model0.getTotalPrice(books));

        skus.clear();
        skus.add(sku1);
        System.out.println(model0.getTotalPrice(books));

        System.out.println("No assert");
    }
}