package academy.pocu.comp2500.lab7;

public final class Bundle {

    private final String name;
    private final int MAX_CAPACITY = 4;
    private final Book[] books = new Book[4];
    private int bookCount;

    public Bundle (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Book[] getBooks() {
        return books;
    }

    public boolean add(Book book) {
        if (bookCount == MAX_CAPACITY) {
            return false;
        }
        for (int i = 0; i < bookCount; ++i) {
            if (books[i].equals(book)) {
                return false;
            }
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
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Bundle)) {
            return false;
        }

        return this.hashCode() == ((Bundle) obj).hashCode();
    }
    @Override
    public int hashCode() {
        int sum = 0;
        for (int i = 0; i < bookCount; ++i) {
            sum += books[i].hashCode();
        }
        sum += name.hashCode();
        return sum;
    }
}
