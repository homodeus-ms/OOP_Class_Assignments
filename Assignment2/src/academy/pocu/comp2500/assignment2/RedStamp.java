package academy.pocu.comp2500.assignment2;

public class RedStamp {
    private Stamp stamp;
    public RedStamp(StampSize size) {
        stamp = new Stamp(size, new RGB(0xFF0000));
    }

    public Stamp getStamp() {
        return this.stamp;
    }
}
