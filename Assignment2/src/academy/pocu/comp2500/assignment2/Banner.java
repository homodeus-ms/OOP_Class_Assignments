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
    private final RGB bannerColor;
    //private final RGB color;

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
        this.bannerColor = color;

        this.textApertures = new ArrayList<>();
        this.imageApertures = new ArrayList<>();

    }
    public RGB getBannerColor() {
        return this.bannerColor;
    }
    public BannerType getBannerType() {
        return bannerType;
    }
    public BannerSize getBannerSize() {
        return bannerSize;
    }
    public RGB getColor() {
        return this.bannerColor;
    }

    public PrintOrientation getOrientation() {
        return orientation;
    }


    public ArrayList<TextAperture> getTextApertures() {
        return textApertures;
    }

    public void addTextAperture(TextAperture aperture) {
        if (aperture.getText() == null) {
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
        if (aperture.getImagePath() == null) {
            return;
        }
        if (aperture.isValid(this)) {
            imageApertures.add(aperture);
            price += 5;
        }
    }

    /*private static ProductType getProductType(BannerType type) {
        switch (type) {
            case GLOSS:
                return ProductType.BANNER_GLOSS;
            case SCRIM:
                return ProductType.BANNER_SCRIM;
            case MESH:
                return ProductType.BANNER_MESH;
            default:
                assert (false);
                return ProductType.DEFAULT;
        }
    }*/


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

    /*private static int getWidth(BannerSize size) {
        int width = 0;

        switch (size) {
            case TINY:
                // intentional fall through
            case SMALL:
                width = 1000;
                break;
            case MEDIUM:
                width = 2000;
                break;
            case LARGE:
                width = 3000;
                break;
            default:
                assert (false);
                break;
        }
        return width;
    }
    private static int getHeight(BannerSize size) {
        int height = 0;

        switch (size) {
            case TINY:
                height = 500;
                break;
            case SMALL:
                height = 1000;
                break;
            case MEDIUM:
                height = 500;
                break;
            case LARGE:
                height = 1000;
                break;
            default:
                assert (false);
                break;
        }
        return height;
    }*/

}
