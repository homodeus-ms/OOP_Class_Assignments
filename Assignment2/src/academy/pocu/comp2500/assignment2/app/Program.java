package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.*;
import academy.pocu.comp2500.assignment2.registry.Registry;

public class Program {

    public static void main(String[] args) {

        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

	    Stamp red = new Stamp(StampType.RED_STAMP, StampSize.STAMP_4X3);
        assert (red.getColor() == 0xFF0000);
        testSize(red, 400, 300);
        testPrice(red, 2300);
        System.out.println(red.getShippingMethod());
        System.out.printf("red : %x\n", red.getColor());


        Stamp green = new Stamp(StampType.GREEN_STAMP, StampSize.STAMP_5X2);

        System.out.printf("green : %x\n", green.getColor());
        //assert (green.getColor() == 0x8000);
        testSize(green, 500, 200);
        testPrice(green, 2300);

        Stamp blue = new Stamp(StampType.BLUE_STAMP, StampSize.STAMP_7X4);
        assert (blue.getColor() == 0xFF);
        testSize(blue, 700, 400);
        testPrice(blue, 2600);

        Cart cart1 = new Cart();
        cart1.addProduct(red);
        cart1.addProduct(green);
        cart1.addProduct(blue);

        System.out.println(cart1.getTotalPrice());

        cart1.removeProduct(green);
        cart1.setShippingMethods(red, ShippingMethod.PICKUP);
        System.out.println(cart1.getTotalPrice());
        System.out.println(cart1.getShippingMethod(0));
        System.out.println(cart1.getProducts().get(0).getColor());

        System.out.println("No Assert!");
    }





    public static void testSize(Stamp stamp, int widthInMilli, int heightInMilli) {
        assert (stamp.getWidthInMilli() == widthInMilli);
        assert (stamp.getHeightInMilli() == heightInMilli);
    }
    public static void testPrice(Stamp stamp, int price) {
        assert (stamp.getPrice() == price);
    }
}
