package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class BusinessCard extends Product {
    private static final int LINEN_SINGLE_PRICE = 110;
    private static final int LINEN_DOUBLE_PRICE = 140;
    private static final int LAID_SINGLE_PRICE = 120;
    private static final int LAID_DOUBLE_PRICE = 150;
    private static final int SMOOTH_SINGLE_PRICE = 100;
    private static final int SMOOTH_DOUBLE_PRICE = 130;

    private final BusinessCardSides sides;
    private final PrintOrientation printOrientation;
    private final BusinessCardStock stock;


    private final ArrayList<TextAperture> textApertures;
    private final ArrayList<ImageAperture> imageApertures;


    public enum BusinessCardStock {
        LINEN(ProductType.BUSINESS_CARD_LINEN),
        LAID(ProductType.BUSINESS_CARD_LAID),
        SMOOTH(ProductType.BUSINESS_CARD_SMOOTH);

        private final ProductType productType;

        BusinessCardStock(ProductType type) {
            this.productType = type;
        }
        public ProductType getType() {
            return this.productType;
        }
    }
    public enum BusinessCardColor {
        GRAY(RGB.GRAY),
        IVORY(RGB.IVORY),
        WHITE(RGB.WHITE);

        private final RGB color;

        BusinessCardColor(RGB color) {
            this.color = color;
        }
        public RGB getColor() {
            return this.color;
        }
    }

    public enum BusinessCardSides {
        SINGLE_SIDED_BUSINESS_CARD,
        DOUBLE_SIDED_BUSINESS_CARD
    }

    public BusinessCard(BusinessCardStock stock, BusinessCardSides sides, BusinessCardColor color,
                        PrintOrientation orientation) {
        super(stock.getType(), color.getColor(), ProductSize.BUSINESS_CARD, getPrice(stock, sides));

        this.printOrientation = orientation;
        this.stock = stock;
        this.textApertures = new ArrayList<>();
        this.imageApertures = new ArrayList<>();
        this.sides = sides;

        //this.aperture = aperture;
        //this.textApertures.add(textAperture);
        //this.imageApertures.add(imageAperture);

    }


    public BusinessCardSides getSides() {
        return this.sides;
    }

    public PrintOrientation getPrintDirection() {
        return printOrientation;
    }

    public BusinessCardStock getCardType() {
        return this.stock;
    }

    public void addTextAperture(TextAperture aperture) {
        if (aperture.getElement() == null) {
            return;
        }
        if (aperture.isValid(this)) {
            textApertures.add(aperture);
            price += 5;
        }
    }

    public void addImageAperture(ImageAperture aperture) {
        if (aperture.getElement() == null) {
            return;
        }
        if (aperture.isValid(this)) {
            imageApertures.add(aperture);
            price += 5;
        }
    }

    public ArrayList<TextAperture> getAddedTexts() {
        return this.textApertures;
    }
    public ArrayList<ImageAperture> getAddedImagePaths() {
        return this.imageApertures;
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
    /*private static CardPaperType getPaperType(BusinessCardType type) {
        if (type == BusinessCardType.LINEN_BUSINESS_CARD) {
            return CardPaperType.LINEN;
        } else if (type == BusinessCardType.LAID_BUSINESS_CARD) {
            return CardPaperType.LAID;
        } else {
            return CardPaperType.SMOOTH;
        }
    }*/
}
