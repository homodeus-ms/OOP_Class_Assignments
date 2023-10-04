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

        Product b1 = new Banner(Banner.BannerType.GLOSS, Banner.BannerSize.LARGE, new RGB(10, 20, 30), PrintOrientation.LANDSCAPE);
        Product b2 = new Banner(Banner.BannerType.SCRIM, Banner.BannerSize.LARGE, new RGB(10, 20, 30), PrintOrientation.LANDSCAPE);

        assert (b1.getColor().equals(b2.getColor()));

        System.out.println("No Assert!!!");
    }



    public static void testPrice(Stamp stamp, int price) {
        assert (stamp.getPrice() == price);
    }
}
