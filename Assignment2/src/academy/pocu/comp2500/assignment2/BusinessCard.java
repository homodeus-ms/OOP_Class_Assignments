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

    private final PrintOrientation printOrientation;
    private final CardPaperType paperType;

    private final ArrayList<TextAperture> textApertures;
    private final ArrayList<ImageAperture> imageApertures;

    public BusinessCard(BusinessCardType cardType, RGB color, PrintOrientation orientation, String text) {
        super(getProductType(cardType), color, WIDTH_IN_MILLI, HEIGHT_IN_MILLI, getPrice(cardType), text);
        this.printOrientation = orientation;
        this.paperType = getPaperType(cardType);
        this.textApertures = new ArrayList<>();
        this.imageApertures = new ArrayList<>();
    }

    public PrintOrientation getPrintDirection() {
        return printOrientation;
    }

    public CardPaperType getPaperType() {
        return paperType;
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
        if (type == BusinessCardType.LINEN_SINGLE || type == BusinessCardType.LINEN_DOUBLE) {
            return ProductType.BUSINESS_CARD_LINEN;
        } else if (type == BusinessCardType.LAID_SINGLE || type == BusinessCardType.LAID_DOUBLE) {
            return ProductType.BUSINESS_CARD_LAID;
        } else {
            return ProductType.BUSINESS_CARD_SMOOTH;
        }
    }

    private static int getPrice(BusinessCardType cardType) {
        switch (cardType) {
            case LINEN_SINGLE:
                return LINEN_SINGLE_PRICE;
            case LINEN_DOUBLE:
                return LINEN_DOUBLE_PRICE;
            case LAID_SINGLE:
                return LAID_SINGLE_PRICE;
            case LAID_DOUBLE:
                return LAID_DOUBLE_PRICE;
            case SMOOTH_SINGLE:
                return SMOOTH_SINGLE_PRICE;
            case SMOOTH_DOUBLE:
                return SMOOTH_DOUBLE_PRICE;
            default:
                assert (false);
                return -1;
        }
    }
    private static CardPaperType getPaperType(BusinessCardType type) {
        if (type == BusinessCardType.LINEN_SINGLE || type == BusinessCardType.LINEN_DOUBLE) {
            return CardPaperType.LINEN;
        } else if (type == BusinessCardType.LAID_SINGLE || type == BusinessCardType.LAID_DOUBLE) {
            return CardPaperType.LAID;
        } else {
            return CardPaperType.SMOOTH;
        }
    }
}
