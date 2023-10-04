package academy.pocu.comp2500.assignment2;

public enum BannerType {
    GLOSS(ProductType.BANNER_GLOSS),
    SCRIM(ProductType.BANNER_SCRIM),
    MESH(ProductType.BANNER_MESH);

    private final ProductType productType;

    BannerType(ProductType type) {
        this.productType = type;
    }
    public ProductType getType() {
        return this.productType;
    }
}
