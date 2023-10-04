package academy.pocu.comp2500.assignment2;

public enum StampSize {
    STAMP_4X3(ProductSize.STAMP_4X3, 2300),
    STAMP_5X2(ProductSize.STAMP_5X2, 2300),
    STAMP_7X4(ProductSize.STAMP_7X4, 2600);

    private final ProductSize size;
    private final int price;

    StampSize(ProductSize size, int price) {
        this.size = size;
        this.price = price;
    }

    public ProductSize getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }
}
