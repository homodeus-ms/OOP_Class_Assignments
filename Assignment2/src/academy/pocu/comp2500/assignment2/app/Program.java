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

        RGB c1 = new RGB(0xFF, 0x44, 0x80);

        Product card1 = new BusinessCard(BusinessCard.BusinessCardType.LINEN_BUSINESS_CARD,
                BusinessCard.BusinessCardSides.DOUBLE_SIDED_BUSINESS_CARD, BusinessCard.BusinessCardColor.WHITE, PrintOrientation.PORTRAIT, 50);
        System.out.println(card1.getWidth());
        System.out.println(card1.getPrice());
        System.out.println(card1.getProductType());
        System.out.println(card1.getProductSize());
        System.out.println();
        System.out.println(((BusinessCard)card1).getCardType());
        System.out.println(((BusinessCard)card1).getSides());
        System.out.println("No Assert!!!");
    }



    public static void testPrice(Stamp stamp, int price) {
        assert (stamp.getPrice() == price);
    }
}
