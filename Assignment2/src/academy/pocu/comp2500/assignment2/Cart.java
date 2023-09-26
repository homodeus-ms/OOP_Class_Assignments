package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {

    private static final ShippingType DEFAULT_SHIPPING_METHOD = ShippingType.SHIPPING;

    private ArrayList<Product> cart;
    private int itemCount;
    private ArrayList<ShippingType> shippingMethods;
    private int totalPrice;

    public Cart() {
        cart = new ArrayList<>();
        shippingMethods = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return cart;
    }
    public ShippingType getShippingMethod(int index) {
        return shippingMethods.get(index);
    }

    public void setShippingMethods(Product product, ShippingType shippingMethod) {
        for (int i = 0; i < itemCount; ++i) {
            if (cart.get(i) == product) {
                shippingMethods.set(i, shippingMethod);
                break;
            }
        }
    }

    public void addProduct(Product product) {
        cart.add(product);
        this.shippingMethods.add(DEFAULT_SHIPPING_METHOD);
        totalPrice += product.getPrice();
        ++itemCount;
    }

    public void removeProduct(Product product) {

        for (int i = 0; i < itemCount; ++i) {
            if (cart.get(i) == product) {
                shippingMethods.remove(i);
                cart.remove(i);
                break;
            }
        }

        totalPrice -= product.getPrice();
        --itemCount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
