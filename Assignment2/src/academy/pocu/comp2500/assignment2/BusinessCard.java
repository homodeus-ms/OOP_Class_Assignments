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
    private ArrayList<String> addedTexts;
    private ArrayList<String> addedImagePaths;

    public BusinessCard(BusinessCardType cardType, ColorType color, PrintOrientation orientation) {
        super(ProductType.BUSINESS_CARD, color, WIDTH_IN_MILLI, HEIGHT_IN_MILLI, getPrice(cardType));
        this.printOrientation = orientation;
        this.paperType = getPaperType(cardType);
        this.addedTexts = new ArrayList<>();
        this.addedImagePaths = new ArrayList<>();
    }

    public PrintOrientation getPrintDirection() {
        return printOrientation;
    }

    public CardPaperType getPaperType() {
        return paperType;
    }
    public void addText(String text) {
        this.addedTexts.add(text);
    }
    public void addImagePath(String imagePath) {
        this.addedImagePaths.add(imagePath);
    }
    public ArrayList<String> getAddedTexts() {
        return this.addedTexts;
    }
    public ArrayList<String> getAddedImagePaths() {
        return this.addedImagePaths;
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
