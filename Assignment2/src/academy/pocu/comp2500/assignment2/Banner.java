package academy.pocu.comp2500.assignment2;


public class Banner extends BannerAndCard {

    private static final int GLOSS_1XHALF_PRICE = 5000;
    private static final int GLOSS_1X1_PRICE = 5200;
    private static final int GLOSS_2XHALF_PRICE = 5300;
    private static final int GLOSS_3X1_PRICE = 6000;
    private static final int OTHER_1XHALF_PRICE = 5100;
    private static final int OTHER_1X1_PRICE = 5300;
    private static final int OTHER_2XHALF_PRICE = 5400;
    private static final int OTHER_3X1_PRICE = 6100;

    public enum BannerType {
        GLOSS,
        SCRIM,
        MESH,
    }
    public enum BannerSize {
        BANNER_1XHALF(ProductType.BANNER_1XHALF),
        BANNER_1X1(ProductType.BANNER_1X1),
        BANNER_2XHALF(ProductType.BANNER_2XHALF),
        BANNER_3X1(ProductType.BANNER_3X1);

        private final ProductType productType;
        BannerSize(ProductType type) {
            this.productType = type;
        }
        public ProductType getProductType() {
            return this.productType;
        }
    }

    private final BannerType bannerType;
    private final BannerSize bannerSize;

    public Banner(BannerType type, BannerSize size, Color color, PrintOrientation orientation) {
        super(size.getProductType(), color, getPrice(type, size), orientation);
        this.bannerType = type;
        this.bannerSize = size;
    }

    public BannerType getBannerType() {
        return bannerType;
    }

    public BannerSize getBannerSize() {
        return bannerSize;
    }

    private static int getPrice(BannerType type, BannerSize size) {
        switch (type) {
            case GLOSS:
                switch (size) {
                    case BANNER_1XHALF:
                        return GLOSS_1XHALF_PRICE;
                    case BANNER_1X1:
                        return GLOSS_1X1_PRICE;
                    case BANNER_2XHALF:
                        return GLOSS_2XHALF_PRICE;
                    case BANNER_3X1:
                        return GLOSS_3X1_PRICE;
                }
            case SCRIM:
                // Intentional Fall Through
            case MESH:
                switch (size) {
                    case BANNER_1XHALF:
                        return OTHER_1XHALF_PRICE;
                    case BANNER_1X1:
                        return OTHER_1X1_PRICE;
                    case BANNER_2XHALF:
                        return OTHER_2XHALF_PRICE;
                    case BANNER_3X1:
                        return OTHER_3X1_PRICE;
                }
            default:
                assert (false);
                return -1;
        }
    }
}
