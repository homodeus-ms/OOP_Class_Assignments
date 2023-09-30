package academy.pocu.comp2500.assignment2;

public enum ProductType {
    STAMP_4X3("STAMP (40mm x 30mm)"),
    STAMP_5X2("STAMP (50mm x 20mm)"),
    STAMP_7X4("STAMP (70mm x 40mm)"),
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


    private final String displayName;

    ProductType(String name) {
        this.displayName = name;
    }
    public String getName() {
        return this.displayName;
    }

}
