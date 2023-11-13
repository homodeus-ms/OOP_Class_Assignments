package academy.pocu.comp2500.lab9;

import java.util.Collection;

public abstract class PricingModels {

    protected int bookCount;
    protected int duplicatedBookCount;
    protected int sum;

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
}
