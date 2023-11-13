package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.Collection;

public class SkyIsTheLimit implements IPriceCalculatable {
    private static final int LIMIT_COUNT = 5;
    private int limitPrice;
    public SkyIsTheLimit(int price) {
        this.limitPrice = price;
    }
    @Override
    public int getTotalPrice(Collection<Book> books) {
        //int mostExpensiveBookIndex = 0;
        //int secondExpensiveBookIndex = 0;
        int mostExpensivePrice = 0;
        int secondExpensivePrice = 0;

        double sum = 0;
        if (books.isEmpty()) {
            return 0;
        }

        ArrayList<Book> booksList = (ArrayList<Book>) books;

        int size = booksList.size();

        for (int i = 0; i < size; ++i) {
            int price = booksList.get(i).getPrice();
            if (price > mostExpensivePrice) {
                mostExpensivePrice = price;
                //mostExpensiveBookIndex = i;
            } else if (price > secondExpensivePrice) {
                secondExpensivePrice = price;
                //secondExpensiveBookIndex = i;
            }
            sum += price;
        }

        if (sum >= limitPrice && books.size() >= LIMIT_COUNT) {
            sum -= (mostExpensivePrice / 2.0 + secondExpensivePrice / 2.0);
        }

        return (int) sum;
    }
}
