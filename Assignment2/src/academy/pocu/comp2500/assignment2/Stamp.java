package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {

    private static final int STAMP_4X3_PRICE = 2300;
    private static final int STAMP_5X2_PRICE = 2300;
    private static final int STAMP_7X4_PRICE = 2600;

    public enum StampSize {
        STAMP_4X3(ProductType.STAMP_4X3),
        STAMP_5X2(ProductType.STAMP_5X2),
        STAMP_7X4(ProductType.STAMP_7X4);

        private final ProductType productType;

        StampSize(ProductType type) {
            this.productType = type;
        }
        public ProductType getProductType() {
            return this.productType;
        }
    }

    private final StampSize stampSize;

    protected Stamp(StampSize size, Color color) {
        super(size.getProductType(), color, getPrice(size));
        this.stampSize = size;
    }

    public StampSize getStampSize() {
        return stampSize;
    }

    private static int getPrice(StampSize size) {
        switch (size) {
            case STAMP_4X3:
                return STAMP_4X3_PRICE;
            case STAMP_5X2:
                return STAMP_5X2_PRICE;
            case STAMP_7X4:
                return STAMP_7X4_PRICE;
            default:
                assert (false);
                return -1;
        }
    }
}
