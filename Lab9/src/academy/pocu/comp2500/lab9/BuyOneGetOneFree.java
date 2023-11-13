package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class BuyOneGetOneFree implements IPriceCalculatable {

    private HashSet<UUID> skus;
    private int duplicateCount;
    private boolean[] isBargainBook;


    public BuyOneGetOneFree(HashSet<UUID> skus) {
        this.skus = skus;
        isBargainBook = new boolean[skus.size()];
    }
    @Override
    public int getTotalPrice(Collection<Book> books) {
        int sum = 0;
        Object[] skusArr = skus.toArray();
        int skusSize = skusArr.length;

        nextBook:
        for (Book book : books) {
            for (int i = 0; i < skusSize; ++i) {
                if (book.getSku().equals(skusArr[i])) {
                    if (!isBargainBook[i]) {
                        isBargainBook[i] = true;
                        sum += book.getPrice();
                        continue nextBook;
                    } else {
                        isBargainBook[i] = false;
                        continue nextBook;
                    }
                }
            }
            sum += book.getPrice();
        }
        return sum;
    }
}
