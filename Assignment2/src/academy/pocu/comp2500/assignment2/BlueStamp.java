package academy.pocu.comp2500.assignment2;

public class BlueStamp {
    private Stamp stamp;
    public BlueStamp(StampSize size) {
        stamp = new Stamp(size, new RGB(0xFF));
    }
    public Stamp getStamp() {
        return this.stamp;
    }
}
