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
    private final BusinessCardType cardType;
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
        SINGLE_SIDED_BUSINESS_CARD,
        DOUBLE_SIDED_BUSINESS_CARD
    }

    public BusinessCard(BusinessCardType cardType, BusinessCardSides sides, BusinessCardColor color,
                        PrintOrientation orientation, int stock) {
        super(cardType.getType(), color.getColor(), ProductSize.BUSINESS_CARD, getPrice(cardType, sides));

        this.printOrientation = orientation;
        this.cardType = cardType;
        this.textApertures = new ArrayList<>();
        this.imageApertures = new ArrayList<>();
        this.sides = sides;
        this.stock = stock;
        //this.aperture = aperture;
        //this.textApertures.add(textAperture);
        //this.imageApertures.add(imageAperture);

    }

    public int getStock() {
        return this.stock;
    }
    public BusinessCardSides getSides() {
        return this.sides;
    }

    public PrintOrientation getPrintDirection() {
        return printOrientation;
    }

    public BusinessCardType getCardType() {
        return cardType;
    }

    public void addTextAperture(TextAperture aperture) {
        if (aperture.getText() == null) {
            return;
        }
        if (aperture.isValid(this)) {
            textApertures.add(aperture);
            price += 5;
        }
    }

    public void addImageAperture(ImageAperture aperture) {
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

    private static int getPrice(BusinessCardType cardType, BusinessCardSides sides) {

        int result;
        switch (cardType) {
            case LINEN_BUSINESS_CARD:
                result = sides == BusinessCardSides.SINGLE_SIDED_BUSINESS_CARD ? LINEN_SINGLE_PRICE : LINEN_DOUBLE_PRICE;
                break;
            case LAID_BUSINESS_CARD:
                result =  sides == BusinessCardSides.SINGLE_SIDED_BUSINESS_CARD ? LAID_SINGLE_PRICE : LAID_DOUBLE_PRICE;
                break;
            case SMOOTH_BUSINESS_CARD:
                result =  sides == BusinessCardSides.SINGLE_SIDED_BUSINESS_CARD ? SMOOTH_SINGLE_PRICE : SMOOTH_DOUBLE_PRICE;
                break;
            default:
                assert (false);
                return -1;
        }

        return result;
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
