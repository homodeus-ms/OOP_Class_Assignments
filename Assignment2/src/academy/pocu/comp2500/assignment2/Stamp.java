package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {

    private static final int PRICE_4X3 = 2300;
    private static final int PRICE_5X2 = 2300;
    private static final int PRICE_7X4 = 2600;

    /*public static final RGB RED = RGB.RED;
    public static final RGB GREEN = RGB.GREEN;
    public static final RGB BLUE = RGB.BLUE;*/

    public enum StampColor {
        RED(RGB.RED),
        GREEN(RGB.GREEN),
        BLUE(RGB.BLUE);

        private final RGB color;

        StampColor(RGB color) {
            this.color = color;
        }
        public RGB getColor() {
            return this.color;
        }
    }

    private final String text;


    public Stamp(ProductSize size, StampColor color, String text) {
        super(getProductType(size), color.getColor(), size, getPrice(size));

        this.text = text;

    }
    public String getText() {
        return this.text;
    }


    private static int getPrice(ProductSize size) {
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

    private static ProductType getProductType(ProductSize size) {
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

}



