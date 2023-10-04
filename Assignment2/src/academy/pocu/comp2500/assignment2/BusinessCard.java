package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class BusinessCard extends Product {
    private static final int LINEN_SINGLE_PRICE = 110;
    private static final int LINEN_DOUBLE_PRICE = 140;
    private static final int LAID_SINGLE_PRICE = 120;
    private static final int LAID_DOUBLE_PRICE = 150;
    private static final int SMOOTH_SINGLE_PRICE = 100;
    private static final int SMOOTH_DOUBLE_PRICE = 130;

    private static final int WIDTH_IN_MILLI = 90;
    private static final int HEIGHT_IN_MILLI = 50;

    private final BusinessCardSides sides;
    private final PrintOrientation printOrientation;
    private final CardPaperType paperType;
    //private final Aperture aperture;
    private final int stock;
    private final ArrayList<TextAperture> textApertures;
    private final ArrayList<ImageAperture> imageApertures;

    public enum BusinessCardType {
        LINEN_BUSINESS_CARD(ProductType.BUSINESS_CARD_LINEN),
        LAID_BUSINESS_CARD(ProductType.BUSINESS_CARD_LAID),
        SMOOTH_BUSINESS_CARD(ProductType.BUSINESS_CARD_SMOOTH);

        private final ProductType productType;

        BusinessCardType(ProductType type) {
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
        SINGLE_SIDED_CARD,
        DOUBLE_SIDED_CARD
    }


    public BusinessCard(BusinessCardType cardType, BusinessCardSides sides, BusinessCardColor color,
                        PrintOrientation orientation, int stock) {
        super(cardType.getType(), color.getColor(), ProductSize.BUSINESS_CARD, getPrice(cardType, sides) * stock);
        this.sides = sides;
        this.printOrientation = orientation;
        this.paperType = getPaperType(cardType);
        this.textApertures = new ArrayList<>();
        this.imageApertures = new ArrayList<>();
        this.stock = stock;
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

    public CardPaperType getPaperType() {
        return paperType;
    }

    public int getStock() {
        return this.stock;
    }

    public void addText(TextAperture aperture) {
        if (aperture.getText() == null) {
            return;
        }
        if (aperture.isValid(this)) {
            textApertures.add(aperture);
            price += 5;
        }
    }

    public void addImagePath(ImageAperture aperture) {
        if (aperture.getImagePath() == null) {
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

    private static ProductType getProductType(BusinessCardType type) {
        if (type == BusinessCardType.LINEN_BUSINESS_CARD) {
            return ProductType.BUSINESS_CARD_LINEN;
        } else if (type == BusinessCardType.LAID_BUSINESS_CARD) {
            return ProductType.BUSINESS_CARD_LAID;
        } else {
            return ProductType.BUSINESS_CARD_SMOOTH;
        }
    }

    /*private static RGB getColor(BusinessCardColorType color) {
        switch (color) {
            case GRAY:
                return RGB.GRAY;
            case IVORY:
                return RGB.IVORY;
            case WHITE:
                return RGB.WHITE;
            default:
                assert (false);
                return RGB.CUSTOM;
        }
    }*/

    private static int getPrice(BusinessCardType cardType, BusinessCardSides sides) {
        switch (cardType) {
            case LINEN_BUSINESS_CARD:
                return sides == BusinessCardSides.SINGLE_SIDED_CARD ? LINEN_SINGLE_PRICE : LINEN_DOUBLE_PRICE;
            case LAID_BUSINESS_CARD:
                return sides == BusinessCardSides.SINGLE_SIDED_CARD ? LAID_SINGLE_PRICE : LAID_DOUBLE_PRICE;
            case SMOOTH_BUSINESS_CARD:
                return sides == BusinessCardSides.SINGLE_SIDED_CARD ? SMOOTH_SINGLE_PRICE : SMOOTH_DOUBLE_PRICE;
            default:
                assert (false);
                return -1;
        }
    }
    private static CardPaperType getPaperType(BusinessCardType type) {
        if (type == BusinessCardType.LINEN_BUSINESS_CARD) {
            return CardPaperType.LINEN;
        } else if (type == BusinessCardType.LAID_BUSINESS_CARD) {
            return CardPaperType.LAID;
        } else {
            return CardPaperType.SMOOTH;
        }
    }
}
