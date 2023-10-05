package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
public class BannerAndCard extends Product {

    /*private final ArrayList<TextAperture> textApertures;
    private final ArrayList<ImageAperture> imageApertures;*/
    private final ArrayList<Aperture> apertures;
    private final PrintOrientation orientation;

    protected BannerAndCard(ProductType type, RGB color, ProductSize size, int price, PrintOrientation orientation) {
        super(type, color, size, price);
        this.orientation = orientation;
        this.apertures = new ArrayList<>();
        /*textApertures = new ArrayList<>();
        imageApertures = new ArrayList<>();*/
    }

    public PrintOrientation getOrientation() {
        return this.orientation;
    }

    public void addAperture(Aperture aperture) {
        if (aperture.isValid(this)) {
            apertures.add(aperture);
            price += 5;
        }
    }
    public void removeAperture(int index) {
        if (index < 0 || index >= this.apertures.size()) {
            return;
        }
        this.apertures.remove(index);
        price -= 5;
    }

    /*public void addTextAperture(TextAperture aperture) {
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
    }*/
    public ArrayList<Aperture> getApertures() {
        return this.apertures;
    }

    /*public ArrayList<TextAperture> getAddedTexts() {
        return this.textApertures;
    }
    public ArrayList<ImageAperture> getAddedImagePaths() {
        return this.imageApertures;
    }*/
}
