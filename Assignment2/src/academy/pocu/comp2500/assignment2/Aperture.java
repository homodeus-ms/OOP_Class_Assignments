package academy.pocu.comp2500.assignment2;

public class Aperture {
    private final int x;
    private final int y;
    private final int apertureWidth;
    private final int apertureHeight;

    protected Aperture(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.apertureWidth = width;
        this.apertureHeight = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getApertureWidth() {
        return apertureWidth;
    }

    public int getApertureHeight() {
        return apertureHeight;
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
    public void addApertureToBanner(Banner banner) {
        if (!this.isValid(banner)) {
            return;
        }
        banner.getApertures().add(this);
        banner.price += 5;
    }
    public void addApertureToCard(BusinessCard card) {
        if (!this.isValid(card)) {
            return;
        }
        card.getApertures().add(this);
        card.price += 5 * card.getStock();
    }
}
