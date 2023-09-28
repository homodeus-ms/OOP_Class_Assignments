package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {

    private static final int PRICE_4X3 = 2300;
    private static final int PRICE_5X2 = 2300;
    private static final int PRICE_7X4 = 2600;


    private final StampSize stampSize;
    private final StampColor stampColor;

    public Stamp(StampSize size, StampColor color, String text) {
        super(getProductType(size), color.getColor(), getWidth(size), getHeight(size), getPrice(size), text);
        stampColor = color;
        stampSize = size;
    }

    public StampColor getStampColor() {
        return this.stampColor;
    }

    private static ProductType getProductType(StampSize size) {
        switch (size) {
            case STAMP_4X3:
                return ProductType.STAMP_4X3;
            case STAMP_5X2:
                return ProductType.STAMP_5X2;
            case STAMP_7X4:
                return ProductType.STAMP_7X4;
            default:
                assert (false);
                return ProductType.DEFAULT;
        }
    }

    /*private static String getStampName(StampSize size) {
        switch (size) {
            case STAMP_4X3:
                return "STAMP (4 x 3)";
            case STAMP_5X2:
                return "STAMP (5 x 2)";
            case STAMP_7X4:
                return "STAMP (7 x 4)";
            default:
                assert (false);
                return "";
        }
    }*/

    public StampSize getStampSize() {
        return this.stampSize;
    }

    private static RGB getColor(StampColor color) {
        switch (color) {
            case RED:
                return new RGB(0xFF0000);
            case GREEN:
                return new RGB(0x8000);
            case BLUE:
                return new RGB(0xFF);
            default:
                assert (false);
                return new RGB(-1);
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



