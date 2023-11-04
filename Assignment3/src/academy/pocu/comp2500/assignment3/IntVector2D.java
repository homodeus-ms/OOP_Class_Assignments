package academy.pocu.comp2500.assignment3;

public class IntVector2D {

    public static final int X_MAX = 0xF;
    public static final int Y_MAX = 0x7;
    public static final IntVector2D DEFAULT_VECTOR = new IntVector2D(-1, -1);

    private int x;
    private int y;

    public IntVector2D(int x, int y) {
        /*this.x = Math.max(0, Math.min(X_MAX, x));
        this.y = Math.max(0, Math.min(Y_MAX, y));*/
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getDistance(IntVector2D obj) {
        return Math.sqrt(Math.pow((this.x - obj.x), 2) + Math.pow((this.y - obj.y), 2));
    }

    public int getManhattanDistance(IntVector2D obj) {
        return Math.abs(this.x - obj.x) + Math.abs(this.y - obj.y);
    }


    public boolean equals(IntVector2D other) {
        if (this == other) {
            return true;
        }

        return (this.x == other.x) && (this.y == other.y);
    }
    public void makeDeepCopy(IntVector2D other) {
        if (other == null) {
            this.x = 0;
            this.y = 0;
        }
        this.x = other.x;
        this.y = other.y;
    }
}