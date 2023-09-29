package academy.pocu.comp2500.assignment2;

public class LinenBusinessCard extends BusinessCard {
    public LinenBusinessCard(BusinessCardSides sides, RGB color,
                             PrintOrientation orientation, TextAperture aperture) {
        super(BusinessCardType.LINEN_BUSINESS_CARD, sides, color, orientation, aperture);
    }
}
