package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture {
    private final String imagePath;
    public ImageAperture(int x, int y, int width, int height, String imagePath) {
        super(x, y, width, height);
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return this.imagePath;
    }
}
