package academy.pocu.comp2500.assignment2;

public class Aperture {
    private final int x;
    private final int y;
    private final int apertureWidth;
    private final int apertureHeight;
    private final String element;

    protected Aperture(int x, int y, int width, int height, String element) {
        this.x = x;
        this.y = y;
        this.apertureWidth = width;
        this.apertureHeight = height;
        this.element = element;
    }

    public String getElement() {
        return this.element;
    }

    public boolean isValid(Product product) {

        assert (this.apertureWidth > 0 && this.apertureHeight > 0);

        int productWidth = product.getProductSize().getWidthInMilli();
        int productHeight = product.getProductSize().getHeightInMilli();
        int landscapeSize = x + apertureWidth;
        int horizontalSize = y + apertureHeight;

        if (x > 0 && x < productWidth && y > 0 && y < productHeight) {
            return true;
        } else if (landscapeSize > 0 && horizontalSize > 0 &&
                landscapeSize <= productWidth && horizontalSize <= productHeight) {
            return true;
        }
        return false;
    }
}
