package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public final class ReadingList {

    private final String name;
    private final ArrayList<Book> books = new ArrayList<>();

    public ReadingList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public boolean add(Book book) {
        return books.add(book);
    }
    public boolean remove(Book book) {
        for (Book b : books) {
            if (b.equals(book)) {
                books.remove(b);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (Book b : books) {
            builder.append(count++);
            builder.append(". ");
            builder.append(b.toString());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReadingList)) {
            return false;
        }

        ReadingList l = (ReadingList) obj;

        if (!name.equals(l.name)) {
            return false;
        }

        int size = books.size();

        for (int i = 0; i < size; ++i) {
            if (!books.get(i).equals(l.books.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int sum = 0;
        int size = books.size();
        for (int i = 0; i < size; ++i) {
            sum += books.get(i).hashCode() * i;
        }
        sum += name.hashCode();

        return sum;
    }
}
