package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.*;
import academy.pocu.comp2500.assignment2.registry.Registry;

import java.sql.SQLOutput;

public class Program {

    public static void main(String[] args) {

        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        Product p1 = new BusinessCard(BusinessCardType.LINEN_BUSINESS_CARD, BusinessCardSides.DOUBLE_SIDED_CARD,
                BusinessCardColorType.GRAY, PrintOrientation.LANDSCAPE, new TextAperture(0, 0, 1, 1, "wegui"));

        System.out.printf("p1: %s, %s, %s, %s, %s\n", p1.getProductType(), p1.getColor(),
                ((BusinessCard) p1).getSides(), ((BusinessCard) p1).getPrintDirection(), p1.getText());



        System.out.println("No Assert!!!");
    }



    public static void testSize(Stamp stamp, int widthInMilli, int heightInMilli) {
        assert (stamp.getWidthInMilli() == widthInMilli);
        assert (stamp.getHeightInMilli() == heightInMilli);
    }
    public static void testPrice(Stamp stamp, int price) {
        assert (stamp.getPrice() == price);
    }
}
