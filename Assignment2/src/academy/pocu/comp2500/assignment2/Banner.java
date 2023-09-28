package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Banner extends Product {

    private PrintOrientation orientation;
    private ArrayList<String> addedTexts;
    private ArrayList<String> addedImagePaths;

    private static final int GLOSS_TINY_PRICE = 5000;
    private static final int GLOSS_SMALL_PRICE = 5200;
    private static final int GLOSS_MEDIUM_PRICE = 5300;
    private static final int GLOSS_LARGE_PRICE = 6000;
    private static final int OTHER_TINY_PRICE = 5100;
    private static final int OTHER_SMALL_PRICE = 5300;
    private static final int OTHER_MEDIUM_PRICE = 5400;
    private static final int OTHER_LARGE_PRICE = 6100;


    public Banner(BannerType type, BannerSize size, RGB color, PrintOrientation orientation) {
        super(getProductType(type), color, getWidth(size), getHeight(size), getPrice(type, size));
        this.orientation = orientation;
        this.addedTexts = new ArrayList<>();
        this.addedImagePaths = new ArrayList<>();
    }

    public PrintOrientation getOrientation() {
        return orientation;
    }

    public ArrayList<String> getAddedTexts() {
        return addedTexts;
    }

    public void addText(String text) {
        this.addedTexts.add(text);
    }

    public ArrayList<String> getAddedImagePaths() {
        return addedImagePaths;
    }

    public void addImagePath(String imagePath) {
        this.addedImagePaths.add(imagePath);
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
}
