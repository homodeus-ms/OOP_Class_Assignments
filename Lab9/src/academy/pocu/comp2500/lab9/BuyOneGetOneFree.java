package academy.pocu.comp2500.lab9;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class BuyOneGetOneFree extends PricingModels {

    private HashSet<UUID> skus;
    private boolean[] isBargainBook;

    private HashMap<UUID, Integer> skuDuplicates = new HashMap<>();


    public BuyOneGetOneFree(HashSet<UUID> skus) {
        this.skus = skus;
        //isBargainBook = new boolean[skus.size()];

    }
    @Override
    public int getTotalPrice(Collection<Book> books) {
        int sum = 0;

        skuDuplicates.clear();
        for (UUID sku : skus) {
            skuDuplicates.put(sku, 0);
        }

        for (Book b : books) {

            sum += b.getPrice();

            UUID key = b.getSku();
            if (skuDuplicates.containsKey(key)) {
                int value = skuDuplicates.get(key);
                skuDuplicates.put(key, ++value);
            }
        }

        int checkedCount;
        int duplicatedCount;
        int price;

        for (UUID sku : skuDuplicates.keySet()) {
            checkedCount = skuDuplicates.get(sku);
            if (checkedCount > 1) {
                price = getPriceBySku(sku, books);
                duplicatedCount = checkedCount / 2;
                duplicatedBookCount += duplicatedCount;
                sum -= price * duplicatedCount;
            }
        }

        return sum;
    }

    public int getPriceBySku(UUID sku, Collection<Book> books) {
        for (Book b : books) {
            if (b.getSku().equals(sku)) {
                return b.getPrice();
            }
        }
        assert (false);
        return -1;
    }
}
