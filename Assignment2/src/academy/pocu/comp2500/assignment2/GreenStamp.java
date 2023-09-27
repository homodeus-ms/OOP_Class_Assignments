package academy.pocu.comp2500.assignment2;

public class GreenStamp {
    private Stamp stamp;
    public GreenStamp(StampSize size) {
        this.stamp = new Stamp(size, new RGB(0x8000));
    }
    public Stamp getStamp() {
        return this.stamp;
    }
}
