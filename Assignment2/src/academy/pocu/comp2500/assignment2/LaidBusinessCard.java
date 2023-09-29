package academy.pocu.comp2500.assignment2;

public class LaidBusinessCard extends BusinessCard {
    public LaidBusinessCard(BusinessCardSides sides, RGB color,
                            PrintOrientation orientation, TextAperture aperture) {
        super(BusinessCardType.LAID_BUSINESS_CARD, sides, color, orientation, aperture);
    }
}
