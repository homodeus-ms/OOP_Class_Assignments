package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.*;
import academy.pocu.comp2500.assignment2.registry.Registry;

public class Program {

    public static void main(String[] args) {

        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        Product p1 = new Stamp(StampSize.STAMP_4X3, StampColor.RED);
        ((Stamp) p1).setText("This is Red 4x3 Stamp");

        Product p2 = new Stamp(StampSize.STAMP_7X4, StampColor.BLUE);
        ((Stamp)p2).setText("This is Blue 7x4 Stamp");

        System.out.printf("p1\n%s, %x, %d, %d, %d\ntext: %s\n", p1.getProductType(), p1.getColorValue(),
                p1.getWidthInMilli(), p1.getHeightInMilli(), p1.getPrice(), p1.getText());
        System.out.printf("p2\n%s, %x, %d, %d, %d\ntext: %s\n", p2.getProductType(), p2.getColorValue(),
                p2.getWidthInMilli(), p2.getHeightInMilli(), p2.getPrice(), p2.getText());

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
