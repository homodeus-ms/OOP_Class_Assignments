package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private static final int PRICE_4X3 = 2300;
    private static final int PRICE_5X2 = 2300;
    private static final int PRICE_7X4 = 2600;

    private StampType stampType;


    public Stamp(StampType type) {
        super(getProductType(type), getColor(type.getColor()), getWidth(type.getSize()), getHeight(type.getSize()), getPrice(type.getSize()));
        this.stampType = type;
    }

    public StampType getStampType() {
        return this.stampType;
    }


    private static ProductType getProductType(StampType type) {
        if (type.getSize() == StampSize.STAMP_4X3) {
            return ProductType.STAMP_4X3;
        } else if (type.getSize() == StampSize.STAMP_5X2) {
            return ProductType.STAMP_5X2;
        } else {
            return ProductType.STAMP_7X4;
        }
    }

    private static ColorType getColor(StampColor color) {
        switch (color) {
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
