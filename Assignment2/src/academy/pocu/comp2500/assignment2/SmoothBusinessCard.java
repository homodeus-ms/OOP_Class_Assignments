package academy.pocu.comp2500.assignment2;

public class SmoothBusinessCard extends BusinessCard {

    public SmoothBusinessCard(BusinessCardSides sides, RGB color,
                              PrintOrientation orientation, TextAperture aperture) {
        super(BusinessCardType.SMOOTH_BUSINESS_CARD, sides, color, orientation, aperture);
    }
}
