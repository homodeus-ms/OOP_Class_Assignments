package academy.pocu.comp2500.lab7;

import java.util.Objects;

public final class Book {
    private final String title;
    private final Author author;
    private final int publicationYear;
    private final Genre genre;

    public Book(final String title, final Author author,
                final int publicationYear, final Genre genre) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", title, author.toString());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null || !(obj instanceof Book)) {
            return false;
        }

        Book b = (Book) obj;

        return title.equals(b.title) && author.equals(b.author) &&
                publicationYear == b.publicationYear && genre == b.genre;
    }

    @Override
    public int hashCode() {
        int hash = author.hashCode();
        hash += title.hashCode() + genre.hashCode() * (publicationYear * 13);
        return hash;
    }
}
