package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.*;
import academy.pocu.comp2500.assignment2.registry.Registry;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        Product c1 = new BusinessCard(BusinessCard.BusinessCardType.LINEN_BUSINESS_CARD,
                BusinessCard.BusinessCardSides.SINGLE_SIDED_BUSINESS_CARD, BusinessCard.BusinessCardColor.GRAY, PrintOrientation.LANDSCAPE,100);
        assert (c1.getProductType() == ProductType.BUSINESS_CARD_LINEN);
        assert (c1.getWidth() == 90);
        assert (c1.getColor() == RGB.GRAY);
        assert (c1.getPrice() == 11000);



        System.out.println("No Assert!!!");
    }



    public static void testPrice(Stamp stamp, int price) {
        assert (stamp.getPrice() == price);
    }
}
