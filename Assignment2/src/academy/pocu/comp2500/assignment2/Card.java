package academy.pocu.comp2500.assignment2;

public class Card extends BannerAndCard {

    private static final int LINEN_SINGLE_CARD_PRICE = 110;
    private static final int LINEN_DOUBLE_CARD_PRICE = 140;
    private static final int LAID_SINGLE_CARD_PRICE = 120;
    private static final int LAID_DOUBLE_CARD_PRICE = 150;
    private static final int SMOOTH_SINGLE_CARD_PRICE = 100;
    private static final int SMOOTH_DOUBLE_CARD_PRICE = 130;

    public enum StockType {
        LINEN(ProductType.LINEN_BUSINESS_CARD),
        LAID(ProductType.LAID_BUSINESS_CARD),
        SMOOTH(ProductType.SMOOTH_BUSINESS_CARD);

        private final ProductType productType;
        StockType(ProductType type) {
            this.productType = type;
        }

        public ProductType getProductType() {
            return productType;
        }
    }

    public enum SideType {
        SINGLE_SIDED,
        DOUBLE_SIDED
    }

    public enum BusinessCardColor {
        GRAY(Color.GRAY),
        WHITE(Color.WHITE),
        IVORY(Color.IVORY);

        private final Color color;
        BusinessCardColor(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
    }

    private final StockType stockType;
    private final SideType side;


    public Card(StockType stockType, SideType sides, BusinessCardColor color, PrintOrientation orientation) {
        super(stockType.getProductType(), color.getColor(), getPrice(stockType, sides), orientation);
        this.stockType = stockType;
        this.side = sides;
    }

    public StockType getStockType() {
        return stockType;
    }

    public SideType getSide() {
        return side;
    }

    private static int getPrice(StockType stockType, SideType sides) {
        switch (stockType) {
            case LINEN:
                return sides == SideType.SINGLE_SIDED ? LINEN_SINGLE_CARD_PRICE : LINEN_DOUBLE_CARD_PRICE;
            case LAID:
                return sides == SideType.SINGLE_SIDED ? LAID_SINGLE_CARD_PRICE : LAID_DOUBLE_CARD_PRICE;
            case SMOOTH:
                return sides == SideType.SINGLE_SIDED ? SMOOTH_SINGLE_CARD_PRICE : SMOOTH_DOUBLE_CARD_PRICE;
            default:
                assert (false);
                return -1;
        }
    }
}
