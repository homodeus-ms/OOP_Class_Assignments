package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.*;
import academy.pocu.comp2500.assignment2.registry.Registry;

import java.sql.SQLOutput;

public class Program {

    public static void main(String[] args) {

        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        Product p1 = new Stamp(StampSize.STAMP_4X3, RGB.RED, "Stamp");


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
