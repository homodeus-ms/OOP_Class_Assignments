package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Banner extends Product {

    private PrintOrientation orientation;
    private ArrayList<String> addedTexts;
    private ArrayList<String> addedImagePaths;

    public Banner(BannerType type, BannerSize size, int color, int price, PrintOrientation orientation) {
        super(getProductType(type), new RGB(color), getWidth(size), getHeight(size), price);
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
