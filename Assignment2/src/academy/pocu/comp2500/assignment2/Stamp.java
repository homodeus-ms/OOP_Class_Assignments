package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
/*
    private static final int PRICE_4X3 = 2300;
    private static final int PRICE_5X2 = 2300;
    private static final int PRICE_7X4 = 2600;*/
    protected static final RGB RED = RGB.RED;
    protected static final RGB GREEN = RGB.GREEN;
    protected static final RGB BLUE = RGB.BLUE;


    private final StampSize stampSize;
    private final String text;

    protected Stamp(StampSize size, RGB color, String text) {
        super(getProductType(size), color, size.getWidthInMilli(),
                size.getHeightInMilli(), size.getPrice());

        this.text = text;
        stampSize = size;
    }
    public String getText() {
        return this.text;
    }

    /*private static RGB getRgbColor(StampColor color) {
        switch (color) {
            case RED:
                return RGB.RED;
            case GREEN:
                return RGB.GREEN;
            case BLUE:
                return RGB.BLUE;
            default:
                assert (false);
                return new RGB(0);
        }
    }*/

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



    /*private static int getWidth(StampSize size) {
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
    }*/
}



