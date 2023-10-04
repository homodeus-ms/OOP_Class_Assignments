package academy.pocu.comp2500.assignment2;

public enum BusinessCardStock {
    LINEN(ProductType.BUSINESS_CARD_LINEN),
    LAID(ProductType.BUSINESS_CARD_LAID),
    SMOOTH(ProductType.BUSINESS_CARD_SMOOTH);

    private final ProductType productType;

    BusinessCardStock(ProductType type) {
        this.productType = type;
    }
    public ProductType getType() {
        return this.productType;
    }
}
