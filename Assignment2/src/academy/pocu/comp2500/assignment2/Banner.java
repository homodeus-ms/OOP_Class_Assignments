package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Banner extends Product {

    private static final int GLOSS_TINY_PRICE = 5000;
    private static final int GLOSS_SMALL_PRICE = 5200;
    private static final int GLOSS_MEDIUM_PRICE = 5300;
    private static final int GLOSS_LARGE_PRICE = 6000;
    private static final int OTHER_TINY_PRICE = 5100;
    private static final int OTHER_SMALL_PRICE = 5300;
    private static final int OTHER_MEDIUM_PRICE = 5400;
    private static final int OTHER_LARGE_PRICE = 6100;

    private final PrintOrientation orientation;
    private final ArrayList<TextAperture> textApertures;
    private final ArrayList<ImageAperture> imageApertures;


    public Banner(BannerType type, BannerSize size, RGB color, PrintOrientation orientation) {
        super(getProductType(type), color, getWidth(size), getHeight(size), getPrice(type, size));
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

    private static ProductType getProductType(BannerType type) {
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
    }

    private static int getPrice(BannerType type, BannerSize size) {
        switch (type) {
            case GLOSS:
                switch (size) {
                    case TINY:
                        return GLOSS_TINY_PRICE;
                    case SMALL:
                        return GLOSS_SMALL_PRICE;
                    case MEDIUM:
                        return GLOSS_MEDIUM_PRICE;
                    case LARGE:
                        return GLOSS_LARGE_PRICE;
                    default:
                        assert (false);
                        return -1;
                }
            case SCRIM:
                // intentional fall through
            case MESH:
                switch (size) {
                    case TINY:
                        return OTHER_TINY_PRICE;
                    case SMALL:
                        return OTHER_SMALL_PRICE;
                    case MEDIUM:
                        return OTHER_MEDIUM_PRICE;
                    case LARGE:
                        return OTHER_LARGE_PRICE;
                    default:
                        assert (false);
                        return -1;
                }
            default:
                assert (false);
                return -1;
        }
    }

    private static int getWidth(BannerSize size) {
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
    }

    /*private boolean isApertureValid(Aperture aperture) {

        assert (aperture.getApertureWidth() > 0 && aperture.getApertureHeight() > 0);

        int bannerWidth = super.getWidthInMilli();
        int bannerHeight = super.getHeightInMilli();
        int landscapeSize = aperture.getX() + aperture.getApertureWidth();
        int horizontalSize = aperture.getY() + aperture.getApertureHeight();

        if (aperture.getX() > 0 && aperture.getX() < bannerWidth &&
                aperture.getY() > 0 && aperture.getY() < bannerHeight) {
            return true;
        } else if (landscapeSize > 0 && horizontalSize > 0 &&
                landscapeSize <= bannerWidth && horizontalSize <= bannerHeight) {
            return true;
        }
        return false;
    }*/
}
