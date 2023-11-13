package academy.pocu.comp2500.lab9;

import java.util.Collection;

public interface IPriceCalculatable {
    int getTotalPrice(Collection<Book> books);
}
