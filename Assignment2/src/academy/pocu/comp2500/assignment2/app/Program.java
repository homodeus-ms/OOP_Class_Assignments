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

        Product s1 = new Stamp(Stamp.StampSize.STAMP_4X3, Stamp.StampColor.RED, "RED");
        assert (s1.getColor() == RGB.RED);
        System.out.println(s1.getWidth());
        assert (s1.getWidth() == 40);
        assert (s1.getHeight() == 30);
        assert (s1.getPrice() == 2300);
        assert (((Stamp) s1).getText().equals("RED"));


        System.out.println("No Assert!!!");
    }



    public static void testPrice(Stamp stamp, int price) {
        assert (stamp.getPrice() == price);
    }
}
