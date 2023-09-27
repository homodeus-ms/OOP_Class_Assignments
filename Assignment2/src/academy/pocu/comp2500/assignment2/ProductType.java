package academy.pocu.comp2500.assignment2;

public enum ProductType {
    STAMP_4X3("STAMP (4 x 3)"),
    STAMP_5X2("STAMP (5 x 2)"),
    STAMP_7X4("STAMP (7 x 4)"),
    CALENDAR_WALL("Wall Calendar"),
    CALENDAR_DESK("Desk Calendar"),
    CALENDAR_MAGNET("Magnet Calendar"),
    BANNER_GLOSS("Gloss Banner"),
    BANNER_SCRIM("Scrim Banner"),
    BANNER_MESH("Mesh Banner"),
    BUSINESS_CARD_LINEN("Linen Business Card"),
    BUSINESS_CARD_LAID("Laid Business Card"),
    BUSINESS_CARD_SMOOTH("Smooth Business Card"),
    DEFAULT("EMPTY");


    private String name;

    ProductType(String name) {

    }
    public String getName() {
        return this.name;
    }

}
