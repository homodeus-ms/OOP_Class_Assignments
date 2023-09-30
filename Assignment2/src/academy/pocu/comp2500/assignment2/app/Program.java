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

        /*Product stamp = new Stamp(StampSize.STAMP_4X3, StampColor.RED, "1");
        Stamp stamp2 = new Stamp(StampSize.STAMP_5X2, StampColor.RED, "2");

        System.out.println(stamp.getColor());*/


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
