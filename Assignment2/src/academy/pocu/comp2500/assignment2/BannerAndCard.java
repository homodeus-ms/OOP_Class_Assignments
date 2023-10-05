package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class BannerAndCard extends Product {
    public enum PrintOrientation {
        LANDSCAPE,
        PORTRAIT
    }
    private final PrintOrientation orientation;
    private final ArrayList<Aperture> apertures;

    protected BannerAndCard(ProductType type, Color color, int price, PrintOrientation orientation) {
        super(type, color, price);
        this.orientation = orientation;
        this.apertures = new ArrayList<>();
    }

    public PrintOrientation getOrientation() {
        return orientation;
    }

    public ArrayList<Aperture> getApertures() {
        return apertures;
    }

    public void addAperture(Aperture aperture) {
        if (aperture.isApertureValid(this)) {
            this.apertures.add(aperture);
            price += 5;
        }
    }
    public void removeAperture(int index) {
        if (index >= 0 && index < apertures.size()) {
            this.apertures.remove(index);
            price -= 5;
        }
    }
}
