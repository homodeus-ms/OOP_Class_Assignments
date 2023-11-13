package academy.pocu.comp2500.lab9;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class DecadeMadness implements IPriceCalculatable {

    private HashMap<Integer, Integer> decadeMap = new HashMap<>();
    public DecadeMadness() {

    }
    @Override
    public int getTotalPrice(Collection<Book> books) {
        decadeMap.clear();
        double sum = 0;

        for (Book book : books) {
            int decadeValue = getDecadeValue(book.getPublishedYear());

            if (decadeMap.containsKey(decadeValue)) {
                int value = decadeMap.get(decadeValue);
                decadeMap.put(decadeValue, ++value);
            } else {
                decadeMap.put(decadeValue, 1);
            }
        }

        for (Book book : books) {
            if (decadeMap.get(getDecadeValue(book.getPublishedYear())) == 1) {
                sum += book.getPrice();
            } else {
                sum += book.getPrice() * 0.8;
            }
        }

        return (int) sum;
    }

    private int getDecadeValue(int year) {
        return year / 10 * 10;
    }
}
