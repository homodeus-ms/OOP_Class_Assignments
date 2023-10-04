package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Banner extends Product {

    private static final int GLOSS_1XHALF_PRICE = 5000;
    private static final int GLOSS_1X1_PRICE = 5200;
    private static final int GLOSS_2XHALF_PRICE = 5300;
    private static final int GLOSS_3X1_PRICE = 6000;
    private static final int OTHER_1XHALF_PRICE = 5100;
    private static final int OTHER_1X1_PRICE = 5300;
    private static final int OTHER_2XHALF_PRICE = 5400;
    private static final int OTHER_3X1_PRICE = 6100;

    private final PrintOrientation orientation;

    private final ArrayList<TextAperture> textApertures;
    private final ArrayList<ImageAperture> imageApertures;
    private final BannerType bannerType;
    private final BannerSize bannerSize;

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

    public enum BannerSize {
        TINY(ProductSize.BANNER_1XHALF),
        SMALL(ProductSize.BANNER_1X1),
        MEDIUM(ProductSize.BANNER_2XHALF),
        LARGE(ProductSize.BANNER_3X1);

        private final ProductSize size;

        BannerSize(ProductSize size) {
            this.size = size;
        }

        public ProductSize getSize() {
            return this.size;
        }
    }


    public Banner(BannerType type, BannerSize size, RGB color, PrintOrientation orientation) {
        super(type.getType(), color, size.getSize(), getPrice(type, size));
        this.orientation = orientation;
        this.bannerType = type;
        this.bannerSize = size;

        this.textApertures = new ArrayList<>();
        this.imageApertures = new ArrayList<>();

    }

    public BannerType getBannerType() {
        return bannerType;
    }
    public BannerSize getBannerSize() {
        return bannerSize;
    }


    public PrintOrientation getOrientation() {
        return orientation;
    }


    public ArrayList<TextAperture> getTextApertures() {
        return textApertures;
    }

    public void addTextAperture(TextAperture aperture) {
        if (aperture.getElement() == null) {
            return;
        }
        if (aperture.isValid(this)) {
            textApertures.add(aperture);
            price += 5;
        }
    }

    public ArrayList<ImageAperture> getImageApertures() {
        return imageApertures;
    }

    public void addImageAperture(ImageAperture aperture) {
        if (aperture.getElement() == null) {
            return;
        }
        if (aperture.isValid(this)) {
            imageApertures.add(aperture);
            price += 5;
        }
    }


    private static int getPrice(BannerType type, BannerSize size) {
        switch (type) {
            case GLOSS:
                switch (size) {
                    case TINY:
                        return GLOSS_1XHALF_PRICE;
                    case SMALL:
                        return GLOSS_1X1_PRICE;
                    case MEDIUM:
                        return GLOSS_2XHALF_PRICE;
                    case LARGE:
                        return GLOSS_3X1_PRICE;
                    default:
                        assert (false);
                        return -1;
                }
            case SCRIM:
                // intentional fall through
            case MESH:
                switch (size) {
                    case TINY:
                        return OTHER_1XHALF_PRICE;
                    case SMALL:
                        return OTHER_1X1_PRICE;
                    case MEDIUM:
                        return OTHER_2XHALF_PRICE;
                    case LARGE:
                        return OTHER_3X1_PRICE;
                    default:
                        assert (false);
                        return -1;
                }
            default:
                assert (false);
                return -1;
        }
    }
}
