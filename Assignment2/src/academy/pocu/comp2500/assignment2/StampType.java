package academy.pocu.comp2500.assignment2;

public class StampType {

    private StampColor color;
    private StampSize size;

    public StampType(StampColor color, StampSize size) {
        this.color = color;
        this.size = size;
    }

    public StampColor getColor() {
        return this.color;
    }

    /*public ColorType getColor() {
        switch (this.color) {
            case RED:
                return ColorType.RED;
            case GREEN:
                return ColorType.GREEN;
            case BLUE:
                return ColorType.BLUE;
            default:
                assert (false);
                return ColorType.CUSTOM;
        }
    }*/

    public StampSize getSize() {
        return size;
    }

}
