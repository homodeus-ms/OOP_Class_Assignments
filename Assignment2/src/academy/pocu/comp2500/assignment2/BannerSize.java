package academy.pocu.comp2500.assignment2;

public enum BannerSize {
    TINY(ProductSize.BANNER_1xHALF),
    SMALL(ProductSize.BANNER_1x1),
    MEDIUM(ProductSize.BANNER_2xHALF),
    LARGE(ProductSize.BANNER_3x1);

    private final ProductSize size;

    BannerSize(ProductSize size) {
        this.size = size;
    }

    public ProductSize getSize() {
        return this.size;
    }
}
