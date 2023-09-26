package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    //private static final int PRICE_4X3 = 2300;
    //private static final int PRICE_5X2 = 2300;
    //private static final int PRICE_7X4 = 2600;

    public Stamp(StampType type) {
        super(ProductType.STAMP, type.getColor(), type.getWidthInMilli(), type.getHeightInMilli(), type.getPrice());
    }
}
