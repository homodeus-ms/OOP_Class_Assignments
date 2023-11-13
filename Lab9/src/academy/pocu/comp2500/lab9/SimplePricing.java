package academy.pocu.comp2500.lab9;

import java.util.Collection;

public class SimplePricing implements IPriceCalculatable {
    public SimplePricing() {
    }
    @Override
    public int getTotalPrice(Collection<Book> books) {
        int sum = 0;

        for (Book book : books) {
            sum += book.getPrice();
        }

        return sum;
    }
}
