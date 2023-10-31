package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public final class Bookshelf {

    private final int maxCapacity;
    private final Book[] books;
    private int bookCount;

    public Bookshelf(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        books = new Book[maxCapacity];
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public Book[] getBooks() {
        return books;
    }

    public boolean add(Book book) {
        if (bookCount == maxCapacity) {
            return false;
        }
        books[bookCount++] = book;

        return true;
    }
    public boolean remove(Book book) {
        if (bookCount == 0) {
            return false;
        }

        for (int i = 0; i < bookCount; ++i) {
            if (books[i].equals(book)) {
                books[i] = books[bookCount - 1];
                books[--bookCount] = null;

                return true;
            }
        }

        return false;
    }

}
