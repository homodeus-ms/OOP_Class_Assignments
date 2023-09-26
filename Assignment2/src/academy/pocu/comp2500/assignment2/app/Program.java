package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.*;
import academy.pocu.comp2500.assignment2.registry.Registry;

public class Program {

    public static void main(String[] args) {

        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

	    Stamp red = new Stamp(StampType.RED_4X3);
        testColor(red, ColorType.RED);
        testSize(red, 400, 300);
        testPrice(red, 2300);

        Stamp green = new Stamp(StampType.GREEN_5X2);
        testColor(green, ColorType.GREEN);
        testSize(green, 500, 200);
        testPrice(green, 2300);

        Stamp blue = new Stamp(StampType.BLUE_7X4);
        testColor(blue, ColorType.BLUE);
        testSize(blue, 700, 400);
        testPrice(blue, 2600);

        Cart cart1 = new Cart();
        cart1.addProduct(red);
        cart1.addProduct(green);
        cart1.addProduct(blue);

        System.out.println(cart1.getTotalPrice());

        cart1.removeProduct(green);
        cart1.setShippingMethods(red, ShippingType.PICKUP);
        System.out.println(cart1.getTotalPrice());
        System.out.println(cart1.getShippingMethod(0));
        System.out.println(cart1.getProducts().get(0).getColor());

        System.out.println("No Assert!");
    }




    public static void testColor(Stamp stamp, ColorType type) {
        assert (stamp.getColor().getR() == type.getR());
        assert (stamp.getColor().getG() == type.getG());
        assert (stamp.getColor().getB() == type.getB());
    }
    public static void testSize(Stamp stamp, int widthInMilli, int heightInMilli) {
        assert (stamp.getWidthInMilli() == widthInMilli);
        assert (stamp.getHeightInMilli() == heightInMilli);
    }
    public static void testPrice(Stamp stamp, int price) {
        assert (stamp.getPrice() == price);
    }
}
