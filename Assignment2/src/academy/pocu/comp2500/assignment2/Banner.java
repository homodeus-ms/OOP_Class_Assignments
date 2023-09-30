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


    public Banner(ProductType type, ProductSize size, RGB color, PrintOrientation orientation) {
        super(type, color, size, getPrice(type, size));
        this.orientation = orientation;
        this.textApertures = new ArrayList<>();
        this.imageApertures = new ArrayList<>();
    }

    public PrintOrientation getOrientation() {
        return orientation;
    }

    public ArrayList<TextAperture> getTextApertures() {
        return textApertures;
    }

    public void addText(TextAperture aperture) {
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

    public void addImagePath(ImageAperture aperture) {
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


    private static int getPrice(ProductType type, ProductSize size) {
        switch (type) {
            case BANNER_GLOSS:
                switch (size) {
                    case BANNER_1XHALF:
                        return GLOSS_1XHALF_PRICE;
                    case BANNER_1X1:
                        return GLOSS_1X1_PRICE;
                    case BANNER_2XHALF:
                        return GLOSS_2XHALF_PRICE;
                    case BANNER_3X1:
                        return GLOSS_3X1_PRICE;
                    default:
                        assert (false);
                        return -1;
                }
            case BANNER_SCRIM:
                // intentional fall through
            case BANNER_MESH:
                switch (size) {
                    case BANNER_1XHALF:
                        return OTHER_1XHALF_PRICE;
                    case BANNER_1X1:
                        return OTHER_1X1_PRICE;
                    case BANNER_2XHALF:
                        return OTHER_2XHALF_PRICE;
                    case BANNER_3X1:
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
