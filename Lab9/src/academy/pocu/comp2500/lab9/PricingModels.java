package academy.pocu.comp2500.lab9;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public abstract class PricingModels {

    protected int bookCount;
    protected int duplicatedBookCount;
    protected int sum;
    protected HashMap<Integer, Integer> decadeMap;

    // default simple pricing
    public int getTotalPrice(Collection<Book> books) {
        int sum = 0;
        for (Book book : books) {
            ++bookCount;
            sum += book.getPrice();
        }

        return sum;
    }

    public int getBookCount() {
        return this.bookCount;
    }

    protected void findDuplicatedDecadeBooks(Collection<Book> books) {
        for (Book book : books) {
            int decadeValue = getDecadeValue(book.getPublishedYear());

            if (decadeMap.containsKey(decadeValue)) {
                int value = decadeMap.get(decadeValue);
                decadeMap.put(decadeValue, ++value);
            } else {
                decadeMap.put(decadeValue, 1);
            }
        }
    }
    protected int getDecadeValue(int year) {
        return year / 10 * 10;
    }
}
