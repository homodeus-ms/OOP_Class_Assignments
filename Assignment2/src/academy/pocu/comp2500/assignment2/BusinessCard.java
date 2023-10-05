package academy.pocu.comp2500.assignment2;

public class BusinessCard extends BannerAndCard {
    private static final int LINEN_SINGLE_PRICE = 110;
    private static final int LINEN_DOUBLE_PRICE = 140;
    private static final int LAID_SINGLE_PRICE = 120;
    private static final int LAID_DOUBLE_PRICE = 150;
    private static final int SMOOTH_SINGLE_PRICE = 100;
    private static final int SMOOTH_DOUBLE_PRICE = 130;

    private final BusinessCardSides sides;
    private final BusinessCardStock stock;

    public BusinessCard(BusinessCardStock stock, BusinessCardSides sides, BusinessCardColor color,
                        PrintOrientation orientation) {
        super(stock.getType(), color.getColor(), ProductSize.BUSINESS_CARD, getPrice(stock, sides), orientation);

        this.stock = stock;
        this.sides = sides;
    }

    public BusinessCardSides getSides() {
        return this.sides;
    }

    public BusinessCardStock getCardType() {
        return this.stock;
    }


    private static ProductType getProductType(BusinessCardStock stock) {
        if (stock == BusinessCardStock.LINEN) {
            return ProductType.BUSINESS_CARD_LINEN;
        } else if (stock == BusinessCardStock.LAID) {
            return ProductType.BUSINESS_CARD_LAID;
        } else {
            return ProductType.BUSINESS_CARD_SMOOTH;
        }
    }

    private static int getPrice(BusinessCardStock stock, BusinessCardSides sides) {

        int result;
        switch (stock) {
            case LINEN:
                result = sides == BusinessCardSides.SINGLE_SIDED_BUSINESS_CARD ? LINEN_SINGLE_PRICE : LINEN_DOUBLE_PRICE;
                break;
            case LAID:
                result = sides == BusinessCardSides.SINGLE_SIDED_BUSINESS_CARD ? LAID_SINGLE_PRICE : LAID_DOUBLE_PRICE;
                break;
            case SMOOTH:
                result = sides == BusinessCardSides.SINGLE_SIDED_BUSINESS_CARD ? SMOOTH_SINGLE_PRICE : SMOOTH_DOUBLE_PRICE;
                break;
            default:
                assert (false);
                return -1;
        }

        return result;
    }
}
