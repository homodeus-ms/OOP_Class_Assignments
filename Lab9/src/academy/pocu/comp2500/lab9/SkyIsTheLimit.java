package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class SkyIsTheLimit extends PricingModels {
    private static final int LIMIT_COUNT = 5;
    private final int limitPrice;
    public SkyIsTheLimit(int price) {
        this.limitPrice = price;
    }
    @Override
    public int getTotalPrice(Collection<Book> books) {
        //int mostExpensiveBookIndex = 0;
        //int secondExpensiveBookIndex = 0;
        //int mostExpensivePrice = 0;
        //int secondExpensivePrice = 0;

        double sum = 0;

        if (books.isEmpty()) {
            return 0;
        }

        for (Book b : books) {
            sum += b.getPrice();
        }

        if (sum < limitPrice || books.size() < LIMIT_COUNT) {
            return (int) sum;
        }

        ArrayList<Book> booksList = new ArrayList<>(books);

        int size = booksList.size();

        int mostExpensivePrice = 0;
        int secondExpensivePrice = 0;

        for (int i = 0; i < size; ++i) {

            int price = booksList.get(i).getPrice();

            if (mostExpensivePrice < price) {
                int temp = mostExpensivePrice;
                mostExpensivePrice = price;
                price = temp;
            } 
            if (secondExpensivePrice < price) {
                secondExpensivePrice = price;
            }

            /*if (mostExpensivePrice < price) {
                int temp = mostExpensivePrice;

                mostExpensivePrice = price;

                price = temp;

            }
            if (secondExpensivePrice < price) {
                secondExpensivePrice = price;
            }*/
        }

        sum -= mostExpensivePrice;
        sum -= secondExpensivePrice;

        sum += mostExpensivePrice * 0.5;
        sum += secondExpensivePrice * 0.5;
        /*
        if (sum >= limitPrice && books.size() >= LIMIT_COUNT) {
            sum -= (mostExpensivePrice / 2.0 + secondExpensivePrice / 2.0);
        }*/

        return (int) sum;
    }
}
