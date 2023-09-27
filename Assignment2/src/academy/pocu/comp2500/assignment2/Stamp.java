package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private static final int PRICE_4X3 = 2300;
    private static final int PRICE_5X2 = 2300;
    private static final int PRICE_7X4 = 2600;

    private final StampType stampType;
    private final StampSize stampSize;

    protected Stamp(StampType type, StampSize size) {
        super(ProductType.STAMP, getColor(type), getWidth(size), getHeight(size), getPrice(size));
        this.stampType = type;
        this.stampSize = size;
    }

    public StampType getStampType() {
        return this.stampType;
    }
    public StampSize getStampSize() {
        return this.stampSize;
    }

    private static ColorType getColor(StampType type) {
        switch (type) {
            case RED_STAMP:
                return ColorType.RED;
            case GREEN_STAMP:
                return ColorType.GREEN;
            case BLUE_STAMP:
                return ColorType.BLUE;
            default:
                assert (false);
                return ColorType.CUSTOM;
        }
    }

    private static int getWidth(StampSize size) {
        switch (size) {
            case STAMP_4X3:
                return 400;
            case STAMP_5X2:
                return 500;
            case STAMP_7X4:
                return 700;
            default:
                assert (false);
                return -1;
        }
    }
    private static int getHeight(StampSize size) {
        switch (size) {
            case STAMP_4X3:
                return 300;
            case STAMP_5X2:
                return 200;
            case STAMP_7X4:
                return 400;
            default:
                assert (false);
                return -1;
        }
    }
    private static int getPrice(StampSize size) {
        switch (size) {
            case STAMP_4X3:
                return PRICE_4X3;
            case STAMP_5X2:
                return PRICE_5X2;
            case STAMP_7X4:
                return PRICE_7X4;
            default:
                assert (false);
                return -1;
        }
    }
}
