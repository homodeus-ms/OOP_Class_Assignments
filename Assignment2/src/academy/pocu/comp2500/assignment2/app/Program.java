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

        Banner b1 = new Banner(Banner.BannerType.GLOSS, Banner.BannerSize.LARGE, c1, PrintOrientation.LANDSCAPE);

        System.out.println(b1.getColor().getR() == 0xff);
        System.out.println(b1.getColor().getG() == 0x44);
        System.out.println(b1.getColor().getB() == 0x80);
        System.out.println("No Assert!!!");
    }



    public static void testPrice(Stamp stamp, int price) {
        assert (stamp.getPrice() == price);
    }
}
