package academy.pocu.comp2500.assignment2;

public enum BannerSize {
    TINY_1XHALF(ProductSize.BANNER_1XHALF),
    SMALL_1X1(ProductSize.BANNER_1X1),
    MEDIUM_2XHALF(ProductSize.BANNER_2XHALF),
    LARGE_3X1(ProductSize.BANNER_3X1);

    private final ProductSize size;

    BannerSize(ProductSize size) {
        this.size = size;
    }

    public ProductSize getSize() {
        return this.size;
    }
}
