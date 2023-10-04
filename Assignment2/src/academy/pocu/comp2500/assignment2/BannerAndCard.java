package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class BannerAndCard extends Product {

    private ArrayList<TextAperture> textApertures;
    private ArrayList<ImageAperture> imageApertures;
    private final PrintOrientation orientation;

    protected BannerAndCard(ProductType type, RGB color, ProductSize size, int price, PrintOrientation orientation) {
        super(type, color, size, price);
        this.orientation = orientation;
    }

    public PrintOrientation getOrientation() {
        return this.orientation;
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

    public void addImageAperture(ImageAperture aperture) {
        if (aperture.getImagePath() == null) {
            return;
        }
        if (aperture.isValid(this)) {
            imageApertures.add(aperture);
            price += 5;
        }
    }

    public ArrayList<TextAperture> getAddedTexts() {
        return this.textApertures;
    }
    public ArrayList<ImageAperture> getAddedImagePaths() {
        return this.imageApertures;
    }
}
